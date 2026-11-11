import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class FlexibleDataStore {
  public static void main(String[] args) {
    List<Integer> teamMemberIds = new LinkedList<>();
    teamMemberIds.add(10);
    teamMemberIds.add(11);
    teamMemberIds.add(12);
    teamMemberIds.add(13);
    teamMemberIds.add(14);
    teamMemberIds.add(15);
    teamMemberIds.add(16);
    teamMemberIds.add(17);
    teamMemberIds.add(18);
    teamMemberIds.add(19);
    teamMemberIds.add(20);

    teamMemberIds.get(4);

    for (Integer currId: teamMemberIds) {
      System.out.println(currId);
    }

    for (int count=0; count < teamMemberIds.size() - 1; count++) {
      System.out.println(teamMemberIds.get(count));
    }

    teamMemberIds.forEach((Integer currNum) -> {
      System.out.println(currNum);
    });

  }
}
