package Warmup1;

public class front3 {


    public static void main(String[] args) {

        front3 obj = new front3();

        System.out.println(obj.front3("Java"));
        System.out.println(obj.front3("Chocolate"));
        System.out.println(obj.front3("abc"));

    }


    public String front3(String str) {
        String front;

        if (str.length() >= 3) {
            front = str.substring(0, 3);
        } else {
            front = str;
        }
        return front + front + front;
    }
}



