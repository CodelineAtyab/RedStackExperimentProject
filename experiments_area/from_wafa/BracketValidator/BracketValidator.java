import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BracketValidator {

    public static void main(String[] args) {
        Scanner inputBuffer = new Scanner(System.in);

        int expressioncheck = Integer.parseInt(inputBuffer.nextLine());

        for (int repeate = 0; repeate < expressioncheck; repeate++) {
           
            Deque<String> browserHistory = new LinkedList<>();
            String expression = inputBuffer.nextLine();
            boolean isValid = true;

            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);

                if (ch == '(' || ch == '{') {
                    browserHistory.push(String.valueOf(ch));
                } 
                else if (ch == ')' || ch == '}') {
                    
                    if (browserHistory.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    
                    String charOfStack = browserHistory.peek();
                    if ((ch == ')' && charOfStack.equals("(")) || (ch == '}' && charOfStack.equals("{"))) {
                        browserHistory.pop();
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid && browserHistory.isEmpty()) {
                System.out.println(expression + " -> Valid");
            } else {
                System.out.println(expression + " -> Invalid");
            }
        }
        
        inputBuffer.close();
    }
}