import java.util.ArrayList;
import java.util.List;
public class FeedbackComments{
    public static void main(String[]args){
        List<String> comments = new ArrayList<>();
        comments.add("Great service!");
        comments.add("Slow delivary");
        comments.add("Easy to use");
        comments.add("Nice design");
        comments.add("Needs dark mode");
        System.out.println("All comments:");
        System.out.println(comments);
        // for-each loop 
        System.out.println("\nFor-each loop:");
        for(String comment:comments){
            System.out.println(comment);
        }
        //traditional index loop
        System.out.println("\nTraditional index loop:");
        for(int i=0;i<comments.size();i++){
            System.out.println(comments.get(i));
        }
        
    }
}