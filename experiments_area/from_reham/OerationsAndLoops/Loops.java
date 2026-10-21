public class Loops{
    public static void main(String[] args) {
        int n =3;

        for (int r=1;r<=n;r++){
            for ( int s=n-r;s>0;s--){
                System.out.print(" ");
            }
            for(int st=1;st<=2*r-1;st++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int r=n-1 ; r>=1;r--){
            for(int s=n-r;s>0;s--){
                System.out.print(" ");
            }
            
            for (int st=1;st<=2*r-1;st++ ){
            System.out.print("*");}
            System.out.println();
            
        }
        }
    }

