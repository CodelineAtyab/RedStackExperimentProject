import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class fileHandling {
    public static void main(String[] args) {
        writer();
        System.out.println("--------------------------------");
        System.out.println("Contents of the file after writing:");
        reader();
        System.out.println("--------------------------------");
        System.out.println("Copying contents to Copy.txt...");
        copy();
        System.out.println("Copied");
        System.out.println("--------------------------------");
        
    }
    public static void reader(){
        try{
            BufferedReader br = new BufferedReader (new FileReader("C:\\Users\\Tanka\\Documents\\Opal\\RedStackExperimentProject\\experiments_area\\from_Haitham\\FileHandling\\text.txt"));
            String line ;
            while((line=br.readLine()) != null){
                System.out.println(line);
                }
            } catch(IOException e){System.out.println("error: "+e);}
        }

        public static void writer(){
            try{
                BufferedWriter bw = new BufferedWriter (new FileWriter("C:\\Users\\Tanka\\Documents\\Opal\\RedStackExperimentProject\\experiments_area\\from_Haitham\\FileHandling\\text.txt"));
                Scanner sc = new Scanner(System.in);
                System.out.println("Type 'exit' to stop writing to the file.");
                while(true){
                System.out.println("Enter text to write in file: ");
                String text = sc.nextLine();
                if (text.equals("exit"))
                {
                    System.out.println("Exiting the program.");
                    sc.close();
                    break;
                }
                bw.write(text);
                bw.newLine();
                bw.flush();
            }
            }catch(IOException e){System.out.println("error: "+e);}
        }
        
        public static void copy(){
            try{
                BufferedReader br = new BufferedReader (new FileReader("C:\\Users\\Tanka\\Documents\\Opal\\RedStackExperimentProject\\experiments_area\\from_Haitham\\FileHandling\\text.txt"));
                BufferedWriter bw = new BufferedWriter (new FileWriter("C:\\Users\\Tanka\\Documents\\Opal\\RedStackExperimentProject\\experiments_area\\from_Haitham\\FileHandling\\Copy.txt"));
                String line ;
                while((line=br.readLine()) != null){
                    bw.write(line);
                    bw.newLine();
                }
                bw.flush();
            } catch(IOException e){System.out.println("error: "+e);}
        }
    }

