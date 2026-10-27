import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class BwriteBread {
    // A buffer is a temporary holding area in memory.
    // It makes reading and writing faster, because the program talks to the disk less often.
    // BufferedReader reads lines. BufferedWriter writes lines.
    // Both wrap a FileReader or FileWriter, which do the actual file work.
    // Always close the writer, or your file may end up empty.
    public static void main(String[] args) {
        String sourceFile = "source.txt"; // The file to read from
        String destinationFile = "destination.txt"; // The file to write to 
        try{
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile)); // allocating a memory buffer to read the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile)); // allocating a memory buffer to write the file
            
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage()); // Handle any IO exceptions that may occur during file operations
        }
    }
}