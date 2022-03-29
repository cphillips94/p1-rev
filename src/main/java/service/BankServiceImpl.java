package service;

import java.util.List;
import dao.BankAccontDao;
import dao.BankAccountJdbcDaoImpl;


import exeception.AccountsNotFoundException;
import exeception.SystemException;
import pojo.BankAccontPojo;

public class BankServiceImpl implements BankAccountService {
	BankAccontDao bankAccountDao;
	
	public BankServiceImpl() {
		bankAccountDao= new BankAccountJdbcDaoImpl();
	}
	@Override
	public List<BankAccontPojo> fetchAllUserAccount() throws SystemException, AccountsNotFoundException {
		// TODO Auto-generated method stub
		return bankAccountDao.fetchAllUserAccount();
	}
	@Override
	public BankAccontPojo addUserAccount(BankAccontPojo bankAccontPojo) throws SystemException {
		// TODO Auto-generated method stub
		return bankAccountDao.addUserAccount(bankAccontPojo);
	}
	@Override
	public BankAccontPojo updateUserAccount(BankAccontPojo bankAccontPojo) throws SystemException {
		// TODO Auto-generated method stub
		return bankAccountDao.updateUserAccount(bankAccontPojo);
	}
	@Override
	public BankAccontPojo deleteUserAccount(int userAccountNumber) throws SystemException {
		// TODO Auto-generated method stub
		return bankAccountDao.deleteUserAccount(userAccountNumber);
	}
	@Override
	public BankAccontPojo fetchAUserAccount(int userAccountNumber) throws SystemException {
		// TODO Auto-generated method stub
		return bankAccountDao.fetchAUserAccount(userAccountNumber);
	}
	@Override
	public BankAccontPojo fetchAEmployeeAccount(int employeeAccountNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void exitApplication() throws SystemException {
		bankAccountDao.exitApplication();
	}

}
