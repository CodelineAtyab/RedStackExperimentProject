import java.util.ArrayList;
import java.util.List;

public class FeedbackComments {
    public static void main(String[] args) {
        List<String> comments = new ArrayList<>();
        comments.add("Great service");
        comments.add("Slow delivery");
        comments.add("Easy to use");
        comments.add("Nice design");
        comments.add("Needs dark mode");

        System.out.println("Third comment: " + comments.get(2));

        System.out.println("--- for-each ---");
        for (String output : comments) {
            System.out.println(output);
        }

        System.out.println("--- index loop ---");
        for (int i = 0; i < comments.size(); i++) {
            System.out.println(comments.get(i));
        }
        
    }  
}
