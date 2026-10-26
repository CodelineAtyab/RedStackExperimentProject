import java.util.ArrayList;
import java.util.List;

public class FeedbackComments {
    public static void main(String[] args) {
        
        List<String> comments = new ArrayList<String>();

        comments.add("Great service");
        comments.add("Slow delivery");
        comments.add("Easy to use");
        comments.add("Nice design");
        comments.add("Needs dark mode");

        System.err.println("Third comment: " + comments.get(2));

        System.err.println("--- for-each ---");

        for (String comment : comments) {
            System.err.println(comment);
        }

        System.err.println("--- index loop ---");

        for(int i=0; i<comments.size(); i++){
            System.err.println(comments.get(i));
        }
    }
}
