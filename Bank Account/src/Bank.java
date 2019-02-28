import java.util.Scanner;

public class Bank {

	private BankAccount[] clients = new BankAccount[5];
	private int numAccounts = 0;
	private Scanner input = new Scanner(System.in);
	private boolean exit = false;
	private boolean logout = false;

	public Bank() {
	}

	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.openBank();
	}

	public void openBank() {
		while (!exit) {
			logout = false;
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

	public void login() {
		System.out.print("Enter your name: ");
		input.nextLine();
		String tempName = input.nextLine();
		int index;
		for (index = 0; index < numAccounts; index++) {
			if (clients[index].getName().equalsIgnoreCase(tempName)) {
				break;
			}
		}
		if (index == numAccounts) {
			System.out.println("This account does not exist.");
		} else {
			accountMenu(index);
		}
	}

	public void accountMenu(int index) {
		while (!logout) {
			System.out.println("\nWelcome " + clients[index].getName() + "! Your balance is $"
					+ clients[index].getBalance() + ".");
			System.out.println("Select an option:");
			System.out.println("1. Close Account\n2. Deposit\n3. Withdraw\n4. Logout");
			int selection = input.nextInt();
			if (selection == 1) {
				closeAccount(index);
			} else if (selection == 2) {
				System.out.print("Amount to deposit: ");
				double amount = input.nextDouble();
				clients[index].deposit(amount);
			} else if (selection == 3) {
				System.out.print("Amount to withdraw: ");
				double amount = input.nextDouble();
				clients[index].withdraw(amount);
			} else if (selection == 4) {
				logout = true;
				System.out.println("Logging out.");
			} else {
				System.out.println("Invalid option");
			}
		}
	}

	public void createAccount() {
		if (numAccounts == clients.length) {
			System.out.println("Cannot hold any more clients.");
		} else {
			System.out.print("Enter your name: ");
			input.nextLine();
			String newName = input.nextLine();
			boolean alreadyExists = false;
			for (int i = 0; i < numAccounts; i++) {
				if (clients[i].getName().equalsIgnoreCase(newName)) {
					alreadyExists = true;
				}
			}
			if (alreadyExists) {
				System.out.println("There is already an account with this name.");
			} else {
				clients[numAccounts] = new BankAccount(newName, 0);
				numAccounts++;
				System.out.println("Account created. You may now login.");
			}
		}
	}
	public void closeAccount(int index) {
		numAccounts--;
		logout = true;
		for (index = index; index < clients.length - 1; index++) {
			if (clients[index + 1] != null) {
				clients[index] = new BankAccount(clients[index + 1].getName(), clients[index + 1].getBalance());
				clients[index + 1] = null;
			}
		}
		clients[clients.length - 1] = null;
		System.out.println("Account closed.");
	}

}