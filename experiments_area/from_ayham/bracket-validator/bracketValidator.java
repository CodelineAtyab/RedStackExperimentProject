import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class bracketValidator {

    public static void check_expression(String expression) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == '}') {
                if (stack.isEmpty()) {
                    System.out.println("Invalid expression: " + expression);
                    return;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{')) {
                    System.out.println("Invalid expression: " + expression);
                    return;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("Valid expression: " + expression);
        } else {
            System.out.println("Invalid expression: " + expression);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int action;
            System.out.println("Enter how many expressions to check: ");
            action = Integer.parseInt(scanner.nextLine()); 
            for (int i = 0; i < action; i++) {
                System.out.println("Enter an expression to check: "); 
                String expression = scanner.nextLine();
                check_expression(expression);
            }
    } }
}
