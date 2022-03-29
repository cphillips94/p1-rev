package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import exeception.AccountsNotFoundException;
import exeception.SystemException;
import pojo.BankAccontPojo;


public class BankAccountJdbcDaoImpl implements BankAccontDao {
	
	public static final Logger LOG = LogManager.getLogger(BankAccountJdbcDaoImpl.class);
	@Override
	public List<BankAccontPojo> fetchAllUserAccount() throws SystemException, AccountsNotFoundException{
		LOG.info("Entered fetchAllUserAccount() in DAO");
		
		List<BankAccontPojo> allAccounts= new ArrayList<BankAccontPojo>();
		Connection conn= DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query="Select * FROM user_accounts";
			ResultSet rs= stmt.executeQuery(query);
			//copy each record
			while(rs.next()) {
				BankAccontPojo bankAccontPojo = new BankAccontPojo(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getDouble(4));
				allAccounts.add(bankAccontPojo);
			}
			
		}
		catch(SQLException e){
			throw new SystemException();
		}
		if(allAccounts.isEmpty()) {
			throw new AccountsNotFoundException();
		}
		LOG.info("Exited fetchAllUser() in DAO");
		return allAccounts;
	}
	@Override
	public BankAccontPojo addUserAccount(BankAccontPojo bankAccontPojo)throws SystemException {
		LOG.info("Entered addUserAccount() in DAO");
		Connection conn = DBUtil.obtainConnection();
		try {
			Statement stmt = conn.createStatement();
			
			String query2 = "INSERT INTO user_accounts( account_name, account_password, balance) VALUES ('"+bankAccontPojo.getUserName()+"','"+bankAccontPojo.getUserPassword()+"','"+bankAccontPojo.getBalance()+"') RETURNING account_number";
		ResultSet rs= stmt.executeQuery(query2);
		if(rs.next()) {
			bankAccontPojo.setUserAccountNumber(rs.getInt(1));
		}
		}
		catch (SQLException e) {
			throw new SystemException();
		}
		LOG.info("Exited addUserAccount() in DAO");
		return bankAccontPojo;
	}
	@Override
	public BankAccontPojo updateUserAccount(BankAccontPojo bankAccontPojo) throws SystemException {
		LOG.info("Entered updateUserAccount() in DAO");
		Connection conn =DBUtil.obtainConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "UPDATE user_accounts SET balance ="+ bankAccontPojo.getBalance()+"WHERE account_number="+bankAccontPojo.getUserAccountNumber();
			int row = stmt.executeUpdate(query);
		}
		catch(SQLException e) {
			throw new SystemException();
			
		}
		LOG.info("Exited updateUserAccount() in DAO");
		return bankAccontPojo;
	}
	@Override
	public BankAccontPojo deleteUserAccount(int userAccountNumber) throws SystemException {
		LOG.info("Entered deleteUserAccount() in DAO");
		BankAccontPojo bankAccontPojo = null;
		Connection conn = DBUtil.obtainConnection();
		try {
			Statement stmt = conn.createStatement();
			bankAccontPojo = fetchAUserAccount(userAccountNumber);
			String query = "DELETE FROM user_accounts WHERE account_number="+userAccountNumber;
			int rows = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new SystemException();
		}
		LOG.info("Exited deleteUserAccount() in DAO");
		return bankAccontPojo;
	}
	@Override
	public BankAccontPojo fetchAUserAccount(int userAccountNumber) throws SystemException {
		LOG.info("Entered fetchABook() in DAO");
		BankAccontPojo bankAccontPojo = null;
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM user_accounts WHERE account_number="+userAccountNumber;
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				bankAccontPojo = new BankAccontPojo(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getDouble(4));
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		LOG.info("Exited fetchAUserAccount() in DAO");
		return bankAccontPojo;
	}
	public BankAccontPojo fetchAEmployeeAccount(int employeeAccountNumber) {
		
		return null;
	}

}
