public class FeedbackScoreTable {
    public static void main(String[] args) {
        int[][] scores = new int[3][3];
        scores[0][0] = 5;
        scores[0][1] = 4;
        scores[0][2] = 3;
        scores[1][0] = 4;
        scores[1][1] = 4;
        scores[1][2] = 5;
        scores[2][0] = 3;
        scores[2][1] = 5;
        scores[2][2] = 4;

        for (int row = 0; row < scores.length; row++){
            for (int column = 0; column<3; column++){
                System.out.print(scores[row][column] + " ");
            }
            System.out.println();
        }
    }
}
