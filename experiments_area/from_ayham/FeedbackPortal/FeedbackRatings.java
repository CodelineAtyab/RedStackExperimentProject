public class FeedbackRatings {
    public static void main(String[] args) {
        String[] customerNames = {"Wafa", "Haithm", "Kumail"};
        int [] ratings = new int[3];

        for (int i =0; i<customerNames.length; i++){
            ratings[i] = 3+i;
        }

        for (int i =0; i<customerNames.length; i++){
            System.out.println("Customer Name: " + customerNames[i] + " - Rating: " + ratings[i]);
        }

    }
}