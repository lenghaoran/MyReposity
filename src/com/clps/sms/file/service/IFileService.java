/**
 * 
 */
package com.clps.sms.file.service;

import java.util.List;
import java.util.Map;

import com.clps.sms.file.model.FileName;


/**
 * @ClassName: IFileService 
 * @Description: TODO(������һ�仰��������������) 
 * @author Leng Haoran
 * @date 2017��8��11�� ����10:18:02 
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
