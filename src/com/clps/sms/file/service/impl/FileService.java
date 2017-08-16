/**
 * 
 */
package com.clps.sms.file.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.clps.sms.file.model.FileName;
import com.clps.sms.file.service.IFileService;
import com.clps.sms.file.dao.impl.CheckFileName;
import com.clps.sms.file.dao.CheckFileNameDao;


/**
 * @ClassName: FileService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Leng Haoran
 * @date 2017年8月11日 上午10:18:41 
 *  
 */
public class FileService implements IFileService {

	private Map<String, List<FileName>> mapStudentDetails = null;
	private List<FileName> fileNameList = null;
	private CheckFileNameDao cfnDao = null;

	public FileService() {
		this.mapStudentDetails = new TreeMap<>();
		this.fileNameList = new ArrayList<>();
		this.cfnDao = new CheckFileName();
	}

	@Override
	public Map<String, List<FileName>> countStudentName(String names, String separator, String sfn) {
		this.mapStudentDetails.put("2017-08-09", 
				this.convertMapToList(cfnDao.getNames(names, separator, sfn)));
		return this.mapStudentDetails;
	}

	private List<FileName> convertMapToList(Map<String, String> maps) {
		FileName fn = null;
		for (Map.Entry<String, String> entry : maps.entrySet()) {
			fn = new FileName();
			fn.setStudentName(entry.getKey());
			fn.setWorkCreatedDate(entry.getValue());
			this.fileNameList.add(fn);
		}
		return fileNameList;
	}

}
