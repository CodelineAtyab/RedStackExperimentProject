import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BracketValidator {
    static Deque<String> browserHistory = new LinkedList<>();
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
        
    }
}
