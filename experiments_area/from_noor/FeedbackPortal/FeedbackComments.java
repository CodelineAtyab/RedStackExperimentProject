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


System.out.print("Third comment: " +comments.get(2));

//for-each 
System.out.println("--- for-each ---");
for (String item : comments) {
    System.out.println(item);
}


//traditional index loop
System.out.println("--- index loop ---");

for (int i = 0; i < comments.size(); i++) {
    System.out.println(comments.get(i));
    
}

//for forEach with a lambda

 System.out.println("--- forEach with lambda ---");
comments.forEach(comment -> System.out.println(comment));

}
}
