import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BracketValidator {
    public static void main(String[] args) {
        Scanner inputBuffer = new Scanner(System.in);

        int numberOfExpressions = Integer.parseInt(inputBuffer.nextLine());

        for (int i = 0; i < numberOfExpressions; i++) {
            String expression = inputBuffer.nextLine();

            Deque<String> browserHistory = new LinkedList<>();
            boolean valid = true;

            for (int j = 0; j < expression.length(); j++) {
                char ch = expression.charAt(j);

                if (ch == '(' || ch == '{') {
                    browserHistory.push(String.valueOf(ch));

                } else if (ch == ')' || ch == '}') {
                    if (browserHistory.isEmpty()) {
                        valid = false;
                    } else {
                        String top = browserHistory.peek();

                        if ((ch == ')' && top.equals("(")) || (ch == '}' && top.equals("{"))) {
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
                System.out.println(expression + " -> Valid");
            } else {
                System.out.println(expression + " -> Invalid");
            }
        }
        inputBuffer.close();
    }
}