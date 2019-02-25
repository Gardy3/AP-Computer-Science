
public class Test {
	public static void main(String[] args){
		double experimental = 0;
		for(int i = 0; i < 15; i++){
			experimental += (1.0/factorial(i));
			//System.out.println(factorial(i));
		}
		System.out.println(experimental==Math.E);
		System.out.println(experimental);
		System.out.println(Math.E);
	}
	
	public static int factorial(int n){
		if(n == 0)
			return 1;
		int returnVal = 1;
		for(int i = n; i >= 1; i--){
			returnVal *= i;
		}
		return returnVal;
	}
	
	
}
