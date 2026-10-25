import java.util.Scanner;

public class PanasonicRemote {

    static Scanner scInput = new Scanner(System.in);

    static String readText(String prompt) {

        String inputValue = "";

        System.out.println(prompt);

        inputValue = scInput.nextLine();
        return inputValue;

    }

    static int readNumber(String prompt) {
//readNumber function
        int number = 0;

        System.out.println(prompt);
        number = scInput.nextInt();

        return number;

    }


    public static boolean isRemoteOn = false;

    static void displayMenu(String[]array) {

        for (int i = 0; i < array.length; i++) {

            System.out.print((i + 1) + ")" + array[i] + "   ");
        }

    }

    static void write(String prompt) {

        System.out.println(prompt);

    }

    static void Program(String[]Array) {

        String choice = "";
        do {
            displayMenu(Array);

            choice = readText("\n\nChoose: ");

            switch (choice) {
                case "1":
                case "on":

write("Remote is now ON\n\n");
                    break;

                case "2":
                case "off":

write("Remote is now OFF\n\n");

                    break;

                case "3":
                case "temp":
                    write("Current temperature is: 24 C\n\n");
                    break;

                    case "4":
                    case "exit":
                        return;
                default:
                    System.out.println("not within the available choices\n\n");
                    break;

            }
        } while (true);

    }

    public static void main(String[] args) {

                String[] array = { "on", "off", "temp", "exit"};

        Program(array);

    }

}
