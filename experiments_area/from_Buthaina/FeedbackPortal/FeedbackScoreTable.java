public class FeedbackScoreTable{
public static void main(String[]args){
int[][] scores = new int[3][3];
scores[0][0]= 5;//service
scores[0][1]= 4;//price
scores[0][2]= 3;//speed 

scores[1][0]= 4;//service
scores[1][1]= 4;//price
scores[1][2]= 5;//speed
 
 scores[2][0]= 3;//service
scores[2][1]= 5;//price
scores[2][2]= 4;//speed
System.out.println("service price speed");
for (int i = 0; i < scores.length; i++) {
    for (int j = 0; j < scores[i].length; j++) {
        System.out.print(scores[i][j] + " ");
    }
    System.out.println();
}
}
}

