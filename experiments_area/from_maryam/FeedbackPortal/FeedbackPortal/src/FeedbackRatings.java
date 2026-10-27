
public class FeedbackRatings {


public static void main(String[] args) {
    String[] customerNames = new String[3];


    customerNames[0]= "Wafa";
    customerNames[1]= "Haitham";
    customerNames[2]= "Kumail";


    int[] ratings = new int[3];

    // 3+0
    // 3+1
    // 3+2

    for ( int i =0; i< 3 ; i++ ){

        ratings[i]= 3+i;
    }

    for ( int i =0; i< 3 ; i++ ){

        System.out.println(("Customer " + (i + 1) + ": " + customerNames[i] + " - rating " + ratings[i]));

    }



}}

