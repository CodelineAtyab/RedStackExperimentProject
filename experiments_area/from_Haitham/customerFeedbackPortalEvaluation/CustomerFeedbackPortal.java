import java.util.Scanner;

public class CustomerFeedbackPortal {
    static  Scanner sc = new Scanner(System.in);
    static String[] names = new String[100];
    static String[] products = new String[100];
    static int[] ratings = new int[100];
    static String[] comments = new String[100];
    static int count = 0;

    public static int numinput(){
        int num = 999;
        try{num = sc.nextInt();}
        catch(Exception e) {System.out.println("Invalid input. Please enter a number."); sc.next();}
        return num;
    }
    
    public static double doubleNumInput(){
        double num = 0;
        try{num = sc.nextDouble();}
        catch(Exception e) {System.out.println("Invalid input. Please enter a number."); sc.next();}
        return num;
    }



    public static void main(String[] args) {
        
    }
}
