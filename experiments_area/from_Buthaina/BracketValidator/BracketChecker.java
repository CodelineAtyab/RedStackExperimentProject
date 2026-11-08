import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
 public class BracketChecker{

    public static boolean isValid(String expression){
        //create a stack using requaired declaration
        Deque<String> browserHistory = new LinkedList<>();
      
        for (int i =0; i<expression.length();i++)
        {
            char ch = expression.charAt(i);
            //opening brackets push onto the stack 
            if(ch=='(' || ch == '{'){
                browserHistory.push(String.valueOf(ch));
            }
                //closing brackets 
                else if (ch == ')' || ch == '}')
                {
                    //no opening prackets a valiable
                    if(browserHistory.isEmpty()){
                        return false;
                    }
                        String lastOpening = browserHistory.pop();
                        //check wether brackets match
                        if(ch ==')'&& !lastOpening.equals("(")){
                            return false;
                        }
                        if(ch == '}' && !lastOpening.equals("{")){
                            return false;
                        }

                    }
                }
                //valid only when no opening brakets remain
                return browserHistory.isEmpty();
            } 
            public static void main(String[]args){
                Scanner scanner = new Scanner(System.in);
                System.out.println("==bracket validator==");
                while(true){
                    System.out.print("\nEnter an Expression(or Exit):");
                    String expression = scanner.nextLine();
                    if(expression.equalsIgnoreCase("exit")){
                        System.out.println("Goodbye");
                        break;
                    }
                    if(isValid(expression)){
                        System.out.println("VALD");
                    }else{
                        System.out.println("INVALID");
                    }
                    }
                   scanner.close();
                
            }

 
        }
 
