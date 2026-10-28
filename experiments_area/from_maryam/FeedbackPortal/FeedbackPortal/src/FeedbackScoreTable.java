public class FeedbackScoreTable {




    public static void main(String[] args) {


        int[][] scores = new int[3][3];

        scores[0][0]= 5;
        scores[1][0]= 4;
        scores[2][0]= 3;

        scores[0][1]= 4;
        scores[1][1]= 4;
        scores[2][1]= 5;


        scores[0][2]= 3;
        scores[1][2]= 5;
        scores[2][2]= 4;


        // for loop i and j because have 2D array
        //The first loop moves between the rows.
        //The second loop visits all 3 columns in each row


        for ( int i =0; i< 3 ; i++ ){
            for ( int j =0; j< 3 ; j++ ){

                System.out.print(scores[i][j] + " ");

            }
            System.out.println();




        }
    }}