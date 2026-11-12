import java.util.ArrayList;

public class FeedbackPortal {

    // here to create an array list to store all feedback
    private ArrayList<Feedback> allFeedback = new ArrayList<>();

    // then add the feedback to the list
    public void addFeedback (Feedback feedback){

        allFeedback.add(feedback);
    }

    public void printReport(){

        // check if feedback is empty
        if (allFeedback.isEmpty()){

            System.out.println("No feedback yet");

        }else {
            // here use the loop through the list and print all feedback
            for (Feedback feedback: allFeedback){

                System.out.println(feedback);
            }
        }
    }

    // this to calc the average rate
    public double getAverageRating(){

        if(allFeedback.isEmpty()){
            return 0;
        }
        int total= 0;
        // then // Add all feedback ratings and sum total to rate
        for (Feedback feedback: allFeedback){

            total= total+ feedback.getRating();
        }
        // use duble in total because have point like 2.0
        return (double) total / allFeedback.size();
    }
}
