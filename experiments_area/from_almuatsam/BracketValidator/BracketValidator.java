import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BracketValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many expressions do you want to check?");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.println("Enter expression " + (i + 1) + ":");
            String expression = scanner.nextLine();
            Deque<String> browserHistory = new LinkedList<>();
            boolean valid = true;

            for (int index = 0; index < expression.length(); index++) {
                char current = expression.charAt(index);

                if (current == '(' || current == '{') {
                    browserHistory.push(String.valueOf(current));
                } else if (current == ')' || current == '}') {
                    if (browserHistory.isEmpty()) {
                        valid = false;
                    } else {
                        String top = browserHistory.peek();
                        boolean isMatch = (current == ')' && top.equals("("))
                                || (current == '}' && top.equals("{"));

                        if (isMatch) {
                            browserHistory.pop();
                        } else {
                            valid = false;
                        }
                    }
                }
            }

            if (!browserHistory.isEmpty()) {
                valid = false;
            }

            if (valid) {
                System.out.println("Expression " + (i + 1) + " is valid");
            } else {
                System.out.println("Expression " + (i + 1) + " is NOT valid");
            }
        }

        scanner.close();
    }
}
