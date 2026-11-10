import java.util.ArrayList;

public class FeedbackPortal {
    private ArrayList<Feedback> allFeedback;

    public FeedbackPortal(){
        allFeedback = new ArrayList<>();
    }
    public void addFeedback(Feedback feedback){
        allFeedback.add(feedback);
    }

    public void printReport(){
        if(allFeedback.isEmpty()){
            System.out.println("No feedback yet.");
        }else {
            for (Feedback string : allFeedback) {
                System.out.println(string);
            }
        }
    }
    public double getAverageRating(){
        double sum = 0;
        if(allFeedback.isEmpty()){
            return 0;
        }
        for (Feedback string : allFeedback) {
            sum = sum + string.getRating();
        }
        sum = sum / allFeedback.size();

        return sum;
    }
}
