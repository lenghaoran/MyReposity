/**
 * @Title: DBConnection.java 
 * @Package com.clps.sms.utils.db 
 * @Description: 数据库工具包
 * @author Leng Haoran   
 * @date 2017年8月15日 下午2:14:45 
 * @version V1.0  
 */
package com.clps.sms.utils.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * @ClassName: DBConnection
 * @Description: MySQL数据库连接工具类
 * @author Leng Haoran
 * @date 2017年8月15日 下午2:14:45
 * 
 */
public class DBConnection {
	private static Logger logger = Logger.getLogger(DBConnection.class);
	private static Connection conn;
	private static PreparedStatement pst = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	private static boolean flag = false;
	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/clps_sms";
	static String username = "root";
	static String password = "root";

	static {
		try {
			Class.forName(driver).newInstance();

			conn=DriverManager.getConnection(url, username, password);

			logger.info("MySQL db connection success!");

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			logger.error("MySQL db connection failure!");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}

	/**
	 * @Title: Connclose 
	 * @Description: 关闭所有
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws 
	 */
	public static void Connclose() {
		try {
			if (rs != null) {
				rs.close();
			}

			if (st != null) {
				st.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
			logger.info("MySQL db connection is closed!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Title: execUpdate 
	 * @Description: 增，删，改 方法
	 * @param @param sql
	 * @param @param objects
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws 
	 */
	public static boolean execUpdate(String sql,Object[] objects) {
		try {
			pst = conn.prepareStatement(sql);
			if(objects!=null){
				for(int i=0;i<objects.length;i++){	
					pst.setObject(i+1, objects[i]);
				}
			}
			int a=pst.executeUpdate();
			if(a==1){
				flag=true;                                                //更新成功 返回 true
			}else{
				flag=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * @Title: execQuery 
	 * @Description: 查询，返回结果集
	 * @param @param sql
	 * @param @param objects
	 * @param @return    设定文件 
	 * @return ResultSet    返回类型 
	 * @throws 
	 */
	public static ResultSet execQuery(String sql,Object[] objects) {
		try {
			if(objects!=null){
				pst = conn.prepareStatement(sql);
				for(int i=0;i<objects.length;i++){	
					pst.setObject(i+1, objects[i]);
				}
				rs=pst.executeQuery();
			}else{
				rs=conn.createStatement().executeQuery(sql);
				//rs=st.executeQuery(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
