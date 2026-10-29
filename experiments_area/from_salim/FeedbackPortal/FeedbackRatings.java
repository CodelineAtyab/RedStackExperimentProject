public class FeedbackRatings {
    public static void main(String[] args) {
        String[] customerNames = new String[3]; 
        customerNames[0] = "Wafa";
        customerNames[1] = "Haitham";
        customerNames[2] = "Kumail";

        int[] ratings = new int[3];

        for (int i = 0; i<ratings.length; i++)
        {
            ratings[i] = (3+i);
        }
        for (int j = 0; j<3; j++)
        {
            System.out.println("Customer " + (j + 1) + ": " + customerNames[j] + " - rating " + ratings[j]);
        }
    }
    
}
