import java.util.ArrayList;

public class FeedbackPortal{
    
    //a private Arralist to store feedback objects
    private ArrayList<Feedback> allFeedback = new ArrayList<>();  //Feedback is the parent class, so we can store all child objects in this list

    //method to add data to the arraylist
    public void addFeedback(Feedback feedback){ //Feedback id the type of object and feedback id the parameter name
        allFeedback.add(feedback);
    }

    //printing the report 
    public void printReport(){
        if (allFeedback.isEmpty()) {
            System.out.println("No feedback yet");
            return;
        }
        else{
            System.out.println("Feedback Report:");
            for(Feedback feedback : allFeedback){ //a loop to iterate through the arraylist and print the summary of each feedback object
                System.out.println(feedback.getSummary());
            }
        }
        
    }

    //get average rating of all feedback objects
    public double getAverageRating(){
        double totalRating = 0;

        //check if the arraylist is empty to avoid division by zero
        if(allFeedback.size() == 0){
            return 0.0;
        }
        else{
            for(Feedback feedback : allFeedback){
                totalRating += feedback.getRating();
            }
            return totalRating / allFeedback.size();
        }
    }

}