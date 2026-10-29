public class FeedbackRatings {

    public static void main(String[] args) {

        String[] customerNames = new String[3];
        customerNames[0] = "Wafa";
        customerNames[1] = "Haitham";
        customerNames[2] = "Kumail";

        int[] ratings = new int[3];
        for (int i = 0; i < 3; i++) {
            ratings[i] = 3 + i;
        }

      for(int customerNamesLoop=0; customerNamesLoop<customerNames.length; customerNamesLoop++){
        for(int ratingsLoop=customerNamesLoop; ratingsLoop<customerNamesLoop+1; ratingsLoop++){

            System.out.println("Customer "+(customerNamesLoop+1)+": "+customerNames[customerNamesLoop]+" - "+"rating "+ratings[ratingsLoop]);
        }
      }

    }
}
