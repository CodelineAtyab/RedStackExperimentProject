public class FeedbackRating {

    public static void main(String[] args) {

        int totalCustomers = 3;
        int[] customerId = new int[totalCustomers];

        String[] customerNames = new String[3];
        customerNames[0] = "Wafa";
        customerNames[1] = "Haithem";
        customerNames[2] = "Kumail";

        Integer[] rating = new Integer[3];
        rating[0] = 3;
        rating[1] = 4;
        rating[2] = 5;

    for (int i=0; i < totalCustomers; i++) {
        customerId[i] = i + 1;
        System.out.println("Customer "+customerId[i]+ ": " +customerNames[i]+ " - rating " +rating[i]  );
    }




    
}
}
