import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomerFeedbackPortal {
    //  Create arrays
    static String[] names =new String [100];
    static int[] ratings = new int[100];
    static String[] comments = new String[100];
    static int count =0;
    public static void main(String[] args) {
        logo();
        loadfeedback();
        menu();
        
    }

    public static void logo(){
        int rn=6;
        for (int r=0; r<rn ;r++){
            for(int sl=0 ; sl<=r ;sl++){
            System.out.print("*");
            }
            for(int sp=0 ;sp<2*(rn-r)+14;sp++){
                if(r==3){
                System.out.print("   ACME SOLUTIONS   ");
                break;
                }
                System.out.print(" ");

            }
            for(int sr=0 ; sr<=r ;sr++){
            System.out.print("*");
            }
            System.out.println();
        }

    }

    //Load feedback:
    public static void loadfeedback(){
        String feedbackfile="C:\\Opal-RedStack\\RedStackExperimentProject\\experiments_area\\from_reham\\CustomerFeedbackPortal\\Cust_Feedback.txt";
        
        try(BufferedReader read =new BufferedReader(new FileReader(feedbackfile))){
            String Line;
            while((Line=read.readLine())!=null){
                String name = Line;
                String rating = read.readLine();
                String comment = read.readLine();
                names[count] = name;
                ratings[count] = Integer.parseInt(rating);
                comments[count] = comment;
                count ++;
            }
            if (count>0){
                System.out.println("Loaded "+count+" feedback entries from feedback.txt");
            }
            else{
                System.out.println("No saved feedback found. Starting fresh.");
            }

        }catch(IOException exception){
            System.out.print("Error loading feedback!");
        }
    }

    //Menu
    public static void menu(){

        String Title =" CUSTOMER FEEDBACK PORTAL ";
        System.out.print("+");
        for (int i=0 ; i<=Title.length();i++){
            System.out.print("=");
        }
        System.out.println("+");
        for(int i=1;i<=1;i++){
            System.out.println("|"+Title+" |");
        }
         System.out.print("+");
        for (int i=0 ; i<=Title.length();i++){
            System.out.print("=");
        }
        System.out.println("+");

        String[] menu= {
            "Submit Feedback",
            "View All Feedback",
            "Rating Report",
            "Search by product",
            "Save to File",
            "Exit",
        };

        for (int i=0; i<menu.length;i++){
            System.out.print("| ");
            System.out.print((i+1)+". "+menu[i]);
            for (int j = 0; j <(Title.length()-menu[i].length())-4; j++) {
                System.out.print(" ");
            }
            System.out.println(" |");
        }
         System.out.print("+");
        for (int i=0 ; i<=Title.length();i++){
            System.out.print("=");
        }
        System.out.println("+");

       



    }



}

