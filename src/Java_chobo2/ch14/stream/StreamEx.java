package Java_chobo2.ch14.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx {

	public static void main(String[] args) {
		String[] strArr = { "aaa", "bbb", "ccc" };
		List<String> strList = Arrays.asList(strArr);

		System.out.println(Arrays.toString(strArr));
		System.out.println(strList);
		
		// 1. 정렬
		// 2. 출력
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));

		Collections.sort(strList);
		System.out.println(strList);
		// -----------------------------------------------------
		// stream 으로
		String[] strArr2 = { "aaa", "bbb", "ccc" };
		List<String> strList2 = Arrays.asList(strArr);

		Stream<String> strStream1 = Arrays.stream(strArr2);
		Stream<String> strStream2 = strList2.stream();

		strStream1.sorted().forEach(System.out::println);
		strStream2.sorted().forEach(System.out::println);

		// 정렬된 결과를 새로운 List 에 담아서 반환한다.
		// 1. 스트림은 데이터 소스로부터 데이터를 읽기만 할 뿐 변경하지 않는다.
		List<String> sortedList = strList2.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);

		// 2. 스트림은 Iterator 처럼 일회용이다. (필요하면 스트림을 생성해야 함)
//		long cnt = strStream1.count();
//		System.out.println(cnt); //에러 (strStream1은 위에서 한번 썼다.)

		long cnt = Arrays.stream(strArr2).count();
		System.out.println(cnt);

		// 3. 지연된 연산(최종 연산전 까지는 중간연산이 수행되지 않음)
		IntStream intStream = new Random().ints(1, 46);
		intStream.distinct().limit(6).sorted().forEach(i -> System.out.print(i + ", "));
		System.out.printf("%n=============================================================%n");
		intStream = new Random().ints(1,46);
		intStream.distinct().limit(6).sorted().forEach(i -> System.out.print(i + ", "));
		System.out.printf("%n=============================================================%n");
		Stream<String> strStream = Stream.of("dd","aaa","CC","cc","b"); // of == static
		int sum = strStream.parallel().mapToInt(s-> s.length()).sum();
		System.out.println("sum"+sum);
	}
}
