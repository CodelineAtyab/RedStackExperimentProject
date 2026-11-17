import java.util.ArrayList;

public class FeedbackPortal {

    private ArrayList<Feedback> allFeedback;

    public FeedbackPortal() {
        allFeedback = new ArrayList<>();
    }

    
    public void addFeedback(Feedback feedback) {
        allFeedback.add(feedback);
    }

    public void printReport() {

        if (allFeedback.isEmpty()) {
            System.out.println("No feedback yet");
        } else {

            for (Feedback feedback : allFeedback) {
                System.out.println(feedback);
            }
        }
    }

    public double getAverageRating() {

        if (allFeedback.isEmpty()) {
            return 0;
        }

        int totalRating = 0;

        for (Feedback feedback : allFeedback) {
            totalRating += feedback.getRating();
        }

        return (double) totalRating / allFeedback.size();
    }
}
