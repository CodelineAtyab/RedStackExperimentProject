import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class BracketValidator {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int number = Integer.parseInt(userInput.nextLine());

        //for loop 
        for (int i = 0; i < number; i++) {
            String expression = userInput.nextLine();// enter the expression 

            Deque<String> stack = new LinkedList<>();// create stack to store the char
            
            boolean valid = true;
            for (int j = 0; j < expression.length(); j++) {// Check the char in the expression
                char ch = expression.charAt(j);//charAt --> get the chat at index j

                //check open bracket
                if (ch == '(' || ch == '{') {
                    stack.push(String.valueOf(ch));

                } 
                else if (ch == ')' || ch == '}') { // Check closing bracket
                    if (stack.isEmpty()) {
                        valid = false;
                    } else {

                        String c = stack.peek();
                        if ((ch == ')' && c.equals("(")) ||(ch == '}' && c.equals("{"))) { // Check if bracket match
                            stack.pop();

                        } else {

                            valid = false;
                        }
                    }
                }
            }
            if (!stack.isEmpty()) {//check if there is any opening bracket 
                valid = false;
            }
            if (valid) {
                System.out.println(expression + "Valid");

            } else {
                System.out.println(expression + "Invalid");
            }
        }
    }
}
