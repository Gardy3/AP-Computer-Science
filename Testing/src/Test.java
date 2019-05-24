import java.util.ArrayList;

public class Test {
	public static void main(String[] args){
		System.out.println("hello".contains("hi"));
	}
	

	public static String star(String str){
		if(str.length() == 1){
			return str;
		}
		return star(str.substring(0, str.length() - 1)) + "*" + str.substring(str.length()-1);
	}
	
}
