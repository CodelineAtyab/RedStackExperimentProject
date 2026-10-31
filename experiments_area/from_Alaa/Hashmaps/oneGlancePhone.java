import java.util.HashMap;
import java.util.Scanner;
public class oneGlancePhone {
    public static void main(String[] args) {
        HashMap<String, String> phoneBook = new HashMap<>(); // creating a Hashmap
        phoneBook.put("John", "123-456-7890"); // adding key-value pairs
        phoneBook.put("Jane", "987-654-3210");
        phoneBook.put("Bob", "555-555-5555");
        phoneBook.put("Alice", "111-222-3333");
        phoneBook.put("Charlie", "444-555-6666");

        /* why HashMap is used here:
          1. O(1) average-time lookup: Instantly retrieves an extension by name.
          2. Unique keys: Prevents duplicate names while allowing easy overwriting of existing entries.
          3. No ordering requirement: Extensions don’t need to be stored or displayed in any specific order, making a map the optimal choice.*/

        Scanner scanner = new Scanner(System.in); // creating a scanner object to read user input
        System.out.println("enter a name to look up their phone number: ");
        String name = scanner.nextLine(); //saving the user input in a variable
        String phoneNumber = phoneBook.get(name); // retrieving the value for the given key
        if (phoneNumber == null) {
            System.out.println("Extension not found");
        } else {
        System.out.println(name + "'s extension is:  " + phoneNumber);
        }

    }
}