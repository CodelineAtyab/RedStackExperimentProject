import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FeedbackScoreTable {

    public static void main(String[] args) {
        int[][] scores = new int[3][3];
        //Wafa (row 0)
        scores[0][0]=5; //Service
        scores[0][1]=4; //Price
        scores[0][2]=3; //Speed

        //Haitham (row 1)
        scores[1][0]=4; //Service
        scores[1][1]=4; //Price
        scores[1][2]=5; //Speed

        //Kumail (row 2)
        scores[2][0]=3; //Service
        scores[2][1]=5; //Price
        scores[2][2]=4; //Speed

        for(int i=0; i<3; i=i+1){
            int[] innerArray = scores[i];

            for(int j=0; j<3; j++){
                System.out.print(innerArray[j] + " ");
            }
            System.out.println();
        }
    }
}