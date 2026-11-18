import java.util.ArrayList;

public class FeedbackComments {

    public static void main(String[] args) {

        ArrayList<String>comments = new ArrayList<>();
        comments.add("Great service");
        comments.add("Slow delivery");
        comments.add("Easy to use");
        comments.add("Nice design");
        comments.add("Needs dark mode");

        System.out.println("Third comment: "+comments.get(2));
        System.out.println("--- for-each ---");
        //for each loop
        for(String comment:comments){
            System.out.println(comment);
        }
        //traditional index loop
        System.out.println("--- index loop ---");
        for(int i=0;i<5;i++){
            System.out.println(comments.get(i));
        }
        //forEach with a lambda
        System.out.println("--- forEach with lambda ---");
        comments.forEach(comment -> System.out.println(comment));
    }


    
}