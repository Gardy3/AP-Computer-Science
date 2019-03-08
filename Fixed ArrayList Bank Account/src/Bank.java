
import java.util.*;
public class Bank {
	
	private ArrayList<BankAccount> clients = new ArrayList<>(); //Arraylist to hold BankAccount objects (clients)
	private Scanner input = new Scanner(System.in); //input Scanner
	private boolean open; //The program will run while this is true and the first menu is open
	private boolean login; //Set to true when a user is logged in
	
	public static void main(String[] args){
		Bank bank = new Bank();
		bank.openBank();
	}
	
	//Displays the menu that shows before you log into the bank, giving you the option to login, create account, or exit
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
				exit();
			} else {
				System.out.println("Invalid option.");
			}
		}
	}
	
	//Allows you to login to a prexisting account
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
	
	//After logging in, this menu provides the options to update parts of your personal account, including
	//view balance, deposit, withdraw, close account, and logout
	public void accountMenu(BankAccount account) {
		login = true;
		while (login) {
			clearScreen();
			System.out.println("\nWelcome " + account.getName() + "!");
			System.out.println("Select an option:");
			System.out.println("1. View Balance\n2. Deposit\n3. Withdraw\n4. Close Account\n5. Logout");
			int selection = input.nextInt();
			if(selection == 1){
				viewBalance(account);
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
				logout(account);
			}
			else{
				System.out.println("Invalid option!");
			}
		}
	}
	
	//Displays the balance of the account
	public void viewBalance(BankAccount account){
		System.out.println("Your balance is: " + account.getBalance());
		System.out.println("Press enter to continue.");
		input.nextLine();
	}
	
	//Tells person to enter money to deposit and uses deposit method to do so
	public void inputDeposit(BankAccount account){
		clearScreen();
		System.out.print("Enter amount to deposit: ");
		account.deposit(input.nextDouble());
		input.nextLine();
		System.out.println("Success. Press enter to continue.");
		input.nextLine();
	}
	
	//Person inputs amount to withdraw and withdraw method is used from BankAccount
	public void inputWithdraw(BankAccount account){
		clearScreen();
		System.out.print("Enter amount to withdraw: ");
		account.withdraw(input.nextDouble());
		input.nextLine();
		System.out.println("Success. Press enter to continue.");
		input.nextLine();
	}
	
	//Ensures that the user wants to close their account, and then closes it
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
			System.out.println("Account closed. Press enter to continue.");
			input.nextLine();
		}
	}
	
	//logs user out and then loops back to the first menu
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
			System.out.println("Press enter to continue.");
			input.nextLine();
		}
	}
	
	//Checks to see if there is already account made with that name and then makes account if there isn't one
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
				System.out.println("Account created! Press enter to continue.");
				input.nextLine();
				break;
			}
		}
	}
	
	//Places lots of new lines to clear screen
	public void clearScreen(){
		for(int i = 0; i < 50; i++){
			System.out.println();
		}
	}
	
	//Causes program to close if user says yes
	public void exit(){
		boolean close;
		System.out.println("Are you sure you would like to log out, " + account.getName() + "?");
		while(true){
			System.out.print("Enter Y or N: ");
			char selection = input.nextLine().charAt(0);
			if(selection == 'y' || selection == 'Y'){
				close = true;
				break;
			}
			else if(selection == 'n' || selection == 'N'){
				close = false;
				break;
			}
		}
		if(close){
			System.out.println("Goodbye!");
			open = false;
		}
	}
 
}