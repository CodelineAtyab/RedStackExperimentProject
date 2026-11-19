import java.util.Deque;
import java.util.LinkedList;

public class BracketValidator {

    static void printExpressionValidity(String expression) {
        if (isValidExpression(expression))
            System.out.println(expression + " -> Valid");
        else
            System.out.println(expression + " -> Invalid");
    }

    static boolean isValidExpression(String expression) {
        Deque<String> browserHistory = new LinkedList<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                browserHistory.push(String.valueOf(ch));
            } 
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (browserHistory.isEmpty()) {
                    return false;
                }
                
                if ((ch == ')' && browserHistory.peek().equals("(")) || 
                    (ch == '}' && browserHistory.peek().equals("{")) || 
                    (ch == ']' && browserHistory.peek().equals("["))) {
                    browserHistory.pop();
                } else {
                    return false;
                }
            }
            // Any other character is ignored
        }
        
        return browserHistory.isEmpty();
    }

    public static void main(String[] args) {
        printExpressionValidity("(()}");
    }
}