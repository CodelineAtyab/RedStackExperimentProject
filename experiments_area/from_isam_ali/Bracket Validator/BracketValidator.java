import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BracketValidator {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("How many times you want to make? : ");
        int counter = Integer.parseInt(sc.nextLine());

        for (int turn =0; turn < counter; turn++) {
            
            String expression = sc.nextLine(); 

            Deque<String> browserhistory = new LinkedList<>();
            boolean valid = true;

            for (int i = 0; i < expression.length(); i++){
                char ch = expression.charAt(i);
                if (ch == '{' || ch == '(') {
                    browserhistory.push(String.valueOf(ch));

                } 
                else if (ch == '}' || ch == ')') {  
                    if (browserhistory.isEmpty()) {
                        valid = false;

                    } else {
                        String top = browserhistory.peek();
                        if (ch ==')' && top.equals("(")) {
                            browserhistory.pop();
                        } else if (ch == '}' && top.equals("{")) {
                            browserhistory.pop();

                        } else {
                            valid = false;
                        }
                    }
                }
            }
            if (!browserhistory.isEmpty()) {
                valid = false;
            }
            if (valid) {
                System.out.println(expression + " -> Valid");
            } else {
                System.out.println(expression + " -> Invalid");
            }
        }
    }
}