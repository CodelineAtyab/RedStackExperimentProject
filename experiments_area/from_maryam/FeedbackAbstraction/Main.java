public class Main {


    public static void main(String[] args) {


        // We cannot create an object from Feedback because it is an abstract class.
        // Feedback f1 = new Feedback(1, "Aisha", "Great service", 5);
        //here use for child class
        WebFormFeedback f = new WebFormFeedback(1, "Aisha", "Great service", 5);

        System.out.println(f.getSummary());

    }
}
