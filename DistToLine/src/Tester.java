import java.util.Scanner;
public class Tester {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter A value for line: ");
		DistToLine.A = input.nextDouble();
		System.out.print("Enter B value for line: ");
		DistToLine.B = input.nextDouble();
		System.out.print("Enter C value for line: ");
		DistToLine.C = input.nextDouble();
		System.out.print("Enter x value for point: ");
		double x = input.nextDouble();
		System.out.print("Enter y value for point: ");
		double y = input.nextDouble();
		
		System.out.println("The distance is " + DistToLine.getDist(x, y));
	}
}
