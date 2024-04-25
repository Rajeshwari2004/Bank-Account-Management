//Bank2.java
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Bank2 {
	//attributes acc, size, scanner, ang
	private BankAccount2[] accounts;
	private int size;
	
	private Scanner scanner;
	private AtomicLong accNumGenerator;

	//constructor
	public Bank2() {
		accounts 	=new BankAccount2[10];
		size		=0;
		scanner	=new Scanner(System.in);
	
	try {
		BufferedReader accNumReader= new BufferedReader(new FileReader("accNumSeq.txt"));
		long accNumSeq	=Long.parseLong(accNumReader.readLine());
		accNumGenerator = new AtomicLong(accNumSeq);
		
	}catch(FileNotFoundException e) {
		out.println("Error:BankDetails2.txt file is not Found");
	}catch(IOException e) {
		e.printStackTrace();		
	}
	
	}//Bank() Close
	
	private void pause() {
		try {Thread.sleep(2000);}
		catch(InterruptedException e) { }
	}
	
	public void openAccount() {
		
		long accNum=accNumGenerator.incrementAndGet();

		scanner.nextLine();
		System.out.println("Enter Account Holder Name:");
		String accName=scanner.nextLine();
		
		System.out.println("Enter Balance:");
		double balance= scanner.nextDouble();
		
		System.out.println("Bank Account Object Creation Started...");
		pause();
		
		BankAccount2 account=new BankAccount2(accNum,accName,balance);
		System.out.println("BankAccount Object is Created");
		pause();
		
		accounts[size++]=account;
		System.out.println("BankAccount Object is Stored in Bank");
		pause();
		
		//Saving account number in file
		try {
			FileWriter fw=new FileWriter("accNumSeq.txt");
			fw.write(""+accNum);
                        fw.flush();
		}catch(FileNotFoundException e) {
			System.out.println("accNumSeq.txt file is not found");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}//OpenAccount() method Close
	
	private BankAccount2 getAccount(long accNum) throws IllegalArgumentException{
		if(accNum <= 0)
			throw new IllegalArgumentException("Account Number cannot be -VE and ZERO");
		
		System.out.println("Searching for given Account Number Object");
		pause();
		
		//Linear Search Algorithm
		for(int i=0;i<size;i++) {//Loop for Finding BankAccount Object for the given accNum
			BankAccount2 account=accounts[i];
			
			if(account.getAccNum()==accNum)
				return account;
		}	
		return null;
	}
	
	private boolean amountZeroOrNegative(double amt) {
		return amt<=0 ? true : false;
	}
	
	private boolean amountGreaterThanBalance(BankAccount2 account,double amt) {
		return amt>account.getBalance()?true:false;
	}
	
	public void deposit(long accNum,double amt) throws IllegalArgumentException{
		System.out.println("Deposit Operation Start");
		pause();
		
		//Retrieving the BankAccount Object of the given Account Number
		BankAccount2 account=getAccount(accNum);
		
		//Checking account and balance valid or not
		if(account==null)
			throw new IllegalArgumentException("Account is not Found with the given Details");
		
		if(amountZeroOrNegative(amt))
			throw new IllegalArgumentException("Amount Cannot be -VE and ZERO");
			
		//Depositing given Amount in the given amount
		account.deposit(amt);
		System.out.println("Cash RS "+amt+" is credited to your account");
		
		pause();
	}//Deposit Close
	
	public void withdraw(long accNum,double amt)throws IllegalArgumentException{
		
		System.out.println("Withdraw Operation Start");
		pause();
		
		//Retrieving the BankAccount object of the given account Number
		BankAccount2 account=getAccount(accNum);
		
		//Checking Account and Balance Valid or Not
		if(account==null)
			throw new IllegalArgumentException("Account is not found with the given Details");
		
		if(amountZeroOrNegative(amt))
			throw new IllegalArgumentException("Amount Cannot be -VE and ZERO");
			
		if(amountGreaterThanBalance(account,amt))
			throw new IllegalArgumentException("Insufficient Funds");
		
		account.withdraw(amt);
		System.out.println("Cash RS "+amt+" is debited from your account");
		
		pause();
	}//Withdraw Close
	
	public void balanceEnquiry(long accNum)throws IllegalArgumentException{
		
		System.out.println("Balance Enquiry Operation Started");
		
		//Retrieving the BankAccount object of the given account Number
			BankAccount2 account=getAccount(accNum);
				
		//Checking Account and Balance Valid or Not
		if(account==null)
			throw new IllegalArgumentException("Account is not found with the given Details");
		
		System.out.println("Current Balance:");
		account.currentBalance();
		
		pause();
	}//BalanceEnquiry Close
	
	public void transferMoney(long sourceAccNum,long destinationAccNum,double amt)  throws IllegalArgumentException{
		
		System.out.println("Transfer Money Operation Start");
		pause();
		
		//withdraw(sourceAccNum,amt);
		//deposit(destinationAccNum,amt);
		withdraw(destinationAccNum,amt);
		deposit(sourceAccNum,amt);
		
		System.out.println("Transfer Money Operation End");
		pause();
	}//TransferMoney() Close
	
	public void update(long accNum) throws IllegalArgumentException{
		
	}//Update Close
	
	public void closeAccount(long accNum)throws IllegalArgumentException{
	
		System.out.println("Close Account Operation start");
		pause();
		
		//Linear Search Algorithm
		for(int i=0;i<size;i++) {//Loop for Finding BankAccount Object for the given accNum
			BankAccount2 account=accounts[i];
			
			if(account.getAccNum()==accNum) {
				
				for(int j=i;j<size-1;j++) {  //Removing Current Location Object
					accounts[j]=accounts[j+1]; //By Moving Next Object One Location LEFT
				}
				
				accounts[size-1]=null; //Removing Reference From Last Location
				size--;  //Decreasing Size By One
				
				System.out.println("Account is Deleted");
				pause();
				return;
			}
		}//for loop Closed
		
		throw new IllegalArgumentException("Account is not found with given details");
		
	}//CloseAccount() Closed
	
	public void displayAccount(long accNum)throws IllegalArgumentException{
		
		System.out.println("\nDisplay Account Operation Start");
		pause();
		
		//Retrieving the BankAccount Object of the given Account Number
		BankAccount2 account=getAccount(accNum);
				
		//Checking account and balance valid or not
		if(account==null)
			throw new IllegalArgumentException("Account is not Found with the given Details");
		
		System.out.println("Account Details");
		System.out.println(account);
				
	}//DisplayAccount close
	
	public String toString() {
		 StringBuilder accountsBuilder=new StringBuilder();
		 
		 if(size==0)
		    return "No Accounts Found";
		
		for(int i=0;i<size;i++) {
			accountsBuilder.append("\nAccounts "+(i+1)+" details: ");
			accountsBuilder.append(accounts[i]+"\n");
			
		}
		 return accountsBuilder.toString();
	}
	
}
