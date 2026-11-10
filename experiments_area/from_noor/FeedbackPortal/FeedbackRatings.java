public class FeedbackRatings {
    public static void main(String[] args) {
    int[] ratings = new int[3];
    String[] customerNames = new String[3];

    customerNames[0] = "Wafa";
    customerNames[1] = "Haitham";
    customerNames[2] = "Kumail";



    for(int i =0; i < ratings.length; i++){
        ratings[i] = 3+i;
    }

      for(int i =0; i < ratings.length; i++){
System.out.println("Customer " + (i+1) + ": " + customerNames[i] + " - rating " + ratings[i]);  }

}

}