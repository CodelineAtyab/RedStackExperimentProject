import java.util.ArrayList;

public class FeedbackPortal{

private ArrayList<Feedback>allFeedback=new ArrayList<>();

public void addFeedback(Feedback feedback){  


allFeedback.add(feedback);  
  
}  

    
public void printReport(){  
  
    if(allFeedback.isEmpty())  
        System.out.println("No feedback yet");
      
    else  
for(Feedback feedback: allFeedback)
System.out.println(feedback);

}

public double getAverageRating(){


    if(allFeedback.isEmpty())
    return 0;

double AverageValue=0;

for(int i=0; i<allFeedback.size(); i++)
AverageValue+=allFeedback.get(i).getRating();

return AverageValue/allFeedback.size();



}

    
}