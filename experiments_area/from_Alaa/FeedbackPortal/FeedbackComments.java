import java.util.ArrayList; 
import java.util.List;
public class FeedbackComments{
    public static void main (String[] args) {
        List<String> comments = new ArrayList<>();
        comments.add("Great service");
        comments.add("Slow delivery");
        comments.add("Easy to use");
        comments.add("Nice design");
        comments.add("Need dark mode");
        
   
        System.out.println(comments.get(2)); //2 index is the third element in the list

        System.out.println("--for-each loop--");
         for (String comment : comments) { // printing with a for-each loop
            System.out.println(comment); //for each string comment in comments, print the comment
        }

        System.out.println("--index loop--");
        for (int i = 0; i < comments.size(); i++) { // printing with a for loop
            System.out.println(comments.get(i));
        }


    }
}