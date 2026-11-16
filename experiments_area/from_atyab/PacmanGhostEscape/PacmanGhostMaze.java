import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Pacman ghost maze solver.
 *
 * The ghost starts at '@', explores the maze using depth-first search with an
 * explicit stack, leaves a '-' trail behind it, and backtracks out of dead ends
 * until it reaches 'E'.
 *
 * map.txt format: a 50x50 (or smaller) grid using
 *   0 = wall / no path
 *   1 = open path
 *   @ = ghost start
 *   E = exit
 */
public class PacmanGhostMaze {

    private static final int SIZE = 50;

    private static final char WALL = '0';
    private static final char OPEN = '1';
    private static final char GHOST = '@';
    private static final char EXIT = 'E';
    private static final char TRAIL = '-';

    /** Up, right, down, left. */
    private static final int[][] DIRECTIONS = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    private record Cell(int row, int col) {
    }

    private record Maze(char[][] grid, Cell start, Cell exit) {
    }

    private record Bounds(int minRow, int maxRow, int minCol, int maxCol) {
    }

    public static void main(String[] args) {
        int delayMs = 1000;
        boolean ansi = detectAnsi();

        for (String arg : args) {
            if (arg.equals("--help")) {
                printUsage();
                return;
            } else if (arg.equals("--no-ansi")) {
                ansi = false;
            } else if (arg.startsWith("--delay=")) {
                String value = arg.substring("--delay=".length());
                try {
                    delayMs = Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid delay: " + value);
                    printUsage();
                    return;
                }
                if (delayMs < 0) {
                    System.err.println("Delay cannot be negative.");
                    return;
                }
            } else {
                System.err.println("Unknown option: " + arg);
                printUsage();
                return;
            }
        }

        try {
            Maze maze = loadMap(Path.of("map.txt"));
            run(maze, delayMs, ansi);
        } catch (IOException e) {
            System.err.println("Could not load map.txt: " + e.getMessage());
            System.err.println("Create a 50x50 map.txt next to this program using 0, 1, @ and E.");
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid map: " + e.getMessage());
        }
    }

    private static void run(Maze maze, int delayMs, boolean ansi) {
        char[][] grid = maze.grid();

        boolean[][] walkable = new boolean[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                walkable[row][col] = grid[row][col] != WALL;
            }
        }

        Bounds bounds = computeBounds(grid);
        boolean[][] visited = new boolean[SIZE][SIZE];

        // The stack holds the current path from the start to the ghost.
        // push = move forward, pop = backtrack.
        Stack<Cell> path = new Stack<>();
        path.push(maze.start());
        visited[maze.start().row()][maze.start().col()] = true;

        int step = 0;
        int backtracks = 0;
        boolean found = false;

        if (ansi) {
            System.out.print("\u001B[2J\u001B[H");
        }

        render(grid, maze.start(), step, backtracks, path.size(), delayMs, bounds, ansi, false);
        pause(delayMs);

        while (!path.isEmpty()) {
            Cell current = path.peek();

            if (current.equals(maze.exit())) {
                found = true;
                break;
            }

            Cell next = firstUnvisitedNeighbor(current, walkable, visited);
            if (next != null) {
                // Move forward: leave '-' where the ghost was and put '@' on the new cell.
                grid[current.row()][current.col()] = TRAIL;
                visited[next.row()][next.col()] = true;
                path.push(next);
                grid[next.row()][next.col()] = GHOST;
                step++;
            } else {
                // Dead end: pop the current cell and move the ghost back to the
                // new top of the stack. The popped cell is marked as traversed.
                path.pop();
                if (path.isEmpty()) {
                    break;
                }
                grid[current.row()][current.col()] = TRAIL;
                Cell parent = path.peek();
                grid[parent.row()][parent.col()] = GHOST;
                backtracks++;
                step++;
            }

            Cell ghost = path.peek();
            render(grid, ghost, step, backtracks, path.size(), delayMs, bounds, ansi, false);
            pause(delayMs);
        }

