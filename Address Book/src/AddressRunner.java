import java.util.Scanner;
public class AddressRunner {
	
	AddressEntry address1 = new AddressEntry();
	AddressEntry address2 = new AddressEntry();
	AddressEntry address3 = new AddressEntry();
	Scanner input = new Scanner(System.in);
	
	public static void main(String[] args){
		
		AddressRunner run = new AddressRunner();
		
		
		run.menu();
		
	}
	
	public void menu(){
		
		System.out.println("Welcome to your address book. Please select an option:");
		System.out.println("1. Add");
		System.out.println("2. Delete");
		System.out.println("3. View");
		System.out.println("4. Exit");
		
		int selection = input.nextInt();
		if(selection == 1){
			add();
		}
		else if(selection == 2){
			delete();
		}
		else if(selection == 3){
			view();
		}
		else if(selection == 4){
			exit();
		}
		
		
		
	}
	
	public void add(){
		
		if(address1.name.equals("")){
			
		}
		else if(address2.name.equals("")){
			
		}
		else if(address3.name.equals("")){
			
		}
		
	}

}
