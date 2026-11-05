import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BracketValidator {
    public static void main(String[] args) {
        
        Deque<String> browserHistory = new LinkedList<>();
        Scanner inputBuffer = new Scanner(System.in);

        System.out.print("Enter the number of expressions to validate: ");
        int times = Integer.parseInt(inputBuffer.nextLine());

        for(int i=0; i<times; i++){
            System.out.print("Enter the expression here: ");
            String exp = inputBuffer.nextLine();
        }
    }
}
