package Java_chobo2.ch10;

import java.util.Calendar;

public class Ex10_1 {

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		System.out.println("이 해의 년도 : " + today.get((Calendar.YEAR)));
		System.out.println("월(0~11, 0:1월) : " + today.get((Calendar.MONTH)));
		System.out.println("오늘은 이 해의 몇 째 주 : " + today.get((Calendar.WEEK_OF_YEAR)));
		System.out.println("오늘은 이 달의 몇 째 주 : " + today.get((Calendar.WEEK_OF_MONTH)));

		System.out.println("오늘은 이 달의 몇 일 : " + today.get((Calendar.DATE)));
		System.out.println("오늘은 이 달의 몇 일 : " + today.get((Calendar.DAY_OF_MONTH)));
		System.out.println("오늘은 이 달의 몇 일 : " + today.get((Calendar.DAY_OF_YEAR)));
		System.out.println("요일(1~7, 1:일요일): " + today.get(Calendar.DAY_OF_WEEK));
		switch (today.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			System.out.println("일요일");
			break;
		case 2:
			System.out.println("월요일");
			break;
		case 3:
			System.out.println("화요일");
			break;
		case 4:
			System.out.println("수요일");
			break;
		case 5:
			System.out.println("목요일");
			break;
		case 6:
			System.out.println("금요일");
			break;
		case 7:
			System.out.println("토요일");
			break;
		}
		System.out.println("오늘은 이 달의 몇 째 요일 : " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH) +"주");
		System.out.println("지금은 오전_오후(0:오전, 1:오후)? :" + today.get(Calendar.AM_PM));
		
	}
}
