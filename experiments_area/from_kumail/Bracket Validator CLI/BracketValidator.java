import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BracketValidator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of expressions: ");
        int numOfExpression = Integer.parseInt(input.nextLine());

        for (int i = 0; i < numOfExpression; i++) {

            System.out.print("Enter expr: ");
            String expr = input.nextLine();

            Deque<String> browserHistory = new LinkedList<>();

            boolean valid = true;

            for (int j = 0; j < expr.length(); j++) {

                char ch = expr.charAt(j);

                if (ch == '(' || ch == '{') {

                    browserHistory.push(String.valueOf(ch));

                } else if (ch == ')' || ch == '}') {

                    if (browserHistory.isEmpty()) {

                        valid = false;

                    } else {

                        String top = browserHistory.peek();

                        if ((ch == ')' && !top.equals("(")) ||
                                (ch == '}' && !top.equals("{"))) {

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

                System.out.println(expr + " -> Valid");

            } else {

                System.out.println(expr + " -> Invalid");

            }
        }

        input.close();
    }
}