import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class BracketValidator {



    public static void main(String[] args){


        Scanner inputBuffer = new Scanner(System.in);

        System.out.print("Enter the number of expressions:");

        //Read how many expressions to check
        int count= Integer.parseInt(inputBuffer.nextLine());

        // need to check each expression
        for(int i=0; i<count; i++){

            System.out.println("Enter expression " + (i + 1) + ":");

            String expression= inputBuffer.nextLine();

            // need to create new stack for the expression
            Deque<String> browserHistory = new LinkedList<>();

            // the valid result = to true
            boolean valid = true;


            for (int j = 0; j < expression.length(); j++) {

                // use char because need to check char one by one
                char ch = expression.charAt(j);

                //check if it is open bracket
                if (ch == '(' || ch == '{') {

                    //here if have any open bracket
                    browserHistory.push(String.valueOf(ch));

                    //check if it is close bracket
                } else if (ch == ')' || ch == '}') {


                    //check if stack empty
                    if (browserHistory.isEmpty()) {

                        // means is false and it invalid
                        valid = false;


                        //check if bracket match>>>> ()
                    } else if (ch == ')' || !browserHistory.peek().equals("(")) {


                        // means is false and it invalid
                        valid = false;


                        //check if bracket match >>>> {}
                    } else if (ch == '}' && !browserHistory.peek().equals("{")) {
                        valid = false;

                    } else {

                        // remove matching open bracket from the stack
                        browserHistory.pop();
                    }
                }
            }
            // Check if there are unclosed brackets
            if (!browserHistory.isEmpty()) {
                valid = false;
            }

            // Print result
            if (valid) {

                System.out.println(expression + " -> Valid");

            } else {

                System.out.println(expression + " -> Invalid");
            }
        }
        inputBuffer.close();
    }
}








