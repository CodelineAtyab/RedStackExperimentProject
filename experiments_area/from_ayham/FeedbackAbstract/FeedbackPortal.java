import java.util.ArrayList;

public class FeedbackPortal {
    private ArrayList<Feedback> AllFeedback = new ArrayList<>();


    public void addFeedback(Feedback feedback) {
        AllFeedback.add(feedback);
    }

    public void printReport() {
        for (Feedback feedback : AllFeedback) {
            System.out.println(feedback);
        }
    }

    public double getAverageRating() {
        if (AllFeedback.isEmpty()) {
            return 0.0;
        }

        int totalRating = 0;
        for (Feedback feedback : AllFeedback) {
            totalRating += feedback.getRating();
        }
        return (double) totalRating / AllFeedback.size();
    }
}
