
public class FeedbackScoreTable {
    public static void main(String[] args) {
        int [][] scores = {{5, 4, 3}, {4, 4, 5}, {3, 5, 4}};
        System.out.println("Score Table:");
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print(scores[i][j] + " ");
            }
            System.out.println();
        }

    }
}
