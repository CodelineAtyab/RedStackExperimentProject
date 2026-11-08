public class FeedbackRatings {
    static public void main(String[] args){

        String[] customerNames = new String[3];

        customerNames[0] = "Mohammed";
        customerNames[1] = "Ali";
        customerNames[2] = "Omar";

        int[] ratings = new int[3];

        for( int index = 0; index < ratings.length; index++){
            ratings[index] = 3 + index;
        }
        for ( int index = 0; index < customerNames.length; index++ ){
            System.out.println("Customer : " + (index + 1) + ". "
                    + customerNames[index] + " - rating " + ratings[index]);
        }
    }
}