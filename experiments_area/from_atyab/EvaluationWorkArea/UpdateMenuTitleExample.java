public class UpdateMenuTitleExample {
  public static void main(String[] args) {
    String currentMenu = "|                                    |";
    int totalLength = currentMenu.length();
    int availableSpace = totalLength - 2;

    String newTitle = "Red Stack";
    int totalSpacesCount = availableSpace - newTitle.length();
    int leftRightPaddingCount = totalSpacesCount / 2;

    System.out.print("|");
    for (int count=0; count<leftRightPaddingCount; count++) {
      System.out.print(" ");
    }
    System.out.print(newTitle);
    for (int count=0; count<leftRightPaddingCount; count++) {
      System.out.print(" ");
    }
    System.out.print("|");
    System.out.println();

  }
}
