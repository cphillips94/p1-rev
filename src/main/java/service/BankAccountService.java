package service;

import java.util.List;

import exeception.AccountsNotFoundException;
import exeception.SystemException;
import pojo.BankAccontPojo;

public interface BankAccountService {
	
	
	
	//read---gather all the user accounts to a list
	 List<BankAccontPojo> fetchAllUserAccount() throws SystemException, AccountsNotFoundException;
	// create a new user account
	BankAccontPojo addUserAccount(BankAccontPojo bankAccontPojo) throws SystemException;
	//update
	BankAccontPojo updateUserAccount(BankAccontPojo bankAccontPojo) throws SystemException;
	//Delete
	BankAccontPojo deleteUserAccount(int userAccountNumber) throws SystemException;
	//read- a single user account
	 BankAccontPojo fetchAUserAccount(int userAccountNumber) throws SystemException;
	//read employee account
	BankAccontPojo fetchAEmployeeAccount (int employeeAccountNumber);
	
	 void exitApplication()throws SystemException ;
		// TODO Auto-generated method stub
		
	}
	

