/**
 * 
 */
package com.clps.sms.file.dao.impl;

import java.util.Map;
import java.util.TreeMap;
import com.clps.sms.file.dao.CheckFileNameDao;


/**
 * @ClassName: CheckFileName 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Leng Haoran
 * @date 2017年8月11日 上午10:17:04 
 *  
 */
public class CheckFileName implements CheckFileNameDao {


	private Map<String,String> maps;
	/**
	 * 
	 */
	public CheckFileName() {
		this.maps =new TreeMap<>();
	}

	
	/* (non-Javadoc)
	 *
	 * <p>Title: getNames</p> 
	 * <p>Description: </p> 
	 * @param fileName
	 * @param separator
	 * @param sfn
	 * @return 
	 * @see com.clps.sms.dao.CheckFileNameDao#getNames(java.lang.String, java.lang.String, java.lang.String) 
	 * since v1.0
	 */
	public Map<String,String> getNames(String fileName,String separator,String sfn){
		String []strNames =fileName.split(sfn);
		String [] splitedName = null;
		for(String str:strNames){
			splitedName =this.splitFileName(separator, str);
				maps.put(splitedName[0], splitedName[1]);
		}
		return maps;
	}
	
	/**
	 * 
	 * @param separator
	 * @param fileName
	 * @return String []
	 */
	public String [] splitFileName(final String separator, final String fileName){
		String []temp = null;
		if(null!=separator||("").equals(separator)){
			temp=fileName.split(separator);	
		}else{
			//
		}
		return temp;
	}
	
	/**
	 * @Title: checkName 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param srcName
	 * @param @param inName
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws 
	 */
	public boolean checkName(String srcName,String inName){
		if(srcName.equals(inName)||srcName==inName){
			return true;
		}else{
			return false;
		}
	}
	
}
