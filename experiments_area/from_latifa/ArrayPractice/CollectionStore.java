public class CollectionStore {
    public static void main(String[] args){
        System.out.println("Test!");

        String[] teamMemberName;
        //new --> dynamic memory location
        teamMemberName = new String[3]; //Array always has a fixed size at the time of declaration

        // 0 1 and 2 are indexes so you don't have to remember the addresses for each box just like the concept in vars
        teamMemberName[0] ="Wafa";
        teamMemberName[1] ="Haitham";
        teamMemberName[2] ="Kumail";

        teamMemberName[1] ="Isam"; //rename
        


        // int[] teamMemberName =new int[3];
        // teamMemberName[0]=1000;
        // teamMemberName[1]=1010;
        // teamMemberName[2]=3010;




        System.out.println(teamMemberName[1]);

    }
}