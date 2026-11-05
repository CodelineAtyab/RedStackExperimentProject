import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BracketValidator {
    public static void main(String[] args) {
        Scanner inputBuffer = new Scanner(System.in);

        // 1. How many expressions to check
        System.out.print("Enter how many expressions to check: ");
        int count = Integer.parseInt(inputBuffer.nextLine());

        // 2. Check each expression
        for (int round = 0; round < count; round++) {
            System.out.print("Enter expression " + (round + 1) + ": ");
            String expression = inputBuffer.nextLine();

            // Fresh stack and flag for every expression
            Deque<String> browserHistory = new LinkedList<>();
            boolean valid = true;

            // 3. Walk through every character
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);

                if (ch == '(' || ch == '{') {
                    browserHistory.push(String.valueOf(ch));

                } else if (ch == ')' || ch == '}') {
                    if (browserHistory.isEmpty()) {
                        valid = false; // closing bracket with nothing open
                    } else {
                        String top = browserHistory.peek();
                        if ((ch == ')' && top.equals("(")) || (ch == '}' && top.equals("{"))) {
                            browserHistory.pop(); // matched
                        } else {
                            valid = false; // wrong kind of bracket
                        }
                    }
                }
                // any other character is ignored
            }

            // 4. Brackets that were never closed
            if (!browserHistory.isEmpty()) {
                valid = false;
            }

            // 5. Print the result
            if (valid) {
                System.out.println(expression + " -> Valid");
            } else {
                System.out.println(expression + " -> Invalid");
            }
        }
    }
}