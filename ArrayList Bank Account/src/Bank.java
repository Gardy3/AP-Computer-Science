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
			clearScreen();
			System.out.println("\nWelcome to the bank! Select an option:");
			System.out.println("1. Login\n2. Create Account\n3. Exit");
			int selection = input.nextInt();
			if (selection == 1) {
				login();
			} else if (selection == 2) {
				createAccount();
			} else if (selection == 3) {
				open = false;
				System.out.println("Goodbye!");
			} else {
				System.out.println("Invalid option.");
			}
		}
	}
	
	private void login(){
		boolean loginMenu = true;
		input.nextLine();
		clearScreen();
		System.out.println("LOGIN MENU");
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
			clearScreen();
			System.out.println("\nWelcome " + account.getName() + "!");
			System.out.println("Your balance is $" + account.getBalance());
			System.out.println("Select an option:");
			System.out.println("1. Deposit\n2. Withdraw\n3. Close Account\n4. Logout");
			int selection = input.nextInt();
			if(selection == 1){
				inputDeposit(account);
			}
			else if(selection == 2){
				inputWithdraw(account);
			}
			else if(selection == 3){
				closeAccount(account);
			}
			else if(selection == 4){
				logout(account);
			}
			else{
				System.out.println("Invalid option!");
			}
		}
	}
	
	public void inputDeposit(BankAccount account){
		clearScreen();
		System.out.print("Enter amount to deposit: ");
		account.deposit(input.nextDouble());
	}
	
	public void inputWithdraw(BankAccount account){
		clearScreen();
		System.out.print("Enter amount to withdraw: ");
		account.withdraw(input.nextDouble());
	}
	
	public void closeAccount(BankAccount account){
		boolean delete;
		input.nextLine();
		System.out.println("Are you sure you would like to close your account, " + account.getName() + "?");
		while(true){
			System.out.print("Enter Y or N: ");
			char selection = input.nextLine().charAt(0);
			if(selection == 'y' || selection == 'Y'){
				delete = true;
				break;
			}
			else if(selection == 'n' || selection == 'N'){
				delete = false;
				break;
			}
		}
		if(delete){
			clients.remove(account);
			login = false;
		}
	}
	
	public void logout(BankAccount account){
		clearScreen();
		boolean logout;
		System.out.println("Are you sure you would like to log out, " + account.getName() + "?");
		while(true){
			System.out.print("Enter Y or N: ");
			char selection = input.nextLine().charAt(0);
			if(selection == 'y' || selection == 'Y'){
				logout = true;
				break;
			}
			else if(selection == 'n' || selection == 'N'){
				logout = false;
				break;
			}
		}
		if(logout){
			System.out.println("Successfully logged out. See you soon, " + account.getName() + "!");
			login = false;
			clients.remove(account);
		}
	}
	
	public void createAccount(){
		clearScreen();
		System.out.println("CREATE ACCOUNT MENU");
		input.nextLine();
		while(true){
			System.out.print("Enter your name: ");
			String newName = input.nextLine();
			boolean alreadyExists = false;
			for (int i = 0; i < clients.size(); i++) {
				if (clients.get(i).getName().equalsIgnoreCase(newName)) {
					alreadyExists = true;
				}
			}
			if (alreadyExists) {
				System.out.println("There is already an account with this name. Please try again with another name.");
			}
			else {
				clients.add(new BankAccount(newName, 0));
				System.out.println("Account created!");
				break;
			}
		}
		
	}
	
	public void clearScreen(){
		for(int i = 0; i < 50; i++){
			System.out.println();
		}
	}
 
}
