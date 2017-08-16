/**
 * @Title: CalendarUtils.java 
 * @Package com.clps.sms.utils 
 * @Description: 挂历工具类包
 * @author Leng Haoran   
 * @date 2017年8月10日 下午9:36:22 
 * @version V1.0  
 */
package com.clps.sms.utils.calendarUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.junit.Test;


/**
 * @ClassName: CalendarUtils
 * @Description: 挂历工具类
 * @author Leng Haoran
 * @date 2017年8月10日 下午9:36:22
 * 
 */
public class CalendarUtils {

	private static Logger log = Logger.getLogger(CalendarUtils.class);

	private static SimpleDateFormat sdf;

	private static Calendar cad;

	/**
	 * @Title: convertToDate
	 * @Description: 将用户输入的字符串日期转化成Date类型
	 * @param @param
	 *            str
	 * @param @return
	 * @param @throws
	 *            ParseException
	 * @return Date 返回类型
	 * @throws ParseException
	 */
	private static Date convertToDate(String str) {
		log.info("com.clps.sms.utils.CalendarUtils.StringconvertToDate()"); // 打印日志信息
		sdf = new SimpleDateFormat("yyyy年MM月");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			log.error(" throws ParseException");
			e.printStackTrace();
		}
		return date;
	}

	private static Date convertToDateYearMonthDay(String str) {
		log.info("com.clps.sms.utils.CalendarUtils.StringconvertToDate()"); // 打印日志信息
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			log.error(" throws ParseException");
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * @Title: getDate @Description: 打印该月的挂历 @param @param nowDate 设定文件 @return
	 *         void 返回类型 @throws
	 */
	private static void getDate(Date nowDate) {
		log.info("com.clps.sms.utils.CalendarUtils.getDate()"); // 打印日志信息
		cad = Calendar.getInstance();
		cad.setTime(nowDate);
		int day_month = cad.getActualMaximum(Calendar.DAY_OF_MONTH); // 获取当月天数
		int[][] array = new int[6][7];
		for (int i = 0; i < day_month - 1; i++) { // 循环遍历每天
			cad.set(Calendar.DAY_OF_MONTH, i + 1);
			int week_month = cad.get(Calendar.WEEK_OF_MONTH); // 获取该天在本月的第几个星期，也就是第几行
			int now_day_month = cad.get(Calendar.DAY_OF_WEEK); // 获取该天在本星期的第几天，也就是第几列
			array[week_month - 1][now_day_month - 1] = i + 1; // 将该天放在二维数组中
		}
		String[] weeks = { "日", "一", "二", "三", "四", "五", "六" };
		for (String w : weeks) {
			System.out.print(w + "\t");
		}
		System.out.println(); // 打印挂历
		for (int i = 0; i <= array.length - 1; i++) {
			for (int j = 0; j <= array[i].length - 1; j++) {
				if (array[i][j] != 0) {
					System.out.print(array[i][j]);
				}
				System.out.print("\t");
				if ((j + 1) % 7 == 0) {
					System.out.println();
				}
			}
		}
	}

	/**
	 * @Title: IndexWeek @Description: 计算某一天是一年中的第几星期 @param @param
	 *         str @param @throws ParseException 设定文件 @return void 返回类型 @throws
	 */
	public static int IndexWeek(String str) {

		log.info("com.clps.sms.utils.CalendarUtils.IndexWeek()"); // 打印日志信息

		System.out.println("请输入日期（yyyy-MM-dd）以获取该天是一年中的第几星期 ：");
		Date nowDate = convertToDateYearMonthDay(str);
		cad = Calendar.getInstance();
		cad.setTime(nowDate);
		int week = cad.get(Calendar.WEEK_OF_YEAR); // 获取在该年的第几星期
		return week;
	}

	/**
	 * @throws ParseException
	 * 			@Title: getWeek @Description: 取得指定日期是星期几 @param @param
	 *             date @param @return 设定文件 @return String 返回类型 @throws
	 *             ParseException
	 */
	public static String getWeek(String str) {

		log.info("com.clps.sms.utils.CalendarUtils.getWeek()"); // 打印日志信息

		System.out.println("请输入日期（yyyy-MM-dd）以获取该天是一年中的星期几");
		Date date = convertToDateYearMonthDay(str);
		String[] weeks = { "星期日", "星期一", "星期二", "星期三", "星期四 ", "星期五", "星期六" };
		cad = Calendar.getInstance();
		cad.setTime(date);
		int week_index = cad.get(Calendar.DAY_OF_WEEK) - 1; // 获取该星期的第几天
		if (week_index < 0) {
			week_index = 0;
		}
		return weeks[week_index];
	}

	/**
	 * @throws ParseException
	 * 			@Title: showDate @Description: 展示挂历 @param @param input
	 *             设定文件 @return void 返回类型 @throws ParseException
	 */
	public static void showDate(Scanner input) {

		log.info("com.clps.sms.utils.CalendarUtils.showDate()"); // 打印日志信息

		System.out.println("请输入查询月份（yyyy年MM月）：");
		String result = input.next(); // 获取用户输入的日期
		Date nowDate = convertToDate(result); // 日期转化

		if (input != null) {
			input.close();
		}

		sdf = new SimpleDateFormat("yyyy年MM月");
		System.out.println("您当前输入的日期：" + sdf.format(nowDate)); // 格式化输出日期时间
		getDate(nowDate); // 展示

	}

	/**
	 * @Title: weekForDay 
	 * @Description: 计算一年中的第几星期是几号
	 * @param @param year
	 * @param @param week
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws 
	 */
	public String weekForDay(int year,int week){
		
		log.info("com.clps.sms.utils.CalendarUtils.weekForDay()");      // 打印日志信息
		
		 sdf=new SimpleDateFormat("yyyy-MM-dd");  
		cad=Calendar.getInstance();  
		cad.set(Calendar.YEAR, year);                                   
		cad.set(Calendar.WEEK_OF_YEAR, week);  
		cad.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		String date = sdf.format((cad.getTime()));
		
		return date;
	}
	@Test
	public void TestDateUtils() {
		log.info("com.clps.sms.utils.CalendarUtils.TestDateUtils()"); // 打印日志信息
		
		System.out.println(weekForDay(2017,8));

		Scanner input = new Scanner(System.in);

		showDate(input); // 挂历测试

		System.out.println(IndexWeek("2017-08-10")); // 计算某一天是一年中的第几星期测试

		System.out.println(getWeek("2017-08-10")); // 取得指定日期是星期几测试
	}
}
