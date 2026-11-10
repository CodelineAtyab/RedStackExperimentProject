public class FeedbackRatings {

    public static void main(String[] args) {
        String[] customerNames = new String[3]; //array with fixed size
        //fill 3 boxes
        customerNames[0] ="Wafa";
        customerNames[1] ="Haitham";
        customerNames[2] ="Kumail";

        int[] ratings = new int[3];
        for(int i=0;i<3;i++){
            ratings[i]=i +3;
        }

        for(int i=0;i<3;i++){
            System.out.println("Customer " +(i+1) +": "+ customerNames[i] + " - "+"rating "+ratings[i] );
        }

    }
}