public class FeedbackScoreTable {
    public static void main(String[] args) {
        int[][] scores = new int[3][3];

        // Almuatsam
        scores[0][0] = 5;
        scores[0][1] = 4;
        scores[0][2] = 3;

        // Ayham
        scores[1][0] = 4;
        scores[1][1] = 4;
        scores[1][2] = 5;

        // Salim
        scores[2][0] = 3;
        scores[2][1] = 5;
        scores[2][2] = 4;

        printScoreTable(scores);
    }

    static void printScoreTable(int[][] scores) {
        for (int customer = 0; customer < scores.length; customer++) {
            for (int category = 0; category < scores[customer].length; category++) {
                System.out.print(scores[customer][category] + " ");
            }
            System.out.println();
        }
    }
}
