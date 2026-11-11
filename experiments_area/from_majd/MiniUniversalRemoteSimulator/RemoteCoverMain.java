import java.util.Scanner;

public class RemoteCoverMain {

        static Scanner scInput = new Scanner(System.in);
        static int channelChanger = 0;


        public static void main(String[] args) {

                RemoteCover lgtvRemote = new LGTVRemote();

                

                lgtvRemote.turnCounterUp();
                lgtvRemote.turnCounterUp();
                System.out.println("TV is "+lgtvRemote.togglePower());
                System.out.println(lgtvRemote.turnon());

        
                System.out.println(lgtvRemote.getInfoFromScreen());




                // for input testing
                // while (true) {

                //         System.out.println(lgtvRemote.getInfoFromScreen());

                //         System.out.print("Type 1 to change the channel. Type 0 to return to previous channel:");

                //         channelChanger = scInput.nextInt();

                //         if (channelChanger < 0 || channelChanger > 1)
                //                 break;
                //         else {

                //                 lgtvRemote.channelChanger(channelChanger);
                //         }

                // }

        }

}
