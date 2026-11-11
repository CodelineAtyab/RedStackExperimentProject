
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BracketValidator {

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        int numExpressions = Integer.parseInt(inputScanner.nextLine());

        for (int i = 0; i < numExpressions; i++) {

            String expression = inputScanner.nextLine();

            Deque<String> browserHistory = new LinkedList<>();
            boolean valid = true;

            for (int j = 0; j < expression.length(); j++) {

                char currentChar = expression.charAt(j);

                if (currentChar == '(' || currentChar == '{') {

                    browserHistory.push(String.valueOf(currentChar));

                } else if (currentChar == ')' || currentChar == '}') {

                    if (browserHistory.isEmpty()) {

                        valid = false;

                    } else {

                        String topBracket = browserHistory.peek();

                        if ((currentChar == ')' && !topBracket.equals("(")) ||
                                (currentChar == '}' && !topBracket.equals("{"))) {

                            valid = false;

                        } else {

                            browserHistory.pop();
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

        inputScanner.close();
    }
}
