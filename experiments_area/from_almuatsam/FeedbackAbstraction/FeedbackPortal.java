import java.util.ArrayList;

public class FeedbackPortal {

    private ArrayList<Feedback> allFeedback = new ArrayList<>();

    public void addFeedback(Feedback feedback) {
        allFeedback.add(feedback);
    }

    public void printReport() {
        if (allFeedback.isEmpty()) {
            System.out.println("No feedback yet");
            return;
        }

        for (Feedback feedback : allFeedback) {
            System.out.println(feedback);
        }
    }

    public double getAverageRating() {
        if (allFeedback.isEmpty()) {
            return 0;
        }

        int total = 0;
        for (Feedback feedback : allFeedback) {
            total += feedback.getRating();
        }

        return (double) total / allFeedback.size();
    }
}
