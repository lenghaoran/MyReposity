/**
 * @Title: TestConn.java 
 * @Package com.clps.sms.sys.test 
 * @Description: TODO(��һ�仰�������ļ���ʲô) 
 * @author Leng Haoran   
 * @date 2017��8��16�� ����8:23:56 
 * @version V1.0  
 */
package com.clps.sms.sys.test;

import java.util.List;

import org.junit.Test;

import com.clps.sms.sys.dao.AccountDao;
import com.clps.sms.sys.dao.impl.AccountDaoImpl;
import com.clps.sms.sys.model.Account;

/**
 * @ClassName: TestConn 
 * @Description: TODO(������һ�仰��������������) 
 * @author Leng Haoran
 * @date 2017��8��16�� ����8:23:56 
 *  
 */
public class TestConn {
	@Test
	public void testConn(){
	   AccountDao accountdao=new AccountDaoImpl();
	   List<Account> acclist =null;
	try {
		acclist = accountdao.queryAllAccounts();
	} catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println(acclist);
	
	}
}
