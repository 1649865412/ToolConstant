package baseClass.baseuse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUse {

	/** 判断某一天在这一年里的第几天 */
	public void daySum(int year, int month, int day) {
		int sum = 0;
		// 闰年2月有29天
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			switch (month) {
			case 12:
				sum += 30;
			case 11:
				sum += 31;
			case 10:
				sum += 30;
			case 9:
				sum += 31;
			case 8:
				sum += 31;
			case 7:
				sum += 30;
			case 6:
				sum += 31;
			case 5:
				sum += 30;
			case 4:
				sum += 31;
			case 3:
				sum += 29;
			case 2:
				sum += 31;
			case 1:
				sum += day;
			}
		} else {
			switch (month) {
			case 12:
				sum += 30;
			case 11:
				sum += 31;
			case 10:
				sum += 30;
			case 9:
				sum += 31;
			case 8:
				sum += 31;
			case 7:
				sum += 30;
			case 6:
				sum += 31;
			case 5:
				sum += 30;
			case 4:
				sum += 31;
			case 3:
				sum += 28;
			case 2:
				sum += 31;
			case 1:
				sum += day;
			}

		}
		System.out.println(sum);
	}

	/** 某一年中1月到某月共有几天*/
	public void monthSum(int year, int month) {
		int sum = 0;// 用于求天数总和
		int day = 0;// 表示每个月的天数
		for (int i = 1; i < month; i++) {
			switch (i) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				day = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				day = 30;
				break;
			case 2:
				if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
					day = 29;
				} else {
					day = 28;
				}
				break;
			}
			sum += day;
		}
		System.out.println(sum);
	}

	/** 输出字符串日期，并判断明天星期几*/
	public void dateString(String str, String dateFrom) {
		// 如str = "2015-05-11 10:20:30" dateFrom="yyyy-MM-dd hh:mm:ss"
		SimpleDateFormat f = new SimpleDateFormat(dateFrom);
		Date date = null;
		try {
			date = f.parse(str);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		System.out.println("明天星期"+cal.get(Calendar.DAY_OF_WEEK));
	}

}
