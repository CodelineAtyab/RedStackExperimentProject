import java.util.ArrayList;

public class FeedbackComments {
    public static void main(String[] args) {
        ArrayList<String> comments = new ArrayList<String>();
        comments.add("Great service");
        comments.add("Slow delivery");
        comments.add("Easy to use");
        comments.add("Nice design");
        comments.add("Needs dark mode");

        System.out.println("Third comment: " + comments.get(2));
        for (String comment : comments) {
            System.out.println(comment);
        }

        for (int i=0; i < 5; i++) {
            for ( String comment : comments) {
                System.out.println(comment);
            }
        }
    }
}