/**
 * 
 */
package com.clps.sms.sys.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.clps.sms.sys.dao.AccountDao;
import com.clps.sms.sys.model.Account;
import com.clps.sms.utils.db.DBConnection;

/**
 * @ClassName: AccountDaoImpl 
 * @Description: 账户数据库操作类
 * @author Leng Haoran
 * @date 2017年8月15日 下午2:58:58 
 *  
 */
public class AccountDaoImpl  implements AccountDao{
	
	private static Logger logger = Logger.getLogger(AccountDaoImpl.class);
	
	private static final String SELECTALLACCOUNTS = "SELECT ACC_ID,ACC_NAME,"
			+ "ACC_PASSWORD,ACC_EMAIL,"
			+ "ACC_MOBILE,ACC_DESC,"
			+ "ACC_CREATED_DATE,ACC_CREATED_NAME,"
			+ "ACC_UPDATED_DATE,ACC_UPDATED_NAME,"
			+ "ACC_ROLE_ID FROM ACCOUNT WHERE ACC_STATUS =1";                                                 //查询所有账户
	private static final String DELETEACCOUNT="UPDATE ACCOUNT SET ACC_STATUS=0 "
			+ "WHERE ACC_ID=?";                                                                                                            //删除账户
	private static final String INSERTACCOUNT="INSERT TNTO ACCOUNT(ACC_NAME,ACC_PASSWORD,"
			+ "ACC_EMAIL,ACC_MOBILE,"
			+ "ACC_DESC,ACC_CREATED_DATE,"
			+ "ACC_CREATED_NAME,"
			+ "ACC_ROLE_ID) VALUES(?,?,?,?,?,?,?,?)  WHERE  ACC_ID=?";                                                      //添加账户
	private static final String SELECTMOBILE="SELECT ACC_MOBILE FROM  ACCOUNT WHERE ACC_MOBILE=?";   //查询手机号
	
	private static final String SELECTNAME="SELECT ACC_NAME FROM  ACCOUNT WHERE ACC_NAME=?";           //查询用户名
	
	private ResultSet rs = null;
	private Account account = null;
	private List<Account> listAccount =null;
	private boolean flag = false;

	
	public AccountDaoImpl(){
		
		this.listAccount = new ArrayList<>();
		
	}
	
	
	@Override
	public List<Account> queryAllAccounts() throws SQLException {
		DBConnection.getConnection();
		rs=DBConnection.execQuery(SELECTALLACCOUNTS, null);
		while(rs.next()){
			this.account  = new Account();
		    account.setAcc_id(rs.getInt("ACC_ID"));
			account.setAcc_name(rs.getString("ACC_NAME"));
			account.setAcc_password(rs.getString("ACC_PASSWORD"));
			account.setAcc_mobile(rs.getString("ACC_MOBILE"));
			account.setAcc_email(rs.getString("ACC_EMAIL"));
			account.setAcc_dec(rs.getString("ACC_DESC"));
			account.setAcc_created_date(rs.getString("ACC_CREATED_DATE"));
			account.setAcc_created_name(rs.getString("ACC_CREATED_NAME"));
			account.setAcc_update_date(rs.getString("ACC_UPDATED_DATE"));
			account.setAcc_update_name(rs.getString("ACC_UPDATED_NAME"));
			account.setAcc_role_id(rs.getInt("ACC_ROLE_ID"));
			listAccount.add(account);
		}
		DBConnection.Connclose();
		logger.info("excute queryAllAccounts");
		return listAccount;
	}


	/* (non-Javadoc)
	 * @see com.clps.sms.sys.dao.AccountDao#queryAllAccountByCondition(com.clps.sms.sys.model.Account)
	 */
	@Override
	public List<Account> queryAllAccountByCondition(Account acc) {
		
		return null;
	}


	/* (non-Javadoc)
	 * @see com.clps.sms.sys.dao.AccountDao#queryAccountByMobile(java.lang.String)
	 */
	@Override
	public boolean queryAccountByMobile(String acc_mobile) {
		Object[] objects={acc_mobile};
		rs=DBConnection.execQuery(SELECTMOBILE, objects);
		if(rs!=null){
			flag=true;
		}
		logger.info("excute queryAccountByMobile");
		return flag;
	}


	/* (non-Javadoc)
	 * @see com.clps.sms.sys.dao.AccountDao#queryAccountByName(java.lang.String)
	 */
	@Override
	public boolean queryAccountByName(String acc_name) {
		Object[] objects={acc_name};
		rs=DBConnection.execQuery(SELECTNAME, objects);
		if(rs!=null){
			flag=true;
		}
		logger.info("excute queryAccountByName");
		return false;
	}


	/* (non-Javadoc)
	 * @see com.clps.sms.sys.dao.AccountDao#updateAccountById(com.clps.sms.sys.model.Account, java.lang.Integer)
	 */
	@Override
	public boolean updateAccountById(Account acc, Integer acc_id) {
		String sql="UPDATE ACCOUNT SET                     WHERE　ACC_ID=?";
		Object[] objects={acc_id};
		flag=DBConnection.execUpdate(sql, objects);
		return flag;
	}


	/* (non-Javadoc)
	 * @see com.clps.sms.sys.dao.AccountDao#deleteAccountById(java.lang.Integer)
	 */
	@Override
	public boolean deleteAccountById(Integer acc_id) {
		Object[] objects={acc_id};
		flag=DBConnection.execUpdate(DELETEACCOUNT, objects);
		logger.info("excute deleteAccountById");
		return flag;
	}


	/* (non-Javadoc)
	 *
	 * <p>Title: insertAccount</p> 
	 * <p>Description: </p> 
	 * @param acc
	 * @return
	 * @throws SQLException 
	 * @see com.clps.sms.dao.AccountDao#insertAccount(com.clps.sms.model.Account) 
	 * since v1.0
	 */
	@Override
	public boolean insertAccount(Account acc) throws SQLException {
		Object[] objects={acc.getAcc_name(),acc.getAcc_password(),acc.getAcc_email(),
				acc.getAcc_mobile(),acc.getAcc_dec(),acc.getAcc_created_date(),
				acc.getAcc_created_name(),acc.getAcc_role_id(),acc.getAcc_id()};
		flag=DBConnection.execUpdate(INSERTACCOUNT, objects);
		logger.info("excute insertAccount");
		return flag;
	}
	

}
