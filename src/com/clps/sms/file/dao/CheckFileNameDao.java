/**
 * 
 */
package com.clps.sms.file.dao;

import java.util.Map;


/**
 * @ClassName: CheckFileNameDao 
 * @Description: TODO(������һ�仰��������������) 
 * @author Leng Haoran
 * @date 2017��8��11�� ����10:16:02 
 *  
 */
public interface CheckFileNameDao {


	public Map<String,String> getNames(String fileName,String separator,String sfn);
}
