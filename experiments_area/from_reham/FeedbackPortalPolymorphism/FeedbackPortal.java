import java.util.ArrayList;
/*
 we need a place to manage all of the feedbacks it will be responsible for :
 - Storing feedback 
 - Adding Feedback 
 - Printing feedback 
 - Calculating average ratings.
*/
public class FeedbackPortal { 
     /*
    Why Feedback not String?
    We have 3 types of feedback (via email,phone and webform) 
    all three are inherit from the parent class "Feedback".
    Using Array List will allow us to store all three types in the same list  
     */
    private ArrayList<Feedback>allFeedbacks;
    
    public FeedbackPortal(){
        allFeedbacks=new ArrayList<>();
    }
   
    public void addFeedback(Feedback feedback){
        allFeedbacks.add(feedback);

    }

    public void printReport(){
        if (allFeedbacks.isEmpty()){
            System.out.println("There is no feedback");
        }else{
            for (Feedback feedback: allFeedbacks){
                System.out.println(feedback);
            }
        }
    }

    public double getAverageRating(){
        double sum =0 ;
        if(allFeedbacks.isEmpty()){
            return 0;
        }else{
            for(Feedback feedback :allFeedbacks){
            sum=sum+feedback.getRating();
            }
            double Avg =sum/allFeedbacks.size();
        
        return Avg;
        }
    }




}
    
