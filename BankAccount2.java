//BankAccount2.java
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BankAccount2 {
	// constructor accNum, accName, Balance
	
	private static String bankName;
	private static String branchName;
	private static String ifsc;
	
	private long accNum;
	private String accName;
	private double balance;
	
	static {
//		out.println("\nBank Account class is Loaded");
//		try {Thread.sleep(1000);}
//		catch(InterruptedException e) { }
//
//		out.println("\nSV Memory Allocated With Default Values");
//		try {Thread.sleep(1000);}
//		catch(InterruptedException e) { }
//
//		out.println("\nReading Static variables from file and Initialising them");
//		try {Thread.sleep(1000);}
//		catch(InterruptedException e) { }
//
		try {
			/*Connection to File*/
			BufferedReader fileReader=new BufferedReader(new FileReader("BankDetails2.txt"));
	        
			/*Reading Values From File and Storing in Static Variables*/
			bankName  =fileReader.readLine();
			branchName  =fileReader.readLine();
			ifsc  =fileReader.readLine();
			
//			out.println("\nSV are initialized With File Values");
//			try {Thread.sleep(1000);}
//			catch(InterruptedException e) { }
			
		}catch(FileNotFoundException e) {
			out.println("Error:BankDetails2.txt file is not Found");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {Thread.sleep(1000);}
		catch(InterruptedException e) { }
		
	}//Static Block closed
	
	public BankAccount2(long accNum,String accName,double balance){
		
		out.println("\nNSV Memory Allocated With Default Values");
		try {Thread.sleep(1000);}
		catch(InterruptedException e) { }
		
		out.println("\nNSV are  being initialized With Given Values\n");
		try {Thread.sleep(1000);}
		catch(InterruptedException e) { }
		
		this.accNum=accNum;
		this.accName=accName;
		this.balance=balance;
		
		out.println("\nNSV are  initialized With Given Object Values\n");
		try {Thread.sleep(1000);}
		catch(InterruptedException e) { }
		
	}//Constructor closed
	
	public static void setBankName(String bankName) {
		BankAccount2.bankName=bankName;
	}
	
	public static String getBankName() {
		return bankName;
	}
	
	public static void setBranchName(String branchName) {
		BankAccount2.branchName=branchName;
	}
	
	public static String getBranchName() {
		return branchName;
	}
	
	public static void setIfsc(String ifsc) {
		BankAccount2.ifsc=ifsc;
	}
	
	public static String getIfsc() {
		return ifsc;
	}
	
	public long getAccNum() {
		return accNum;
	}
	
	public void SetAccName(String accName) {
		this.accName=accName;
	}
	
	public String getAccName() {
		return accName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amt) {
		this.balance=this.balance+amt;
	}
	
	public void withdraw(double amt) {
		this.balance=this.balance-amt;
	}
	
	public void currentBalance() {
		out.println(balance);
	}
	
	public String toString() {
		return ("\n bankName:\t"+bankName)+"\n"+
				("\n branchName:\t"+branchName)+"\n"+
				("\n ifsc:\t"+ifsc)+"\n"+
				("\n accNum:\t"+accNum)+"\n"+
				("\n accName:\t"+accName)+"\n"+
				("\n balance:\t"+balance);
	}
}
//Instance Methods are the group of codes that performs a particular task
//