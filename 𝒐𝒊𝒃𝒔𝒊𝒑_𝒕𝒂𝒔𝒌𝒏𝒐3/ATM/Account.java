package ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TransactionHistory{
	String transaction;
	TransactionHistory next;
	
	public TransactionHistory(String transaction) {
		this.transaction = transaction;
		next = null;
	}
	
}

class Account{
	String name;
	String userName;
	String password;
	String accountNo;
	int balance = 10000;
	static Saving root=null;
	static TransactionHistory head = null;
	
	public void insertTransaction(String transaction) {
		if(head == null) {
			head = new TransactionHistory(transaction);
			return;
		}
		TransactionHistory curr = head;
		while(curr.next != null) {
			curr = curr.next;
		}
		curr.next = new TransactionHistory(transaction);
	}
	
	
	public void register() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nEnter Your Name: ");
		this.name = br.readLine();
		if(root == null) {
			root = new Saving(name);
		}else {
			Saving curr = root;
			while(curr.next != null) {
				curr =  curr.next;
			}
			curr.next = new Saving(userName);
		}
		
		System.out.print("\nEnter Your UserName: ");
		this.userName = br.readLine();
		
		System.out.print("\nEnter Your Password: ");
		this.password = br.readLine();
		
		System.out.print("\nEnter Your Account Number: ");
		this.accountNo = br.readLine();
		
		
		
		System.out.print("\nRegistration completed successfully");
	}
	
	public boolean login() throws IOException{
		boolean flag = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(!flag) {
			System.out.print("\nEnter Your UserName: ");
			String UserName = br.readLine();
			
			if(UserName.equals(userName)) {
				while(!flag) {
					System.out.print("\nEnter Your Password: ");
					String Password = br.readLine();
					if(Password.equals(password)) {
						System.out.print("\nLogged In");
						flag = true;
					}else {
						System.out.print("\nPlease Enter Correct Password");
					}
				}
			}else {
				System.out.println("\nUserName Not Found");
			}
		}
		return flag;
	}
	
	public void deposit() throws IOException{
		System.out.print("\nEnter the amount to deposit less than Rs. 1 Lakh: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int amount = Integer.parseInt(br.readLine());
		
		if(amount <= 100000) {
			balance += amount;
			System.out.println("\nSuccessfully Deposited");
			String amountDeposit = amount + " Rs. Deposited";
			insertTransaction(amountDeposit);
		}
	}
	
	public void withDraw() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nEnter the amount to withdraw: ");
		int amount = Integer.parseInt(br.readLine());
		
		if(balance >= amount) {
			balance -= amount;
			System.out.println("\nWithdrawal Completed Successfully");
			String amountWithDraw = amount+" Rs. Withdrawed";
			insertTransaction(amountWithDraw);
		}else {
			System.out.println("Insufficient Balance");
		}
	}
	
	public void transferAmount() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nEnter the Account Number: ");
		String accountNumber = br.readLine();
		System.out.print("\nEnter the amount to transfer less than 50 thousand: ");
		int amount = Integer.parseInt(br.readLine());
		
		if(balance >= amount) {
			if(amount <= 50000) {
				balance -= amount;
				System.out.println("\nAmount Transfered Successfully");
				String transfer ="Rs."+ amount + " Transfered to Account Number " + accountNumber;
				insertTransaction(transfer);
			}else {
				System.out.println("Sorry we cannot tranfer the amount");
			}
		}else {
			System.out.println("\nInsufficient Balance");
		}
	}
	
	public void checkBalance() {
		System.out.println("\nRs."+balance+" is your current balance");
	}
	
	public void printTransactionHistory() {
		System.out.println();
		TransactionHistory curr = head;
		if(head == null) {
			System.out.println("No Transaction occured");
		}else {
			while(curr != null) {
				System.out.println(curr.transaction);
				curr = curr.next;
			}
		}
	}
}

