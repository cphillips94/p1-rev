package dao;

import java.util.List;
import java.util.ArrayList;


import pojo.BankAccontPojo;

public class BankDaoImpl implements BankAccontDao{
	
	List<BankAccontPojo> allAccounts;
	
	@Override
	public List<BankAccontPojo> fetchAllUserAccount() {
		return allAccounts;
	}
	@Override
	public BankAccontPojo addUserAccount(BankAccontPojo bankAccontPojo) {
		int newAccountId = allAccounts.get(allAccounts.size()-1).getUserAccountNumber()+1;
		
		bankAccontPojo.setUserAccountNumber(newAccountId);
		allAccounts.add(bankAccontPojo);
		return bankAccontPojo;
	}
@Override
	public BankAccontPojo updateUserAccount(BankAccontPojo bankAccontPojo) {
		for(int i=0; i<allAccounts.size(); i++) {
			if(allAccounts.get(i).getUserAccountNumber() == bankAccontPojo.getUserAccountNumber()) {
				allAccounts.set(i, bankAccontPojo);
			}
		}
		return bankAccontPojo;
	}
@Override
	public BankAccontPojo deleteUserAccount(int userAccountNumber) {
		BankAccontPojo returnBankAccontPojo= null;
		for(int i = 0; i<allAccounts.size(); i++) {
			if (allAccounts.get(i).getUserAccountNumber()== userAccountNumber) {
				allAccounts.remove(i);
			}
		}
		return returnBankAccontPojo;
	}
@Override
	public BankAccontPojo fetchAUserAccount(int userAccountNumber) {
		BankAccontPojo returnBankAccontPojo =null;
		List<BankAccontPojo> allReturnAccount = new ArrayList<BankAccontPojo>(allAccounts);
		if(allReturnAccount.size() ==1) {
			returnBankAccontPojo = allReturnAccount.get(0);
		}
		return returnBankAccontPojo;
	}
@Override
	public BankAccontPojo fetchAEmployeeAccount(int employeeAccountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}


