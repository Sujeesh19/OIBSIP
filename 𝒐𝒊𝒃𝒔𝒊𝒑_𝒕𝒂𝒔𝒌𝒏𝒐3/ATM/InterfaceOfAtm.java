package ATM;

import java.io.*;

public class InterfaceOfAtm {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Account account = new Account();
		System.out.println("1.Register");
		System.out.println("2.Exit");
		System.out.print("Enter Your Option - ");
		int choice = Integer.parseInt(br.readLine());
		
		if(choice == 1) {
			account.register();
			while(true) {
				System.out.println("\n1.Login");
				System.out.println("2.Exit");
				System.out.print("Enter Your Option - ");
				int op = Integer.parseInt(br.readLine());
				if(op == 1) {
					if(account.login()) {
						System.out.println("Welcome "+account.name+" to ATM");
						boolean flag = false;
						while(!flag) {
							System.out.println("\n1.Deposit");
							System.out.println("2.Withdraw");
							System.out.println("3.Transfer Amount");
							System.out.println("4.Transaction History");
							System.out.println("5.Check Balance");
							System.out.println("6.Exit");
							System.out.print("\nEnter Your Option - ");
							int ch = Integer.parseInt(br.readLine());
							switch(ch) {
							case 1:
								account.deposit();
								break;
							case 2:
								account.withDraw();
								break;
							case 3:
								account.transferAmount();
								break;
							case 4:
								account.printTransactionHistory();
								break;
							case 5:
								account.checkBalance();
								break;
							case 6:
								flag = true;
								break;
							}
						}
					}
				}else {
					System.exit(0);
				}
			}
		}
		else {
			System.out.println("\nThank You");
			System.exit(0);
		}

	}

}
