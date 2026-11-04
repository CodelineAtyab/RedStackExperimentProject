public class DumpTriangle {
  public static void main(String[] args) {
    /*
          *
         ***
        *****
       *******
      *********
    */
    
    for (int outerCount=1; outerCount <= 5; outerCount ++) {
      // Loop for spacing
      for (int innerCount=(5-outerCount); innerCount > 0; innerCount--) {      
        System.out.print(" ");
      }

      for (int innerCount=0; innerCount < (((outerCount) * 2) - 1); innerCount++) {      
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
