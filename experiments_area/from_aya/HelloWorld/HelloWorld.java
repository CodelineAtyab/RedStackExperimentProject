
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.println("Welcome, " + name + "!");
        System.out.println("Let's learn Java together.");
        System.out.println("Happy coding!");

        input.close();
    }
}
