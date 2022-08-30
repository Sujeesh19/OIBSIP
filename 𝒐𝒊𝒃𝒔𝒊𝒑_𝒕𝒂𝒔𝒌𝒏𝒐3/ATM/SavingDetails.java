package ATM;

class Saving{
	String userName;
	Saving next;
	
	public Saving(String userName) {
		this.userName = userName;
		next = null;
	}
}

class Save{
	String password;
	String name;
	String accountNumber;
	int balance;
	TransactionHistory head;
	SavingDetails next;
	
	public Save(String password, String name, String accountNumber, int balance, TransactionHistory head) {
		this.password = password;
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.head = head;
		next = null;
	}
}

public class SavingDetails {
	public static void main(String[] args) {

	}
	
}
