/**
 * @Title: Student.java 
 * @Package com.clps.sms.utils.poiUtils.model 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Leng Haoran   
 * @date 2017年8月14日 下午10:34:16 
 * @version V1.0  
 */
package com.clps.sms.utils.poi.model;

import java.util.Date;

/**
 * @ClassName: Student 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Leng Haoran
 * @date 2017年8月14日 下午10:34:16 
 *  
 */
public class Student {
	    private long id;  
	    private String name;  
	    private int age;  
	    private boolean sex;  
	    private Date birthday;
	    public Student()  
	    {  
	    	
	    }  
	  
	    public Student(long id, String name, int age, boolean sex, Date birthday)  
	    {  
	        this.id = id;  
	        this.name = name;  
	        this.age = age;  
	        this.sex = sex;  
	        this.birthday = birthday;  
	    }

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public boolean getSex() {
			return sex;
		}

		public void setSex(boolean sex) {
			this.sex = sex;
		}

		public Date getBirthday() {
			return birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
	    
}
