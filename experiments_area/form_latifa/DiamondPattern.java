import java.util.Scanner;

public class DiamondPattern {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows for the half-diamond (size): ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {

            for (int spaceDiamond = n; spaceDiamond > i; spaceDiamond--) {
                    System.out.print(" ");
            }
            
            for (int starDiamond = 1; starDiamond <= (2 * i - 1); starDiamond++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Print the lower half of the diamond
        // Note: Starting from n prints the middle row twice
        for (int i = n; i >= 1; i--) {

            for (int spaceDiamond = n; spaceDiamond > i; spaceDiamond--) {
                System.out.print(" ");
            }

            for (int starDiamond = 1; starDiamond <= (2 * i - 1); starDiamond++) {
                System.out.print("*");
            }

            System.out.println();
        }

        scanner.close();
    }
}