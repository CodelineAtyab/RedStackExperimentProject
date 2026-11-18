import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BracketValidator {
    public static void main(String[] args) {

        Scanner inputBuffer = new Scanner(System.in);
        System.out.print("Enter Expression Count: ");
        int expressionCount = Integer.parseInt(inputBuffer.nextLine());

        //i = expression index.
        for (int i = 0; i < expressionCount; i++) {
            System.out.print("Enter Expression: ");
            String inputexpression = inputBuffer.nextLine();
            Deque<String> browserHistory = new LinkedList<>();
            boolean valid = true;

            for (int characterIndex = 0; characterIndex < inputexpression.length(); characterIndex++) {
                char ch = inputexpression.charAt(characterIndex);

                if (ch == '(' || ch == '{') {
                    browserHistory.push(String.valueOf(ch));
                } else if (ch == ')' || ch == '}') {
                    if (browserHistory.isEmpty()) {
                        valid = false;
                    } else {
                        String openingBracket = browserHistory.peek();

                        if ((ch == ')' && !openingBracket.equals("("))
                                || (ch == '}' && !openingBracket.equals("{"))) {
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
                System.out.println(inputexpression + " -> Valid");
            } else {
                System.out.println(inputexpression + " -> Invalid");
            }
        }

        inputBuffer.close();
        
    }
}
