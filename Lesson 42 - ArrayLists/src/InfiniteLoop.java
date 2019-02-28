import java.util.ArrayList;
import java.util.Scanner;

public class InfiniteLoop {

	public static void main(String[] args){
		ArrayList<String> userStrings = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.print("enter something: ");
			userStrings.add(input.nextLine());
		}
	}
}
