/**
 * 
 */
package com.clps.sms.sys.dao;

import java.util.List;

import com.clps.sms.sys.model.Menu;


/**
 * @ClassName: MenuDao 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Leng Haoran
 * @date 2017年8月15日 下午11:56:31 
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
