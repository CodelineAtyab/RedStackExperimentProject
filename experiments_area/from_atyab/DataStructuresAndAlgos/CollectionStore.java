public class CollectionStore {
  public static void main(String[] args) {
    System.out.println("Test!");

    String[] teamMemberNames = new String[3];  // Array always has a fixed size at the time of declaration

    // 0, 1 and 2 are indexes so you don't have to remember the addresses for each box just like the concept in vars
    teamMemberNames[0] = "Wafa";
    teamMemberNames[1] = "Haitham";
    teamMemberNames[2] = "Kumail";
    
    teamMemberNames[1] = "Mr.Haitham";

    int[] teamMemberIds = new int[3];
    teamMemberIds[0] = 1000;
    teamMemberIds[1] = 1010;
    teamMemberIds[2] = 3010;

    System.out.println(teamMemberNames[1]);
  }
}