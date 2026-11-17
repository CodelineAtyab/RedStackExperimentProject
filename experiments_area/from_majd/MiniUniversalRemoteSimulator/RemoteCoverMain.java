import java.util.Scanner;

public class RemoteCoverMain {

        static Scanner scInput = new Scanner(System.in);
        static int channelChanger = 0;


        public static void main(String[] args) {

                RemoteCover lgtvRemote = new LGACRemote(false);

                System.out.println(lgtvRemote.getInfoFromScreen());

                lgtvRemote.turnon();
                System.out.println(lgtvRemote.getInfoFromScreen());

                lgtvRemote.turnCounterUp();
                lgtvRemote.turnCounterDown();
                lgtvRemote.turnoff();
        
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
