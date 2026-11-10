import java.util.*;

public class SupportCenter {
    static Queue<String> line = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);


    public static int numinput(){
        int num = 999;
        try{
            num = sc.nextInt();
            sc.nextLine();
        }
        catch(Exception e) {System.out.println("Invalid input. Please enter a number."); sc.next();}
        return num;
    }
    

    public static void menu(){
        ArrayList<String> menuItem = new ArrayList<>();
        menuItem.add("1 Add ticket");
        menuItem.add("2 Add urgent ticket");
        menuItem.add("3 Serve next ticket");
        menuItem.add("4 View waiting tickets");
        String banner = "Support Desk";
        int spaces = (banner.length());
        System.out.print("how many times do you want to runthe loop? ");
        int number = numinput();
        for(int k = 0 ; k < number; k++ )
            {

            System.out.println();
            System.out.printf("|%-"+ spaces +"s"+banner+"%-"+ spaces +"s"+"|\n" , " " , " ");
            for (int i = 0 ; i < menuItem.size(); i++)
            {
                System.out.println(menuItem.get(i));
            }
            System.out.print("Enter your choice: ");
            int choice = numinput();
            switch (choice) {
                case 1:
                    System.out.print("Enter ticket description: ");
                    String ticket = sc.nextLine();
                    line.add(ticket);
                    break;
                case 2:
                    System.out.print("Enter ticket description: ");
                    String urgent = sc.nextLine();
                    Queue<String> temp = new LinkedList<>();
                    temp.add(urgent);
                    int size = line.size();
                    for (int i = 0 ; i <size; i++)
                    {
                        temp.add(line.poll());
                    }
                    line = temp;

                    break;
                case 3:
                    if (line.isEmpty()) {
                        System.out.println("No tickets waiting");
                    } else {
                        System.out.println("Serving: " + line.poll());
                    }
                    break;
                case 4:
                    if (line.isEmpty()) {
                        System.out.println("No tickets waiting");
                    }
                    else
                    {
                        for (int h = 0 ; h < line.size() ; h++)
                        {
                            String tempp = line.poll();
                            System.out.println((h + 1) + " " + tempp);
                            line.add(tempp);
                        }
                    }
                    break;
                
            }
            }
        } 
    
    

    public static void main(String[] args) {
        menu();
    }
}
