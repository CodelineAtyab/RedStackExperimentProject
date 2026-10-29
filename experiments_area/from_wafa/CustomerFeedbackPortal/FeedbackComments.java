import java.util.ArrayList;

public class FeedbackComments {

    public static void main(String[] args){

        ArrayList<String> comments = new ArrayList<>();

        comments.add("Great service");
        comments.add("Slow delivery");
        comments.add("Easy to use");
        comments.add("Nice design");
        comments.add("Needs dark mode");

        System.out.println("Third comment: " + comments.get(2));

        System.out.println("--- for-each ---");
        for(String commentId : comments){
            
            System.out.println(commentId);
        }

        System.out.println("--- index loop ---");
        for(int commentId=0 ; commentId< comments.size();commentId++){
            
            System.out.println(comments.get(commentId));
        }

        System.out.println("--- forEach with a lambda---");
        comments.forEach(commentId -> System.out.println(commentId));



    }
}