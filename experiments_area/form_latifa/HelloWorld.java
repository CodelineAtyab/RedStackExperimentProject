public class HelloWorld {
	public static void main(String[] args){
		System.out.println("Team Red Stack !!!");
		
		//sumDouble output
		System.out.println(sumDouble(1,2));
		System.out.println(sumDouble(3,2));
		System.out.println(sumDouble(2,2));
	
		
	}
	//sumDouble
	public static int sumDouble(int a, int b) {
		if (a == b){
			return (a +b )* 2;
		}else{
			return a +b;
		}
  
	}
	
}