/**
 * 
 */
package com.clps.sms.sys.dao;

import java.util.List;

import com.clps.sms.sys.model.Menu;


/**
 * @ClassName: MenuDao 
 * @Description: TODO(������һ�仰��������������) 
 * @author Leng Haoran
 * @date 2017��8��15�� ����11:56:31 
 *  
 */
public interface MenuDao {

	/**
	 * desc:
	 * 		query menu table detail	
	 * @return List<Menu>
	 */
	public List<Menu> queryMenuDetail();
}
