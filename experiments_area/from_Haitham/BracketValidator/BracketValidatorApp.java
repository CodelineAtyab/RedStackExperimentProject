import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BracketValidatorApp {
    static  Scanner sc = new Scanner(System.in);
    public static int numinput(){
        int num = 999;
        try{
            num = sc.nextInt();
            sc.nextLine();
        }
        catch(Exception e) {System.out.println("Invalid input. Please enter a number."); sc.next();}
        return num;
    }
    public static void main(String[] args) {
        System.out.print("how many times do you want to runthe loop? ");
        int number = numinput();

        for(int k = 0 ; k < number; k++ )
            {
                boolean is_valid = true;
                Deque<String> browserHistory = new LinkedList<>();
                System.out.print("Enter an expression: ");
                String expression = sc.nextLine();
                int size = expression.length();
                for (int j = 0 ; j < size ; j++)
                {
                    if(expression.charAt(j) == '(' ||expression.charAt(j) == '{' )
                    {
                        browserHistory.push(String.valueOf(expression.charAt(j)));
                    }

                    
                    if (expression.charAt(j) == ')' || expression.charAt(j) == '}') {
                        if (browserHistory.isEmpty()) {
                            is_valid = false;
                        } else {
                            String top = browserHistory.peek();
                            if (expression.charAt(j) == ')' && top.equals("(")) {
                                browserHistory.pop();
                            } else if (expression.charAt(j) == '}' && top.equals("{")) {
                                browserHistory.pop();
                            } else {
                                is_valid = false;
                            }
                        }
                    }
                }
            if (!browserHistory.isEmpty()) {
                is_valid = false;
            }
            
            if (is_valid) {
                System.out.println(expression + " -> Valid");
            } else {
                System.out.println(expression + " -> Invalid");
            }
        }
        
    }
}

