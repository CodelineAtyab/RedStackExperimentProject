import java.util.Scanner;


public class CustomerFeedbackManager{

    static String readText(String prompt){
    Scanner scInput=new Scanner(System.in); 
    System.out.println(prompt);

    String inputValue=scInput.nextLine();

    return inputValue;

}
    static int readNumber(String prompt){
    Scanner scInput=new Scanner(System.in); 

    System.out.println(prompt);

    int inputValue=scInput.nextInt();

    return inputValue;

}


static void write(String text){

    System.out.println(text);
}


public static void main(String [] args){



String name=readText("Enter your name: ");

int age=0,birthYear=readNumber("Enter your Year Of Birth:");

    
age=2026-birthYear;

    write("Hello "+name+" Welcome to the program. "+"You are "+(age)+" years old");
}

}