import java.util.ArrayList;

public class FeedbackPortal {

    private ArrayList<Feedback> allFeedback;

    public FeedbackPortal() {
        allFeedback = new ArrayList<>();
    }

    public void addFeedback(Feedback feedback){
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
            return 0.0;
        }
        double sum = 0;
        for (Feedback feedback : allFeedback) {
            sum += feedback.getRating();
        }
        return sum / allFeedback.size();
    }
}