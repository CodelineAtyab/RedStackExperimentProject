
import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class BracketValidator {

    public static void main(String[] args) {

        Scanner inputBuffer = new Scanner(System.in);

        System.out.print("How many expressions? ");
        int count = Integer.parseInt(inputBuffer.nextLine());

        for (int i = 0; i < count; i++) {

            System.out.print("Enter expression: ");
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
                        break;
                    }

                    String top = browserHistory.peek();

                    if ((ch == ')' && top.equals("(")) ||
                        (ch == '}' && top.equals("{"))) {

                        browserHistory.pop();

                    } else {
                        valid = false;
                        break;
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
