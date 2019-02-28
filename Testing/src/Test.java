import java.util.ArrayList;

public class Test {
	public static void main(String[] args){
		ArrayList x = new ArrayList();
		x.add(2, 3);
		System.out.println(x);
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
