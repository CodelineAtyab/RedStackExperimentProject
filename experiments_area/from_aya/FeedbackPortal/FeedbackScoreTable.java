public class FeedbackScoreTable{
    public static void main(String[] args){
        Integer[][] scores = new Integer[3][3];

        scores[0][0] = 5;
        scores[0][1] = 4;
        scores[0][2] = 3;

        scores[1][0] = 4;
        scores[1][1] = 4;
        scores[1][2] = 5;

        scores[2][0] = 3;
        scores[2][1] = 5;
        scores[2][2] = 4;

      for (int i =0; i < 3; i = i+1 ){
        Integer[] row = scores[i];
       
       for (int j = 0; j < 3; j++){//col 
            System.out.print(row[j] + " ");
        }
        System.out.println();
    }
}
                    
    }
