public class diamondLoop{
    public static void main(String[] args) {

        //upper half of the diamond
        for (int i = 1; i <= 4; i++) {

            for (int j = 1; j <= (4 - i); j++) { // Print spaces
                System.out.print(" ");
            }
            // Print stars
            for (int k = 1; k <= (2 * i - 1); k++) {// Print stars
                System.out.print("*");
            }

            System.out.println();
        }

        //lower half of the diamond
        for (int i = 4; i >= 1; i--) {

            for (int j = 1; j <= (4 - i); j++) { // Print spaces
                System.out.print(" ");
            }
            // Print stars
            for (int k = 1; k <= (2 * i - 1); k++) {// Print stars
                System.out.print("*");
            }

            System.out.println();
        }
    }
}