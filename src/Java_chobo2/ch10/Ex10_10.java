package Java_chobo2.ch10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex10_10 {
	public static void main(String[] args) {
		String pattern = "yyyy/MM/dd";
		DateFormat df = new SimpleDateFormat(pattern);
		Scanner s =new Scanner(System.in);
		
		Date inDate =null;
		
		System.out.println("날짜를 " +pattern + "의 형태로 입력해주세요(입력예 : 2019/12/31)");
		
		while(s.hasNextLine()) {
			try {
				inDate = df.parse(s.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("날짜를 " + pattern + "의 형태로 다시 입력해 주세요.");
			}
		}//while 반복
	}

}
