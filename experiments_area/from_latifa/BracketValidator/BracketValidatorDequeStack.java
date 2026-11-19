import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BracketValidatorDequeStack {

    public static void main(String[] args) {
     
        Scanner inputBuffer = new Scanner(System.in);
        System.out.print("how many expressions to check: ");
        int numExpressions = Integer.parseInt(inputBuffer.nextLine());

        for(int i=0; i<numExpressions; i++){
            System.out.print("Enter the expression: ");
            String expression = inputBuffer.nextLine();

            Deque<String> browserHistory = new LinkedList<>();
            boolean isValid = true;
            for(int character=0; character <expression.length(); character++){
                char chr = expression.charAt(character);
                if(chr == '(' || chr == '{'){
                    browserHistory.push(String.valueOf(chr));
                }else if(chr == ')' || chr == '}'){
                    if(browserHistory.isEmpty()){
                        isValid =false;
                    }else{
                        // Check whether brackets match
                        if ((chr == ')' && !browserHistory.peek().equals("(")) ||
                            (chr == '}' && !browserHistory.peek().equals("{"))) {

                            isValid = false;
                        } else {
                            browserHistory.pop();
                    }
                }
            }
        }
        // Check if opening brackets remain
            if (!browserHistory.isEmpty()) {
                isValid = false;
            }
            // Print the result
            if (isValid) {
                System.out.println(expression + " -> Valid");
            } else {
                System.out.println(expression + " -> Invalid");
            }
        }

        inputBuffer.close();

    }
}