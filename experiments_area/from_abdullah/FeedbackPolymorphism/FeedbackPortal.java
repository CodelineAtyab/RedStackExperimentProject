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

        for (int i = 0; i < allFeedback.size(); i++) {
            Feedback feedback = allFeedback.get(i);
            System.out.println(feedback);
        }
    }

    public double getAverageRating() {
        if (allFeedback.isEmpty()) {
            return 0.0;
        }

        double total = 0;

        for (int i = 0; i < allFeedback.size(); i++) {
            total = total + allFeedback.get(i).getRating();
        }

        return total / allFeedback.size();
    }
}