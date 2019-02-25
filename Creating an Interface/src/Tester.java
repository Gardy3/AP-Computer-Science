
public class Tester {
	
	public static void main(String[] args){
		newMath mathObj = new newMath();
		
		System.out.println("mod: " + mathObj.mod(8, 3));
		System.out.println("sqrt: " + mathObj.sqrt(453));
		System.out.println("mult: " + mathObj.multiply(3, 9));
		System.out.println("divide" + mathObj.divide(100, 10));
		System.out.println("quadratic: " + mathObj.quadratic(1, 0, -1)[0] + ", " + mathObj.quadratic(1, 0, -1)[1]);
		System.out.println("quadratic vertex: " + mathObj.quadratic(3, 6, 7)[0] + ", " + mathObj.quadratic(3, 6, 7)[1]);
		System.out.println("rect: " + mathObj.rectArea(5, 6));
		System.out.println("tri: " + mathObj.triArea(4, 5));
	}

}
