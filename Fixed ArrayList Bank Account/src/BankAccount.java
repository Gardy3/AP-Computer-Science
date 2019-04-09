
public class BankAccount {
	
	private String name; //name of client
	private double balance = 0; //balance of client
	
	//default
	public BankAccount(){
	}
	
	//constructor with both name and balance
	public BankAccount(String name, double balance){
		this.name = name;
		this.balance = balance;
	}
	
	//adds money to balance
	public double deposit(double amt){
		balance += amt;
		return balance;
	}
	
	//subtracts money from balance
	public double withdraw(double amt){
		balance -= amt;
		return balance;
	}
	
	//returns private name
	public String getName(){
		return name;
	}
	
	//returns private balance
	public double getBalance(){
		return balance;
	}
	
	//Displays both instance variables in a nice manner
	public String toString(){
		return("Name: " + name + "\nBalance: $" + balance);
	}
	
}