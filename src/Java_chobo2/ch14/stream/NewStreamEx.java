package Java_chobo2.ch14.stream;

import java.util.Random;
import java.util.stream.IntStream;

public class NewStreamEx {

	public static void main(String[] args) {
		//범위를 요소로
		IntStream.range(1, 10).forEach(System.out::print);
		System.out.printf("%n--------------------------------------------------%n");
		IntStream.rangeClosed(1, 10).forEach(System.out::print);
		System.out.printf("%n--------------------------------------------------%n");
		// 난수를 요소로
		new Random(1234).ints().limit(5).sorted().forEach(System.out::println);
		System.out.printf("%n--------------------------------------------------%n");
		new Random(1234).ints(5).sorted().forEach(System.out::println);
		System.out.printf("%n--------------------------------------------------%n");
		System.out.printf("%d ~ %d%n", Integer.MIN_VALUE,Integer.MAX_VALUE);
		System.out.printf("%n--------------------------------------------------%n");
		
		
	}

}
