public class FeedbackRatings {
    public static void main(String[] args) {
        String[] customerNames = new String[3];
        customerNames[0] = "Wafa";
        customerNames[1] = "Haitham";
        customerNames[2] = "Kumail";

        int[] ratings = new int[3];

        for (int index = 0; index < ratings.length; index++) {
            ratings[index] = 3 + index;
        }

        for (int index = 0; index < customerNames.length; index++) {
            System.out.println("Customer " + (index + 1) + ": "
                    + customerNames[index] + " - rating " + ratings[index]);
        }
    }
}