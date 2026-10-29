public class FeedbackScoreTable {

    public static void main(String[] args){
        int[][] scores = new int[3][3];

        scores[0][0]=5;
        scores[0][1]=4;
        scores[0][2]=3;

        scores[1][0]=4;
        scores[1][1]=4;
        scores[1][2]=5;

        scores[2][0]=3;
        scores[2][1]=5;
        scores[2][2]=4;

        for(int scoresIndex=0; scoresIndex<3; scoresIndex++ ){
            
            int[] innerArray = scores[scoresIndex];

            for(int i=0; i<3; i++){
                System.out.print(innerArray[i]+ " ");
            }
            System.out.println();
        }


    }
}