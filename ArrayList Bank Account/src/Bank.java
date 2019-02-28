import java.util.*;
public class Bank {
	
	private ArrayList<BankAccount> clients = new ArrayList<>();
	private Scanner input = new Scanner(System.in);
	private boolean open;
	private boolean login;
	
	public static void main(String[] args){
		Bank bank = new Bank();
		bank.openBank();
	}
	
	private void openBank(){
		open = true;
		while(open){
			System.out.println("Welcome to the bank!");
			System.out.println("Enter an option:\n1. Login\n2. Create an Account\n3. Exit");
			int select = input.nextInt();
			if(select == 1){
				//login();
			}
			
		}
	}
 
}
