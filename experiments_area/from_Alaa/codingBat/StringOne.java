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

    }
}