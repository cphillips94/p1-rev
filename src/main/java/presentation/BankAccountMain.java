package presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import exeception.AccountsNotFoundException;
import exeception.SystemException;
import pojo.BankAccontPojo;

import service.BankAccountService;
import service.BankServiceImpl;


public class BankAccountMain {
	

	public static final Logger LOG = LogManager.getLogger(BankAccountMain.class);
	
	public static void main (String[] args) {
		BankAccountService bankAccountService = new BankServiceImpl();
		Scanner scan = new Scanner(System.in);
		char ch = 'y';
		while(ch == 'y') {
			
			
			//main menu 
			
			System.out.println("*************************************");
			System.out.println("\tBank Account Management System");
			System.out.println("*************************************");
			System.out.println("1. Login as an Employee");
			System.out.println("2. Login as a Customer");
			System.out.println("3. Exit");
			System.out.println("*************************************");
			System.out.println("Please enter menu option : ");
			int option = scan.nextInt();
			scan.nextLine();
			System.out.println("*************************************");
			
			//tree of switches case 1 being employee, 2 customer, 3 to exit and disconnect
			
			switch(option) {
			
			case 1:
				
				//login for emp
				int count=0;
				String login= null;
				String name ="chris";
				String pass= "test";
				Scanner emp= new Scanner (System.in);
				
				
				
				while(login ==null && count <4) {
				System.out.println("Please Login...");
				System.out.println("User Name:");
				String n = emp.nextLine();
				System.out.println("Password:");
				String p = emp.nextLine();

				
				
				 if(n.equals(name) && p.equals(pass)) 
				 {
						System.out.println("Successful Login");
						login="successful";
				 }
				 
				else {

					 System.out.println("The name or password is not correct!");
					 count++;
				}
				}
				
				
				
				char ch1= 'y';
				while(ch1==ch)// && login.equals("successful"))
				{
				System.out.println("*************************************");
				System.out.println("\tEmployee Menu");
				System.out.println("*************************************");
				//add
				System.out.println("4: Add a New account.");
				//list
				System.out.println("5: List all bank accounts.");
				System.out.println("6: Exit");
				int option2= scan.nextInt();
				scan.nextLine();
				
				//second switch 4 5 6 
					switch(option2) 
					{
					case 4:
						BankAccontPojo newBankAccount= new BankAccontPojo();
						System.out.println("Enter Name of the user;");
						newBankAccount.setUserName(scan.nextLine());
						System.out.println("Enter Password for user account:");
						newBankAccount.setUserPassword(scan.nextLine());
						System.out.println("Enter the starting balance:");
						newBankAccount.setBalance(scan.nextDouble());
						
						
						//add user
						BankAccontPojo addedAccount;
						try {
							addedAccount = bankAccountService.addUserAccount(newBankAccount);
							System.out.println("Book Added Successfully!!\nYour new Book ID is " + addedAccount.getUserAccountNumber());
						} catch (SystemException e) {
							LOG.error(e);
							System.out.println(e.getMessage());
						}
						break;
					case 5:
						
						List<BankAccontPojo> allAccounts;
						try {
							allAccounts = bankAccountService.fetchAllUserAccount();
							Iterator<BankAccontPojo> itr = allAccounts.iterator();
							System.out.println("**************************************************************************************");
							System.out.println("ID\tUSERNAME\t\t\t\t\tPASSWORD\t\tBALANCE");
							System.out.println("**************************************************************************************");
							while(itr.hasNext()) {
								BankAccontPojo account = itr.next();
								System.out.println(account.getUserAccountNumber()+"\t"+account.getUserName()+"\t"+account.getUserPassword() +"\t"+account.getBalance());
							}
							System.out.println("**************************************************************************************");
						} catch (SystemException e) {
							LOG.error(e);
							System.out.println(e.getMessage());
						} catch (AccountsNotFoundException e) {
							LOG.error(e);
							System.out.println(e.getMessage());
						}
						
						break;
						
						
					case 6:
						System.out.println("************************************");
						System.out.println("logging out Employee....");
						System.out.println("Do you want to continue (y/n):");
						ch1 = scan.next().charAt(0);
						scan.nextLine();

						//try {
							//bankAccountService.exitApplication();
						//} catch (SystemException e) {
							//LOG.error(e);
							//System.out.println(e.getMessage());
						//}
						//System.exit(0);	
						break;
					}
				
					//break;
				}
			
					
					
			case 2:
				//String user=null;
				//String password=null;
				String check= null;
				
				
				while(check==null)
				{
				System.out.println("*************************************");	
				System.out.println("Hello, Please enter your account number:");
				int num= scan.nextInt();
				System.out.println("Please enter your username:");
				String user = scan.nextLine();
				scan.nextLine();
				System.out.println("Please enter your password:");
				 String password= scan.nextLine();
				 
				 BankAccontPojo userAccount;
				 try {
				 userAccount= bankAccountService.fetchAUserAccount(num);
				 //needs to fixed to compareTo = rs.getString("skill");
				String realUser= userAccount.getUserName();
				String realPass= userAccount.getUserPassword();
				System.out.println(realUser+"   "+realPass);
					 //Connection conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/project0", "postgres", "@caDia;3");
					// Statement stmt=conn.createStatement();
					// ResultSet rs = stmt.executeQuery("SELECT account_password FROM user_accounts WHERE account_number="+num);
					// while(rs.next()) {String compareTo=rs.getString("username");
					 {
				if (realPass.equals(password)) {
					System.out.println("logging successfully!");
					check= "pass";
				}
				else {
				
					System.out.println("Please check log in information.");
				
				}
					 }
				
				char ch3='y';
				while(ch3=='y') 
				{
					
				
				System.out.println("*************************************");
				System.out.println("\tUser Account Menu");
				System.out.println("*************************************");
				System.out.println("7. Veiw Account");
				System.out.println("8. Update Balance");
				System.out.println("9. Exit");
				int option3=scan.nextInt();
				scan.nextLine();
				
				
				switch(option3) { 
				case 7:
					
					System.out.println("***************************************");
					System.out.println("username: "+userAccount.getUserName());
					System.out.println("balance: $"+ userAccount.getBalance());
					System.out.println("***************************************");
					break;
				case 8:
					System.out.println("Please enter the amount you want to withdrawal as a negative like so -10 or if it is a deposit leave postive:");
					Float w =scan.nextFloat();
					try {
					Connection conn2= DriverManager.getConnection("jdbc:postgresql://localhost:5432/project0", "postgres", "@caDia;3");
					Statement stmt2=conn2.createStatement();
					String query4= "UPDATE user_accounts SET balance=balance+"+w+"WHERE account_number="+num;
					int row= stmt2.executeUpdate(query4);
					System.out.println("Money transfered...");
					}
					catch(SQLException e) {
						throw new SystemException();
					}
					
					break;
				case 9:
					System.out.println("************************************");
					System.out.println("logging out User....");
					System.out.println("Do you want to continue (y/n):");
					ch3 = scan.next().charAt(0);
					scan.nextLine();
					/*try {
						bankAccountService.exitApplication();
					} catch (SystemException e) {
						LOG.error(e);
						System.out.println(e.getMessage());
					}
					System.exit(0);*/	
					break;
					}
				}
				
				
				}
				 
				 catch (SystemException e) {
					LOG.error(e);
					System.out.println(e.getMessage());
				}
				break;
				}
				
			case 3:
				System.out.println("System is shuting down do you want to continue (y/n)");
				ch=scan.next().charAt(0);
				scan.nextLine();
				if(ch=='n')
				{
					try {
						bankAccountService.exitApplication();
					} catch (SystemException e) {
						LOG.error(e);
						System.out.println(e.getMessage());
					}
					System.exit(0);	
				}
				break;
				
		}
		}
	}

}			

			
		
	
