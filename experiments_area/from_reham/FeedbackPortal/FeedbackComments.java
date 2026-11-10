import java.util.ArrayList;
import java.util.List;

class FeedbackComments{
    public static void main(String[] args) {
        List<String> comments = new ArrayList<>();
        comments.add("Greate service");
        comments.add("Slow Delivery");
        comments.add("Easy To Use");
        comments.add("Nice Design");
        comments.add("Needs Dark Mode");
        System.out.println("\nThird comment: "+comments.get(2)+"\n");
        
        System.out.println("\n---for-each---");
        for(String comment : comments){
                System.out.println(comment);
            }
        System.out.println("\n---index-loop---");

        for(int i=0 ; i<comments.size(); i++ ){
           System.out.println(comments.get(i));
        }
    }
}