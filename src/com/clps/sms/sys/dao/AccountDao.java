/**
 * 
 */
package com.clps.sms.sys.dao;

import java.sql.SQLException;
import java.util.List;

import com.clps.sms.sys.model.Account;


/**
 * @ClassName: AccountDao 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Leng Haoran
 * @date 2017年8月15日 下午2:59:09 
 *  
 */
public interface AccountDao {

	/**
	 * desc:
	 * 		
	 * @return List<Account> 
	 */
	public List<Account> queryAllAccounts()throws Exception;
	/**
	 * desc:
	 * 		query model with like
	 * 
	 * @param acc enc. Account 
	 * @return List<Account>
	 */
	public List<Account> queryAllAccountByCondition(Account acc)throws SQLException;
	/**
	 * 
	 * @param acc_mobile
	 * @return boolean true: acc_mobile unqine false: ....
	 */
	public boolean queryAccountByMobile(String acc_mobile)throws Exception;
	/**
	 * 
	 * @param acc_name
	 * @return boolean true: false:
	 */
	public boolean queryAccountByName(String acc_name)throws Exception;
	/**
	 * 
	 * @param acc
	 * @param acc_id
	 * @return
	 */
	public boolean updateAccountById(Account acc,Integer acc_id)throws Exception;
	/**
	 * desc:
	 * 		
	 * @param acc_id
	 * @return
	 */
	public boolean deleteAccountById(Integer acc_id)throws Exception;
	/**
	 * desc:
	 * 		
	 * @param acc
	 * @return
	 * @throws SQLException
	 */
	public boolean insertAccount(Account acc)throws SQLException;
}
