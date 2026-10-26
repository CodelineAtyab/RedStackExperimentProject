import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FeedbackScoreTable {

    public static void main(String[] args) {
        ArrayList<String>comments = new ArrayList<>();
        comments.add("Great service");
        comments.add("Slow delivery");
        comments.add("Easy to use");
        comments.add("Nice design");
        comments.add("Needs dark mode");

        System.out.println("Third comment: "+comments.get(2));
        System.out.println("--- for-each ---");
        for(String comment:comments){
            System.out.println(comment);
        }
        System.out.println("--- index loop ---");
        for(int i=0;i<5;i++){
            System.out.println(comments.get(i));
        }
    }
}