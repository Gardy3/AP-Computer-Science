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
			System.out.println("\nWelcome to the bank! Select an option:");
			System.out.println("1. Login\n2. Create Account\n3. Exit");
			int selection = input.nextInt();
			if (selection == 1) {
				login();
			} else if (selection == 2) {
				createAccount();
			} else if (selection == 3) {
				exit = true;
				System.out.println("Goodbye!");
			} else {
				System.out.println("Invalid option.");
			}
		}
	}
	
	private void login(){
		boolean loginMenu = true;
		while(loginMenu){
			System.out.print("Enter your name: ");
			String tempName = input.nextLine();
			int index;
			for (index = 0; index < clients.size(); index++) {
				if (clients.get(index).getName().equalsIgnoreCase(tempName)) {
					break;
				}
			}
			if (index == clients.size()) {
				System.out.println("This account does not exist. Would you like to try again?");
				while(true){
					System.out.print("Enter Y or N: ");
					char selection = input.nextLine().charAt(0);
					if(selection == 'y' || selection == 'Y'){
						break;
					}
					else if(selection == 'n' || selection == 'N'){
						loginMenu = false;
						break;
					}
				}
				
			} 
			else {
				loginMenu = false;
				accountMenu(clients.get(index));
			}
		}
	
	}
	
	public void accountMenu(BankAccount account) {
		login = true;
		while (login) {
			System.out.println("\nWelcome " + account.getName() + "!");
			System.out.println("Select an option:");
			System.out.println("1. Check Balance\n2. Deposit\n3. Withdraw\n4. Close Account\n5. Logout");
			int selection = input.nextInt();
			if(selection == 1){
				
			}
			else if(selection == 2){
				inputDeposit(account);
			}
			else if(selection == 3){
				inputWithdraw(account);
			}
			else if(selection == 4){
				closeAccount(account);
			}
			else if(selection == 5){
				logout();
			}
		}
	}
 
}
