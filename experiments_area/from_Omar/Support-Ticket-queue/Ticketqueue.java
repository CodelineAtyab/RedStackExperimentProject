import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ticketqueue {
    public static Scanner inputBuffer = new Scanner(System.in);

    public static void UpdateMenuTitleExample() {
        System.out.print("Enter title: ");
        String title = inputBuffer.nextLine();

        int width = 36;
        int pad = (width - title.length()) / 2;
        int rightPad = width - pad - title.length();

        System.out.print("|");
        for (int i = 0; i < 2; i++) {
            int currentPad = (i == 0) ? pad : rightPad;
            for (int j = 0; j < currentPad; j++) {
                System.out.print(" ");
            }
            if (i == 0) {
                System.out.print(title);
            }
        }
        System.out.println("|");
    }
public static void main(String[] args) {
    Queue<String> line = new LinkedList<>();
    ArrayList<String> listitems = new ArrayList<>();
    UpdateMenuTitleExample();
    listitems.add(".Add ticket");
    listitems.add(".Add urgent ticket");
    listitems.add(".Serve next ticket");
    listitems.add(".View waiting tickets");

    inputBuffer.nextLine();
    for (int j = 0; j <= 3; j++) {
        System.out.println((j+1) + listitems.get(j));
    }

    System.out.println("enter number of actions to perform:");
    int numActions = Integer.parseInt(inputBuffer.nextLine());

    for (int i = 0; i < numActions; i++) {
        System.out.println("enter a number choice from menu:");
        int choice = inputBuffer.nextInt();
        inputBuffer.nextLine();

        switch (choice) {
            case 1:
                System.out.println("enter text:");
                String text = inputBuffer.nextLine();
                line.add(text);

                break;
            case 2:
                System.out.println("enter urgent text:");
                Queue<String> urgentLine = new LinkedList<>();
                String urg_input = inputBuffer.nextLine();
                urgentLine.add(urg_input);
                int currentsize=line.size();
                for (int c = 0; c < currentsize; c++) {
                    urgentLine.add(line.poll());
                }
                line = urgentLine;

                break;
            case 3:
                if (line.isEmpty()) {
                    System.out.println("no tickets waiting");
                } else {
                    System.out.println("Serving: " + line.poll());
                }

                break;
            case 4:
                if (line.isEmpty()) {
                    System.out.println("no tickets waiting");

                }
                else{
                    int index=0;
                    int size=line.size();
                    for(int o=0;o <size;o++){
                        String ticket=line.poll();
                        System.out.println(index+", "+ticket);
                        line.add(ticket);
                        index++;
                    }
                }

                break;
            default:
                break;
        }
    }

}
}


