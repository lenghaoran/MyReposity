/**
 * 
 */
package com.clps.sms.file.service;

import java.util.List;
import java.util.Map;

import com.clps.sms.file.model.FileName;


/**
 * @ClassName: IFileService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Leng Haoran
 * @date 2017年8月11日 上午10:18:02 
 *  
 */
public interface IFileService {

	/**
	 * 
	 * @param names
	 * @param separator
	 * @param sfn
	 * @return Map<String, List<FileName>> 
	 */
	public Map<String, List<FileName>> countStudentName(String names, String separator, String sfn);
}
