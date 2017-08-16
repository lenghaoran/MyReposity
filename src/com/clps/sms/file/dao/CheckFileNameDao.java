/**
 * 
 */
package com.clps.sms.file.dao;

import java.util.Map;


/**
 * @ClassName: CheckFileNameDao 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Leng Haoran
 * @date 2017年8月11日 上午10:16:02 
 *  
 */
public interface CheckFileNameDao {


	public Map<String,String> getNames(String fileName,String separator,String sfn);
}
