import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BracketValidator {
    public static void main(String[] args) {
        Scanner inputBuffer = new Scanner(System.in);

        System.out.print("Enter the number of expressions to validate: ");
        int times = Integer.parseInt(inputBuffer.nextLine());

        for (int i = 0; i < times; i++) {
            Deque<String> browserHistory = new LinkedList<>();
            boolean valid = true;

            System.out.print("Enter the expression here: ");
            String exp = inputBuffer.nextLine();

            for (int j = 0; j < exp.length(); j++) {
                char ch = exp.charAt(j);

                if (ch == '(' || ch == '{') {
                    browserHistory.push(String.valueOf(ch));
                }
                else if (ch == ')') {
                    if (browserHistory.isEmpty()) {
                        valid = false;
                        break;
                    }
                    String top = browserHistory.peek();
                    if (top.equals("(")) {
                        browserHistory.pop();
                    } else {
                        valid = false;
                        break;
                    }
                }
                else if (ch == '}') {
                    if (browserHistory.isEmpty()) {
                        valid = false;
                        break;
                    }
                    String top = browserHistory.peek();
                    if (top.equals("{")) {
                        browserHistory.pop();
                    } else {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid && !browserHistory.isEmpty()) {
                valid = false;
            }
            if (valid) {
                System.out.println(exp + " -> Valid");
            } else {
                System.out.println(exp + " -> Invalid");
            }
        }
        
        inputBuffer.close();
    }
}