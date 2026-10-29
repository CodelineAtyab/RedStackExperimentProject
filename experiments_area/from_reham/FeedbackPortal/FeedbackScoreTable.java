public class FeedbackScoreTable{
    public static void main(String[] args) {

        String[] customerNames = {"Wafa","Haitham","Kumail"};
        int [][] score = new int[3][3];
        //Score[rows][cols]
        score[0][0]=5;
        score[0][1]=4;
        score[0][2]=3;
        score[1][0]=4;
        score[1][1]=4;
        score[1][2]=5;
        score[2][0]=3;
        score[2][1]=5;
        score[2][2]=4;
        for(int i=0; i<3;i++){
            for (int j=0 ; j<3 ; j++){
            System.out.print(score[i][j]);
            System.out.print(" ");
            }
            System.out.println();
            
        }

    }
}