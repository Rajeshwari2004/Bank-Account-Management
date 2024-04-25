//BankFrontOffice2.java
import java.util.Scanner;

public class BankFrontOffice2 {

	public static void main(String[] args) {

		Bank2 sbiBank = new Bank2();
		Scanner scn=new Scanner(System.in);
		
		loop:while(true) {
			System.out.println("\nChoose one Option");
			System.out.println("1.OpenAccount");
			System.out.println("2.Account details");
			System.out.println("3.Deposit");
			System.out.println("4.Withdraw");
			System.out.println("5.Balance Enquiry");
			System.out.println("6.Transfer Money");
			System.out.println("7.Display all Accounts");
			System.out.println("8.Exit");
            
			System.out.println("Enter Option:");
			int option =scn.nextInt(); scn.nextLine();
			
			try {
				
				switch(option) {
				
				    case 1:{ //OpenAccount
					    sbiBank.openAccount();
					    break;
				    }
				
				    case 2:{ //Account Details
				    	System.out.println("Enter Account Number:");
				    	long accNum =scn.nextLong(); scn.nextLine();
				    	sbiBank.displayAccount(accNum);
				    	break;
				    }
				    
				    case 3:{ //Deposit
				    	System.out.println("Enter Account Number:");
				    	long accNum =scn.nextLong(); scn.nextLine();
				    	
				    	System.out.println("Enter Deposit Amount:");
				    	double amt =scn.nextDouble(); scn.nextLine();
				    	
				    	sbiBank.deposit(accNum, amt);
				    	break;
				    }
				    
				    case 4:{ //Withdraw
				    	System.out.println("Enter Account Number:");
				    	long accNum =scn.nextLong(); scn.nextLine();
				    	
				    	System.out.println("Enter Withdraw Amount:");
				    	double amt =scn.nextDouble(); scn.nextLine();
				    	
				    	sbiBank.withdraw(accNum, amt);
				    	break;
				    }
				    
				    case 5:{ //Balance Enquiry
				    	System.out.println("Enter Account Number:");
				    	long accNum =scn.nextLong(); scn.nextLine();
				    	
				    	sbiBank.balanceEnquiry(accNum);
				    	break;
				    }
				    
				    case 6:{ //TransferMoney
				    	System.out.println("Enter  Source Account Number:");
				    	long srcAccNum =scn.nextLong(); scn.nextLine();
				    	
				    	System.out.println("Enter Destination Account Number:");
				    	long destAccNum =scn.nextLong(); scn.nextLine();
				    	
				    	System.out.println("Enter Deposit Amount:");
				    	double amt =scn.nextDouble(); scn.nextLine();
				    	
				    	sbiBank.transferMoney(destAccNum, srcAccNum, amt);
				    	break;
				    }
				    
				    case 7:{ //Display all accounts
				    	System.out.println(sbiBank);
				    	break;
				    }
				    
				    case 8:{ //Exit
				    	System.out.println("");
				    	break loop;
				    }
				    
				    default:
				    	System.out.println("Invalid Option");
				}
			}catch(IllegalArgumentException e) {
				System.out.println("Error: "+e.getMessage());
			}
		}
	}
}
