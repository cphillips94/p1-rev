package pojo;

public class BankAccontPojo {

	
	private double balance;
	private String employeeName;
	private String employeePassword;
	private String userName;
	private String userPassword;
	private int userAccontNumber;
	
	public BankAccontPojo() {
		super();
	}
	//public  BankAccontPojo (double balance, String employeeName, String employeePassword, String userName, String userPassword, int userAccontNumber)
	public BankAccontPojo (int userAccontNumber, String userName, String userPassword, double balance)
	{
		super();
		this.balance= balance;
		this.employeeName = employeeName;
		this.employeePassword= employeePassword;
		this.userName= userName;
		this.userPassword= userPassword;
		this.userAccontNumber= userAccontNumber;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserAccountNumber() {
		return userAccontNumber;
	}
	public void setUserAccountNumber(int userAccountNumber) {
		this.userAccontNumber = userAccountNumber;
	}
	
	
}
