public class FeedbackRating{
    public static void main(String[]args)
    {
        //Part1
        String[] customerNames = new String[3];
        customerNames[0]="wafa";
        customerNames[1]="Haithm";
        customerNames[2]="Kumail";
        int[] ratings = new int[3];
        for(int i = 0;i<ratings.length;i++){
            ratings[i]= 3+i;}
        for(int i =0;i<ratings.length;i++){
            System.out.println("Customer 1 :"+customerNames[i]+" - rating "+ratings[i]);
    
        }
     
        
    }
}

