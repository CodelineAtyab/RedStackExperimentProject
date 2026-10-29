public class FeedbackScoreTable{
    public static void main (String[] args){
        int [][] scores = new int[3][3]; //grid of 3 rows and 3 columns
        //first row
        scores[0][0] = 5; //service 
        scores[0][1] = 4; //price
        scores[0][2] = 3; //speed
        //second row
        scores[1][0] = 4;
        scores[1][1] = 4;
        scores[1][2] = 5;
        //third row
        scores[2][0] = 3;
        scores[2][1] = 5;
        scores[2][2] = 4;

        // Print the scores
        for (int i = 0; i < scores.length; i++) { // iterate through each row
            for (int j = 0; j < scores[i].length; j++) { // iterate through each column in the current row
                System.out.print(scores[i][j] + " "); //value of row i and column j
            }
            System.out.println(); // moves to a new line after the inner loop finishes.
        }

    }
}