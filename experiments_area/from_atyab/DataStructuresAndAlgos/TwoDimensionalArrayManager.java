public class TwoDimensionalArrayManager {
  public static void main(String[] args) {
    String[] daysInWeek = new String[7];
    daysInWeek[0] = "Monday";
    daysInWeek[1] = "Tuesday";
    daysInWeek[2] = "Wednesday";

    String[][] board = new String[3][3];

    // Set the first Box with a child array. Fill 3 Boxes of the child array.
    board[0][0] = "X";
    board[0][1] = "O";
    board[0][2] = "X";

    // Set the second Box with a child array. Fill 3 Boxes of the child array.
    board[1][0] = "X";
    board[1][1] = "O";
    board[1][2] = "O";

    // Set the third Box with a child array. Fill 3 Boxes of the child array.
    board[2][0] = "O";
    board[2][1] = "O";
    board[2][2] = "O";

    // Print all the Elements
    for (int parentIndex=0; parentIndex < 3; parentIndex = parentIndex + 1) {
      // System.out.println(board[parentIndex]); // board[2] -> array with 3 boxes
      String[] innerArray = board[parentIndex];

      
      for (int i=0; i<3; i++) {
        System.out.print(innerArray[i] + " ");
      }
      System.out.println();
    }
  }
}
