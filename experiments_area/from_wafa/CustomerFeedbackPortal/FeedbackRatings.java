public class FeedbackRatings {

    public static void main(String[] args){
        String[] customerNames = new String[3];

        customerNames[0]= "Wafa";
        customerNames[1]= "Haitham";
        customerNames[2]= "Kumail";

        int[] ratings = new int[3];
        
        for(int ratingNum = 0 ; ratingNum < 3;ratingNum++){
            ratings[ratingNum]=3+ratingNum;

        }

        
        for(int ratingNum = 0; ratingNum < 3 ; ratingNum++) {
            System.out.println("Customer " + (ratingNum+1) + ": " + customerNames[ratingNum] + " - rating " + ratings[ratingNum]);
        }
    }
}