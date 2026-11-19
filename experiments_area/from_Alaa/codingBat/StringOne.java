public class StringOne {

    //helloName
    public static String helloName(String name) {
        return "Hello " + name + "!";
    }

    //make Abba
    public static String makeAbba(String a, String b) {
    return a +b +b +a;
    }

    //makeTags
    public static String makeTags(String tag, String word) {
    return "<"+tag+">"+word+"<"+"/"+tag+">";
    }

    //makeOutWord
    public static String makeOutWord(String out, String word) {
    String firstPart = out.substring(0,2);
    String secondPart = out.substring(2,4);
    return firstPart + word + secondPart;
    }


    //extraEnd
    public static String extraEnd(String str) {
        String lastTwo = str.substring(str.length() - 2); // it goes from length-2 till the end of the string
        return lastTwo + lastTwo + lastTwo;
    }

    //firstTwo
    public static String firstTwo(String str) {
        if (str.length() < 2) {
            return str;
        } else {
            return str.substring(0, 2);
        }
    }

    //firstHalf
    public static String firstHalf(String str) {
        int halfLength = str.length() / 2;
        return str.substring(0, halfLength);
    }

    //withoutEnd
    public static String withoutEnd(String str) {
        if (str.length() <= 2) {
            return "";
        } else {
            return str.substring(1, str.length() - 1);
        }
    }

    //comboString
    public static String comboString(String a, String b) {
        if (a.length() < b.length()) {
            return a + b + a;
        } else {
            return b + a + b;
        }
    }

    public static void main(String[] args) {
        System.out.println(helloName("Alice"));
        System.out.println(helloName("Bob"));
        System.out.println(helloName("Charlie"));

        System.out.println(makeAbba("Hi", "Bye"));
        System.out.println(makeAbba("Yo", "Alice"));

        System.out.println(makeTags("i", "Hello"));
        System.out.println(makeTags("b", "Bold"));

        System.out.println(makeOutWord("<<>>", "Yay"));
        System.out.println(makeOutWord("[[]]", "word"));

        System.out.println(extraEnd("Hello"));
        System.out.println(extraEnd("ab"));

        System.out.println(firstTwo("Hello"));
        System.out.println(firstTwo("ab"));

        System.out.println(firstHalf("Hello"));
        System.out.println(firstHalf("abc"));

        System.out.println(withoutEnd("Hello"));
        System.out.println(withoutEnd("ab"));

        System.out.println(comboString("Hello", "Hi"));
        System.out.println(comboString("Hi", "Hello"));

    }
}