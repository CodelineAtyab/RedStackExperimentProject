import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BracketValidator {

    static Scanner inputBuffer = new Scanner(System.in);
    public static void main(String[] args) {

        int expressioncheck = Integer.parseInt(inputBuffer.nextLine());

        for (int repeate = 0; repeate < expressioncheck; repeate++) {
           
            Deque<Character> browserHistory = new LinkedList<>();
            String expression = inputBuffer.nextLine();
            boolean isValid = true;

            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);

                if (ch == '(' || ch == '{') {
                    browserHistory.push(ch);
                } 
                else if (ch == ')' || ch == '}') {
                    
                    if (browserHistory.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    
                    char charOfStack = browserHistory.peek();
                    if ((ch == ')' && charOfStack == '(') || (ch == '}' && charOfStack == '{')) {
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
    }
}