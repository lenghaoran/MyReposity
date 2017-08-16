/**
 * 
 */
package com.clps.sms.sys.factory;

import com.clps.sms.sys.dao.AccountDao;
import com.clps.sms.sys.dao.MenuDao;
import com.clps.sms.sys.dao.RoleDao;
import com.clps.sms.sys.dao.impl.AccountDaoImpl;
import com.clps.sms.sys.dao.impl.MenuDaoImpl;
import com.clps.sms.sys.dao.impl.RoleDaoImpl;


/**
 * @ClassName: SysFactory 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Leng Haoran
 * @date 2017年8月15日 下午11:58:34 
 *  
 */
public class SysFactory {

	/**
	 * desc:
	 * 		
	 * 
	 * @return AccountDao
	 */
	public static AccountDao getAccountInstance(){
		return new AccountDaoImpl();
	}
	/**
	 * 
	 * @return
	 */
	public static RoleDao getRoleInstance(){
		return new RoleDaoImpl();
	}
	/**
	 * 
	 * @return
	 */
	public static MenuDao getMenuInstance(){
		return new MenuDaoImpl();
	}
	
}
