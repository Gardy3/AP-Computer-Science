
public class BankAccount {
	
	private String name;
	private double balance = 0;
	
	public BankAccount(){
	}
	
	public BankAccount(String name, double balance){
		this.name = name;
		this.balance = balance;
	}
	
	public double deposit(double amt){
		balance += amt;
		return balance;
	}
	
	public double withdraw(double amt){
		balance -= amt;
		return balance;
	}
	
	public String getName(){
		return name;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public String toString(){
		return("Name: " + name + "\nBalance: $" + balance);
	}
	
}
