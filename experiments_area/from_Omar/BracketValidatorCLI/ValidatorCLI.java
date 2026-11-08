import java.util.Deque;
import java.util.Scanner;
import java.util.LinkedList;
public class ValidatorCLI {
    public static void main(String[] args) {
        Scanner inputBuffer=new Scanner(System.in);
        int numEX=Integer.parseInt(inputBuffer.nextLine());

        for(int i=0;i < numEX;i++){
            String expr=inputBuffer.nextLine();
            Deque<String> browserHistory=new LinkedList<>();

            boolean isValid = true;

            for(int j=0; j < expr.length();j++){
                char ch=expr.charAt(j);

                if(ch == '(' || ch == '{'){
                    browserHistory.push(String.valueOf(ch));
                }
                else if(ch == ')'){
                    if(browserHistory.isEmpty()){
                        isValid = false;
                        break;
                    }
                    String top = browserHistory.peek();
                    if(!top.equals("(")){
                        isValid = false;
                        break;
                    }
                    browserHistory.pop();
                }
                else if(ch == '}'){
                    if(browserHistory.isEmpty()){
                        isValid=false;
                        break;
                    }
                    String top=browserHistory.peek();
                    if(!top.equals("{")){
                        isValid=false;
                        break;
                    }
                    browserHistory.pop();
                }
            }

            if(!browserHistory.isEmpty()){
                isValid=false;
            }

            if(isValid){
                System.out.println(expr+" -> valid");
            }
            else{
                System.out.println(expr+"-> invalid");
            }
        }
    }
}
