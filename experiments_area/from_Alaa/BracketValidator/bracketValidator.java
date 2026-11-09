
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class bracketValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter number of expressions to check validity for: ");
        int numExpressions = Integer.parseInt(scanner.nextLine()); //read how many expressions to check

        for (int i = 0; i < numExpressions; i++) {

            Deque<String> browserHistory = new LinkedList<>(); //storing brackets that we haven't closed yet
            boolean isValid = true;
            System.out.print ("enter an expression: ");
            String expression = scanner.nextLine(); //save expression as a string

            for (int j = 0; j < expression.length(); j++) { //loop through the string

                char ch = expression.charAt(j);

                if (ch == '(' || ch == '{') {
                    browserHistory.push(String.valueOf(ch));
                }
                else if (ch == ')' || ch == '}') {

                    if (browserHistory.isEmpty()) {
                        isValid = false; //closing bracket but nothing is open
                    }
                    else {
                        String topElement = browserHistory.peek(); // save the element at the top

                        if ((ch == ')' && topElement.equals("(")) || (ch == '}' && topElement.equals("{"))) {
                            browserHistory.pop();
                        }
                        else {
                            isValid = false; //closing bracket doesn't match the top
                        }
                    }
                }
            }

            if (!browserHistory.isEmpty()) {//check if there are any opening brackets left
                isValid = false;
            }

            //print the result
            if (isValid) {
                System.out.println(expression + " -> Valid");
            }
            else {
                System.out.println(expression + " -> Invalid");
            }
        }

        
    }
}