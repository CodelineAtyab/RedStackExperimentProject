import java.util.ArrayList;

import java.util.List;
public class Main {
    public static void main(String[] args) {
        FeedbackPortal f = new FeedbackPortal();
        f.addFeedback(new WebFormFeedback(1, "Aisha", "Great service", 5));  
        f.addFeedback(new EmailFeedback(2, "Omar", "Slow reply", 3, "omar@mail.com"));
        f.addFeedback(new PhoneFeedback(3, "Salma", "Helpful agent", 4, "99112233", 7));
        f.printReport();
        double avg = f.getAverageRating();
        System.out.printf("%.1f",avg);
        /*
        the overriding happened in getSummary method of the parent class.
        because each child class has it own way of printing the summary.
        
        it also happened in the feedback parent class where i overrid 
        toSting function to print get summary in the format i want.
        
        */

    }
}
