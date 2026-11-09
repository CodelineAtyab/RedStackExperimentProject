public class StoreAlot {
  public static void main(String[] args) {
    System.out.println("Test!");

    /*
    Each team member in Codeline should be given an ID. Then you must print all the IDs here.
    */
    int totalTeamMembers = 5;
    int[] teamMemberIds = new int[totalTeamMembers];

    // Storing all the IDs
    for (int idCount=0; idCount < totalTeamMembers; idCount++) {
      teamMemberIds[idCount] = idCount + 10;
    }

    // Just printing all the Ids one by one
    for (int idCount=0; idCount < totalTeamMembers; idCount++) {
       System.out.println(teamMemberIds[idCount]);
    }

    // int teamMemberId1 = 10;
    // int teamMemberId2 = 11;
    // int teamMemberId3 = 12;
    // int teamMemberId4 = 13;
    // int teamMemberId5 = 14;

    // System.out.println(teamMemberId1);
    // System.out.println(teamMemberId2);
    // System.out.println(teamMemberId3);
    // System.out.println(teamMemberId4);
    // System.out.println(teamMemberId5);
  }
}