        Cell finalPosition = path.isEmpty() ? maze.start() : path.peek();
        render(grid, finalPosition, step, backtracks, path.size(), delayMs, bounds, ansi, found);

        System.out.println();
        if (found) {
            System.out.println("EXIT FOUND!");
            System.out.printf("Exit 'E' is at row = %d, col = %d (0-based)%n",
                    maze.exit().row(), maze.exit().col());
            System.out.printf("Exit 'E' is at row = %d, col = %d (1-based)%n",
                    maze.exit().row() + 1, maze.exit().col() + 1);
            System.out.printf("Total moves: %d, backtracks: %d%n", step, backtracks);
        } else {
            System.out.println("No path to the exit from the start position.");
            System.out.printf("Start '@' is at row = %d, col = %d (0-based)%n",
                    maze.start().row(), maze.start().col());
            System.out.printf("Total moves: %d, backtracks: %d%n", step, backtracks);
        }
    }

    private static Cell firstUnvisitedNeighbor(Cell current, boolean[][] walkable, boolean[][] visited) {
        for (int[] direction : DIRECTIONS) {
            int row = current.row() + direction[0];
            int col = current.col() + direction[1];

            if (row >= 0 && row < SIZE && col >= 0 && col < SIZE
                    && walkable[row][col] && !visited[row][col]) {
                return new Cell(row, col);
            }
        }
        return null;
    }

    private static Maze loadMap(Path path) throws IOException {
        if (!Files.isRegularFile(path)) {
            throw new IOException("file not found at " + path.toAbsolutePath());
        }

        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        char[][] grid = new char[SIZE][SIZE];
        for (char[] row : grid) {
            Arrays.fill(row, WALL);
        }

        int row = 0;
        for (String rawLine : lines) {
            String line = rawLine.replace("\r", "");

            // Ignore a UTF-8 byte-order mark, which some editors add.
            if (row == 0 && !line.isEmpty() && line.charAt(0) == '\uFEFF') {
                line = line.substring(1);
            }

            if (line.isEmpty()) {
                continue;
            }
            if (row >= SIZE) {
                throw new IllegalArgumentException("more than " + SIZE + " map rows");
            }
            if (line.length() > SIZE) {
                throw new IllegalArgumentException(
                        "row " + (row + 1) + " is longer than " + SIZE + " characters");
            }

            for (int col = 0; col < line.length(); col++) {
                char ch = line.charAt(col);
                if (ch != WALL && ch != OPEN && ch != GHOST && ch != EXIT) {
                    throw new IllegalArgumentException(
                            "unexpected character '" + ch + "' at row " + (row + 1)
                                    + ", col " + (col + 1));
                }
                grid[row][col] = ch;
            }
            row++;
        }

        if (row == 0) {
            throw new IllegalArgumentException("the map is empty");
        }

        Cell start = null;
        Cell exit = null;
        int starts = 0;
        int exits = 0;

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (grid[r][c] == GHOST) {
                    start = new Cell(r, c);
                    starts++;
                } else if (grid[r][c] == EXIT) {
                    exit = new Cell(r, c);
                    exits++;
                }
            }
        }

        if (starts != 1) {
            throw new IllegalArgumentException("expected exactly one '@', found " + starts);
        }
        if (exits != 1) {
            throw new IllegalArgumentException("expected exactly one 'E', found " + exits);
        }

        return new Maze(grid, start, exit);
    }

    private static Bounds computeBounds(char[][] grid) {
        int minRow = SIZE;
        int maxRow = -1;
        int minCol = SIZE;
        int maxCol = -1;

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] != WALL) {
                    minRow = Math.min(minRow, row);
                    maxRow = Math.max(maxRow, row);
                    minCol = Math.min(minCol, col);
                    maxCol = Math.max(maxCol, col);
                }
            }
        }

        if (maxRow < 0) {
            return new Bounds(0, SIZE - 1, 0, SIZE - 1);
        }

        return new Bounds(
                Math.max(0, minRow - 1),
                Math.min(SIZE - 1, maxRow + 1),
                Math.max(0, minCol - 1),
                Math.min(SIZE - 1, maxCol + 1));
    }

    private static void render(char[][] grid, Cell ghost, int step, int backtracks, int stackSize,
                               int delayMs, Bounds bounds, boolean ansi, boolean found) {
        int width = bounds.maxCol() - bounds.minCol() + 1;
        String border = "+" + "-".repeat(width) + "+";
        String nl = System.lineSeparator();

        StringBuilder frame = new StringBuilder();
        if (ansi) {
            frame.append("\u001B[H");
        } else {
            frame.append(nl).append("----- frame -----").append(nl);
        }

        frame.append("Pacman Ghost Maze  |  DFS stack backtracking").append(nl);
        frame.append(border).append(nl);

        for (int row = bounds.minRow(); row <= bounds.maxRow(); row++) {
            frame.append('|');
            for (int col = bounds.minCol(); col <= bounds.maxCol(); col++) {
                frame.append(displayCell(grid[row][col], ansi));
            }
            frame.append('|');
            if (ansi) {
                frame.append("\u001B[K");
            }
            frame.append(nl);
        }

        frame.append(border).append(nl);
        frame.append("Step ").append(step)
                .append("  |  Backtracks ").append(backtracks)
                .append("  |  Stack ").append(stackSize)
                .append("  |  Ghost (").append(ghost.row()).append(", ").append(ghost.col()).append(')')
                .append("  |  Delay ").append(delayMs).append(" ms").append(nl);
        frame.append("Legend: @ ghost   E exit   - trail   # wall   space open path").append(nl);
        frame.append("Viewing rows ").append(bounds.minRow()).append("..").append(bounds.maxRow())
                .append(", cols ").append(bounds.minCol()).append("..").append(bounds.maxCol())
                .append(" of the fixed 50x50 grid").append(nl);

        if (found) {
            frame.append("*** EXIT FOUND at E (").append(ghost.row()).append(", ")
                    .append(ghost.col()).append(") ***").append(nl);
        }

        if (ansi) {
            frame.append("\u001B[J");
        }

        System.out.print(frame);
        System.out.flush();
    }

    private static String displayCell(char ch, boolean ansi) {
        if (!ansi) {
            return switch (ch) {
                case WALL -> "#";
                case OPEN -> " ";
                case TRAIL -> "-";
                case GHOST -> "@";
                case EXIT -> "E";
                default -> String.valueOf(ch);
            };
        }

        return switch (ch) {
            case WALL -> "\u001B[90m#\u001B[0m";
            case OPEN -> " ";
            case TRAIL -> "\u001B[36m-\u001B[0m";
            case GHOST -> "\u001B[1;33m@\u001B[0m";
            case EXIT -> "\u001B[1;32mE\u001B[0m";
            default -> String.valueOf(ch);
        };
    }

    private static void pause(int delayMs) {
        if (delayMs <= 0) {
            return;
        }
        try {
            Thread.sleep(delayMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static boolean detectAnsi() {
        if (System.getenv("NO_COLOR") != null) {
            return false;
        }

        String os = System.getProperty("os.name", "").toLowerCase();
        if (os.contains("win")) {
            String term = System.getenv("TERM");
            return System.getenv("WT_SESSION") != null || (term != null && !term.isBlank());
        }
        return true;
    }

    private static void printUsage() {
        System.out.println("Usage: java PacmanGhostMaze [--delay=<milliseconds>] [--no-ansi]");
        System.out.println("  --delay=<ms>  Time between moves. Default: 1000.");
        System.out.println("  --no-ansi     Disable colors and ANSI screen clearing.");
        System.out.println("The program reads map.txt from the current working directory.");
    }
}
