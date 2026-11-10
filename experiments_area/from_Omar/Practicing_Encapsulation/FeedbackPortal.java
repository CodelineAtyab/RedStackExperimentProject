import java.util.ArrayList;
public class FeedbackPortal{
    private ArrayList<Feedback> allFeedback = new ArrayList<>();

    public void AddFeedback(Feedback feedback){
        allFeedback.add(feedback);
    }

    public void printReport(){
        if(allFeedback.isEmpty()){
            System.out.println("no feedback yet");
        }else{
            for(Feedback feedback: allFeedback){

                System.out.println(feedback);
            }
        }
    }
    public double getAverageRating(){
        if(allFeedback.isEmpty()){
            return 0;
        }

        double totrating=0.0;

        for(Feedback feedback:allFeedback){
         totrating+=feedback.getRating();
        }
        return totrating/allFeedback.size();
    }
}