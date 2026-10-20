public class Warmup2 {
    public static void main(String[] args) {
    }
    // FrontBack
    public String frontBack(String str) {
        if (str.length() <= 1)
            return str;

        String mid = str.substring(1, str.length()-1);

        return str.charAt(str.length()-1) + mid + str.charAt(0);
    }

    // Front3
    public String front3(String str) {
        String front;

        if (str.length() >= 3){
            front = str.substring(0,3);
        }
        else {
            front = str;
        }
        return front + front +  front;
    }

    //backAround
    public String backAround(String str) {
        String last = str.substring(str.length() - 1);
        return last + str + last;
    }

    //or35
    public boolean or35(int n) {
        return (n % 3 == 0) || (n % 5 ==0);
    }

    //front22
    public String front22(String str) {
        int take = 2;
        if (take > str.length()){
            take = str.length();
        }
        String front = str.substring(0, take);
        return front + str + front;
    }

}
