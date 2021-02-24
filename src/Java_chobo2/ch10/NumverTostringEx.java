package Java_chobo2.ch10;

import java.text.DecimalFormat;

public class NumverTostringEx {
	public static void main(String[] args) {
		double number = 1234567.89;
		System.out.println("number > " +number);
		
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("#,###.#");
		
		String str=df.format(number);
		System.out.println(str);
		
		df.applyPattern("000000000,0);y"
				+ "df.format(number);"
	
	}
}
