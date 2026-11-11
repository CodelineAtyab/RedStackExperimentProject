public class main{
    public static void main(String[] args) {
        Feedback f = new Feedback(1,"Aisha","Great Service", 5);
        f.setMessage("");
        f.setRating(9);
        System.out.println(f.getCustomerName() + " | " + f.getMessage() + " | " + f.getRating());
    }
}