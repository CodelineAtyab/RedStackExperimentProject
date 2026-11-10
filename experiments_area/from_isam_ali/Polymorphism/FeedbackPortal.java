import java.util.ArrayList;


public class FeedbackPortal {

    private ArrayList<Feedback> allfeedbacks = new ArrayList<>();

    public void addFeedback(Feedback feedback) {
        allfeedbacks.add(feedback);
    }

    public void printReport() {
        if (allfeedbacks.isEmpty()) {
            System.out.println("No feedbacks found");
            return;

        } else {
            for (Feedback feedback : allfeedbacks) {
                System.out.println(feedback);
            }
        }
    }
        public double getAverageRating() {
            if (allfeedbacks.isEmpty()) {
                return 0;
            }

            int  sum = 0;
            for (Feedback feedback : allfeedbacks) {
                sum += feedback.getRating();
            }
            return (double) sum / allfeedbacks.size();
        }

}
