import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class CoffeeQueue {
    public static void main(String[] args) {
    Queue<String> line = new LinkedList<>();
    ArrayList<String> listitems = new ArrayList<>();
    Scanner inputBuffer=new Scanner(System.in);
    listitems.add(".Add ticket");
    listitems.add(".Serve next ticket");
    listitems.add(".View waiting tickets");
    for (int j = 0; j <= 2; j++) {
        System.out.println((j+1) + listitems.get(j));
    }

    boolean exit=false;

    while(!exit) {
        System.out.println("enter a number choice from menu:");
        int choice = inputBuffer.nextInt();
        inputBuffer.nextLine();

        switch (choice) {
            case 1:
                System.out.print("> order ");
                String order = inputBuffer.nextLine();
                line.add(order);
                int size=line.size();
                System.out.printf("Queue: %-30s | Waiting: %d%n",line,size);
                System.out.println("\n");
                        
                    

                break;
            case 2:
                if (line.isEmpty()) {

                    System.out.println("\nCannot serve: the queue is already empty.");
                    System.out.printf("Queue: Queue is empty. | Waiting: %d%n",line.size());

                
            } else {
                while(!line.isEmpty()){
                
                    System.out.println("\n> Serve " + line.poll());
                    if(line.size()==0){
                        System.out.printf("Queue is empty.  | Waiting: %d%n",line.size());
                    }
                    else{System.out.printf("Queue: %-30s | Waiting: %d%n",line,line.size());}
                    

                    }
                }
                break;
            case 3:
                exit=true;
                break;
            default:
                System.out.println("choose based on menu numbers!");
                break;
        }
    }

}
}
