
public class FeedbackScoreTable {

    public static void main(String[] args) {

         int [][] scoretable = new int[3][3];

        scoretable[0][0] = 5;
        scoretable[0][1] = 4;
        scoretable[0][2] = 3;
        scoretable[1][0] = 4;
        scoretable[1][1] = 4;
        scoretable[1][2] = 5;
        scoretable[2][0] = 3;
        scoretable[2][1] = 5;
        scoretable[2][2] = 4;

        for (int i=0; i < 3; i++) {
            for (int j=0; j < 3; j++) {
                System.out.print(scoretable[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    
}
