import java.util.HashMap;

public class DictionaryStore {
  public static void main(String[] args) {
    HashMap<String, HashMap<String, String>> userInfo = new HashMap<>();

    HashMap<String, String> teamMembers = new HashMap<>();
    teamMembers.put("member_1", "Mr.A");
    teamMembers.put("member_2", "Mr.B");
    teamMembers.put("member_3", "Mr.C");

    userInfo.put("team_members", teamMembers);
    // userInfo.put("designation", "PSE");
    // userInfo.put("id", "abcd1234");

    System.out.println(userInfo.get("team_members").get(teamMembers));
    // System.out.println(userInfo.get("designation"));
    // System.out.println(userInfo.get("name"));
  }
}
