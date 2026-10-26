
import java.util.List;
import java.util.ArrayList;

public class FeedbackComments {
    public static void main(String[] args) {

        List<String> comments = new ArrayList<>();

        comments.add("Great service");
        comments.add("Slow delivery");
        comments.add("Easy to use");
        comments.add("Nice design");
        comments.add("Needs dark mode");

        System.out.println("Third comment: " + comments.get(2));

        //for-each loop
        System.out.println("--- for-each loop ---");
        for (String comment : comments) {
            System.out.println(comment);
        }

        // index loop 
        System.out.println("--- index loop ---");
        for (int i = 0; i < comments.size(); i++) {
            System.out.println(comments.get(i));
        }
        // forEach with lambda
        System.out.println("--- foreach with lambda ---");
        comments.forEach(comment -> System.out.println(comment));

        
    }
}
