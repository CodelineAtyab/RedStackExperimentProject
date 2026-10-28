public class FeedbackRatings {
    public static void main(String[] args) {
        String[] customerNames = new String[3];
        customerNames[0] = "Almuatsam";
        customerNames[1] = "Ayham";
        customerNames[2] = "Salim";

        int[] ratings = new int[3];
        for (int i = 0; i < ratings.length; i++) {
            ratings[i] = 3 + i;
        }

        for (int i = 0; i < customerNames.length; i++) {
            System.out.println("Customer: " + customerNames[i] + ", Rating: " + ratings[i]);
        }
    }
}
