public class HelloWorld{
	public static void main(String[] args){
		System.out.println("Team Red Stack !!!");
		System.out.println(HelloWorld.makes10(5,10));
	}
	public static  boolean makes10(int a, int b) {
		if (a == 10 || b == 10 || a+b == 10){
			return true;
		}else{
			return false;
		}
}
}