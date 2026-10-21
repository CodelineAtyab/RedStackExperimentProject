import java.util.Scanner;

public class diamond {
    public static void main(String[] args) {
        System.out.print("how many rows do you want? : ");
        Scanner sc = new Scanner(System.in);
        int rrows = sc.nextInt();
        printDiamond(rrows);
        sc.close();
    }
    public static void printDiamond(int rows){
        for (int i = 0; i<=rows ; i++)
        {
            
            for (int j = rows; j>i; j--)
            {
                System.out.print(" ");
            }
            for (int k = 0; k < (i*2-1) ; k++)
            {
                System.out.print("*");
            }
            System.out.println();   
        }
        for (int i = rows-1 ;i>=1 ; i--)
        {
            for (int j = rows; j>i ; j--)
            {   
                System.out.print(" ");
            }
            for (int k = 0; k < (i*2-1) ; k++ )
            {
                System.out.print("*");
            }
            System.out.println(); 
        }
        
    }
}
