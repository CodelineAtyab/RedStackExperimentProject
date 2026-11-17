import java.util.Scanner;

public class PanasonicRemote {

public static void main(String[] args) {
int currentTemp = 24;//
boolean isRemoteOn = false; //remote is off by defulte
boolean run = true;//run the loop (till the condition is false(exit))

// Scanner:to enter(input)the user choice
Scanner userInput = new Scanner(System.in);

// While loop repeats until the user exits
while (run) {
System.out.println("1) on   2) off   3) temp   4) exit");
System.out.print("Enter your choice:  ");

String c = userInput.nextLine();

// Switch handles the user's selection
switch (c) { // 2 cases -->user can choose the same action 2 diffrent ways
case "1"://no breaks petween the casse
case "on":
if (isRemoteOn) {
System.out.println("Remote is now ON");
} else {
isRemoteOn = true;
System.out.println("Remote is now ON");
}
break;// Exits the switch case

case "2":
case "off":
if (isRemoteOn) {
isRemoteOn = false;
System.out.println("Remote is now OFF");
} else {
System.out.println("Remote is now OFF");
}
break;

case "3"://displays the current temperature ==24(vari in the top)
case "temp":
System.out.println("Current temperature: " + currentTemp + "°C");
break;

case "4":
case "exit":
run = false;
break;

default:
System.out.println("Invalid choice");
}
}

// Close Scanner after the loop ends
userInput.close();
}
}