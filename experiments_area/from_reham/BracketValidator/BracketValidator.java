
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BracketValidator{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of expression to check validity: ");
        int num= Integer.parseInt(input.nextLine());

        for (int i =0;i<num;i++){
            Deque<String> browserHistory  = new LinkedList<>();
            boolean isValid =true;
            System.out.print("enter an expression: ");
            String expression = input.nextLine();
            for (int j=0;j<expression.length();j++){
                char ch = expression.charAt(j);
                if (ch == '(' || ch =='{'){
                    browserHistory.push(String.valueOf(ch));
                }else if (ch ==')' || ch == '}') {
                    if (browserHistory.isEmpty()){
                        isValid=false;
                    }
                    else{
                        String TopElement = browserHistory.peek();
                        if ((ch==')'&& TopElement.equals("("))|| (ch=='}'&&TopElement.equals("{"))){
                            browserHistory.pop();

                        }else{
                            isValid=false;
                        }
                    }
                }
            }

            if(!browserHistory.isEmpty()){
                isValid=false;
            }
            if(isValid){
                System.out.println(expression + "Is valid");
            }else{
                System.out.println(expression+" Invalid");
            }
        }

    }
}