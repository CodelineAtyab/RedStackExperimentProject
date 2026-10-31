import java.io.*;

public class FeedbackProtal {

    static void Logo() {
        String Text = "ACME SOLUTIONS ";
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < i + 1; j++) {

                System.out.print("* ");

                if (j == i) {
                    if (i == 3) {
                        System.out.print("       ");
                        System.out.print(Text);
                        System.out.print("      ");
                    } else
                        for (int spaces = 10; spaces > i; spaces--) {
                            System.out.print("    ");
                        }

                    for (int l = 0; l < j + 1; l++) {

                        System.out.print(" *");
                    }
                }
            }
            System.out.println();
        }
    }

    static void LoadFeedback() throws IOException {
        int count = 0;
        BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"));
        String line = reader.readLine();
        while (line != null) {
            count++;
            line = reader.readLine();
        }
        reader.close();

        if (count > 0) {
            System.out.println("Loaded " + count + " feedback entries from feedback.txt");
        }
    }

    public static void main(String[] args) {
        try {
            Logo();
            LoadFeedback();
        } catch (Exception e) {
            System.out.println("No saved feedback found. Starting fresh.");
        }

        

    }
}
