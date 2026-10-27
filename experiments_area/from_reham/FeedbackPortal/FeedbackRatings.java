public class FeedbackRatings {
    public static void main(String[] args) {
        
    
    //Created an array with atributes:
    String[] customerNames = {"Wafa","Haitham","Kumail"};

    int[] ratings = new int[3];

        for (int j=0 ; j<3;j++){
            ratings[j] =j+3;
        }

            for (int i=0 ; i<3 ; i++){
                System.out.println("Customer " + (i + 1) + ": "
        + customerNames[i] + " - rating " + ratings[i]);

        }
    }
}
