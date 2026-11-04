import java.util.ArrayList;
import java.util.Scanner;

public class AddMenuItemExample {
  public static void main(String[] args) {
    ArrayList<String> menu = new ArrayList<>();

    menu.add("Submit Feedback");
    menu.add("View All Feedback");
    menu.add("Rating Report");
    menu.add("Search by Product");
    menu.add("Save to file");
    menu.add("Exit");


    // menu.add(2, "Delete Feedback");
    // menu.forEach((menuItem) -> {System.out.println(menuItem);});

    for (int index=0; index<menu.size(); index++) {
      System.out.println(String.valueOf(index+1) + " " + menu.get(index));
    }

    Scanner inputBuffer = new Scanner(System.in);
    String menuOptionToAdd = inputBuffer.nextLine();
    Integer menuOptionPosition = Integer.parseInt(inputBuffer.nextLine());

    System.out.println("=================================================");
    System.out.println(menuOptionToAdd);
    System.out.println(menuOptionPosition);

    // Recreate the new menu
    int newMenuSize = menu.size() + 1;
    String[] newMenu = new String[newMenuSize];

    // Fill the new Menu
    for (int new_index=0, old_index=0; new_index < newMenuSize; new_index++) {
      if (new_index == (menuOptionPosition-1)) {
        newMenu[new_index] = menuOptionToAdd;
      } else {
        newMenu[new_index] = menu.get(old_index);
        old_index++;
      }
    }

    // Print the new Menu
    for (int index=0; index < newMenuSize; index++) {
      System.out.println(String.valueOf(index+1) + " " + newMenu[index]);
    }

  }
}