import java.util.Scanner;
public class WelcomeWagon {
    
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        String name=sc.nextLine();

        System.out.println("Welcome, "+name+"!");
        System.out.println("Let's learn Java together.");
        System.out.println("Happy coding!");
        sc.close();
    }
}
