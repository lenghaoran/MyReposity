/**
 * @Title: CalendarUtils.java 
 * @Package com.clps.sms.utils 
 * @Description: �����������
 * @author Leng Haoran   
 * @date 2017��8��10�� ����9:36:22 
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
 * @Description: ����������
 * @author Leng Haoran
 * @date 2017��8��10�� ����9:36:22
 * 
 */
public class CalendarUtils {

	private static Logger log = Logger.getLogger(CalendarUtils.class);

	private static SimpleDateFormat sdf;

	private static Calendar cad;

	/**
	 * @Title: convertToDate
	 * @Description: ���û�������ַ�������ת����Date����
	 * @param @param
	 *            str
	 * @param @return
	 * @param @throws
	 *            ParseException
	 * @return Date ��������
	 * @throws ParseException
	 */
	private static Date convertToDate(String str) {
		log.info("com.clps.sms.utils.CalendarUtils.StringconvertToDate()"); // ��ӡ��־��Ϣ
		sdf = new SimpleDateFormat("yyyy��MM��");
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
		log.info("com.clps.sms.utils.CalendarUtils.StringconvertToDate()"); // ��ӡ��־��Ϣ
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
	 * @Title: getDate @Description: ��ӡ���µĹ��� @param @param nowDate �趨�ļ� @return
	 *         void �������� @throws
	 */
	private static void getDate(Date nowDate) {
		log.info("com.clps.sms.utils.CalendarUtils.getDate()"); // ��ӡ��־��Ϣ
		cad = Calendar.getInstance();
		cad.setTime(nowDate);
		int day_month = cad.getActualMaximum(Calendar.DAY_OF_MONTH); // ��ȡ��������
		int[][] array = new int[6][7];
		for (int i = 0; i < day_month - 1; i++) { // ѭ������ÿ��
			cad.set(Calendar.DAY_OF_MONTH, i + 1);
			int week_month = cad.get(Calendar.WEEK_OF_MONTH); // ��ȡ�����ڱ��µĵڼ������ڣ�Ҳ���ǵڼ���
			int now_day_month = cad.get(Calendar.DAY_OF_WEEK); // ��ȡ�����ڱ����ڵĵڼ��죬Ҳ���ǵڼ���
			array[week_month - 1][now_day_month - 1] = i + 1; // ��������ڶ�ά������
		}
		String[] weeks = { "��", "һ", "��", "��", "��", "��", "��" };
		for (String w : weeks) {
			System.out.print(w + "\t");
		}
		System.out.println(); // ��ӡ����
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
	 * @Title: IndexWeek @Description: ����ĳһ����һ���еĵڼ����� @param @param
	 *         str @param @throws ParseException �趨�ļ� @return void �������� @throws
	 */
	public static int IndexWeek(String str) {

		log.info("com.clps.sms.utils.CalendarUtils.IndexWeek()"); // ��ӡ��־��Ϣ

		System.out.println("���������ڣ�yyyy-MM-dd���Ի�ȡ������һ���еĵڼ����� ��");
		Date nowDate = convertToDateYearMonthDay(str);
		cad = Calendar.getInstance();
		cad.setTime(nowDate);
		int week = cad.get(Calendar.WEEK_OF_YEAR); // ��ȡ�ڸ���ĵڼ�����
		return week;
	}

	/**
	 * @throws ParseException
	 * 			@Title: getWeek @Description: ȡ��ָ�����������ڼ� @param @param
	 *             date @param @return �趨�ļ� @return String �������� @throws
	 *             ParseException
	 */
	public static String getWeek(String str) {

		log.info("com.clps.sms.utils.CalendarUtils.getWeek()"); // ��ӡ��־��Ϣ

		System.out.println("���������ڣ�yyyy-MM-dd���Ի�ȡ������һ���е����ڼ�");
		Date date = convertToDateYearMonthDay(str);
		String[] weeks = { "������", "����һ", "���ڶ�", "������", "������ ", "������", "������" };
		cad = Calendar.getInstance();
		cad.setTime(date);
		int week_index = cad.get(Calendar.DAY_OF_WEEK) - 1; // ��ȡ�����ڵĵڼ���
		if (week_index < 0) {
			week_index = 0;
		}
		return weeks[week_index];
	}

	/**
	 * @throws ParseException
	 * 			@Title: showDate @Description: չʾ���� @param @param input
	 *             �趨�ļ� @return void �������� @throws ParseException
	 */
	public static void showDate(Scanner input) {

		log.info("com.clps.sms.utils.CalendarUtils.showDate()"); // ��ӡ��־��Ϣ

		System.out.println("�������ѯ�·ݣ�yyyy��MM�£���");
		String result = input.next(); // ��ȡ�û����������
		Date nowDate = convertToDate(result); // ����ת��

		if (input != null) {
			input.close();
		}

		sdf = new SimpleDateFormat("yyyy��MM��");
		System.out.println("����ǰ��������ڣ�" + sdf.format(nowDate)); // ��ʽ���������ʱ��
		getDate(nowDate); // չʾ

	}

	/**
	 * @Title: weekForDay 
	 * @Description: ����һ���еĵڼ������Ǽ���
	 * @param @param year
	 * @param @param week
	 * @param @return    �趨�ļ� 
	 * @return String    �������� 
	 * @throws 
	 */
	public String weekForDay(int year,int week){
		
		log.info("com.clps.sms.utils.CalendarUtils.weekForDay()");      // ��ӡ��־��Ϣ
		
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
		log.info("com.clps.sms.utils.CalendarUtils.TestDateUtils()"); // ��ӡ��־��Ϣ
		
		System.out.println(weekForDay(2017,8));

		Scanner input = new Scanner(System.in);

		showDate(input); // ��������

		System.out.println(IndexWeek("2017-08-10")); // ����ĳһ����һ���еĵڼ����ڲ���

		System.out.println(getWeek("2017-08-10")); // ȡ��ָ�����������ڼ�����
	}
}
