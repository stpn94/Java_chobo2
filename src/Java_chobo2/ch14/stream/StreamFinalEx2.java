package Java_chobo2.ch14.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamFinalEx2 {

	public static void main(String[] args) {

		List<Student> list = new ArrayList<>();
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("연자바", 1, 100));
		list.add(new Student("박자바", 2, 150));
		list.add(new Student("소자바", 2, 200));
		list.add(new Student("나자바", 2, 290));
		list.add(new Student("힌자바", 1, 95));
		list.add(new Student("굴자바", 3, 200));
		list.add(new Student("감자바", 3, 180));

		// 스트림을 컬렉션으로 변환
		extracted(list);

		// 스트림의 통계정보
		extracted02(list);

		// 스트림을 reducing
		System.out.printf("%n==================%n");
		OptionalInt maxValue1 = new Random(1234).ints(1, 46).distinct().limit(6).peek(s -> System.out.print(s + ","))
				.reduce(Integer::max);
		System.out.println("max = " + maxValue1.getAsInt());
		System.out.printf("%n==================%n");
		Optional<Integer> maxValue2 = new Random(1234).ints(1, 46).distinct().limit(6) //IntStream  
				.boxed()																//Stream<Integer>
				.collect(Collectors.reducing(Integer::max));
		System.out.println("max = " + maxValue2.get());
		System.out.printf("%n==================%n");
		int sum1 = new Random(1234).ints(1, 46).distinct().limit(6)   
				.reduce(0,(a,b)->a+b);																
		System.out.println("sum1 = %d" + sum1);
		System.out.printf("%n==================%n");
		
		int sum2 = new Random(1234).ints(1, 46).distinct().limit(6)   
				.boxed()
				.collect(Collectors.reducing(0,(a,b)->a+b));																
		System.out.println("sum2 = %d" + sum2);
		System.out.printf("%n==================%n");
		
		int grandTotal1 = list.parallelStream().map(Student::getTotalScore).reduce(0, Integer::sum);
		System.out.println(grandTotal1);
		
		System.out.printf("%n==================%n");
		int grandTotal2 = list.parallelStream().collect(Collectors.reducing(0, Student::getTotalScore,Integer::sum));
		System.out.println(grandTotal2);
		
		System.out.printf("%n==================%n");
		// 문자열 스트림을 모두 연결(Joinning)
		String names1 =list.parallelStream().map(Student::getName).collect(Collectors.joining());
		System.out.println(names1);
		System.out.printf("%n==================%n");
		String names2 =list.parallelStream().map(Student::getName).collect(Collectors.joining(","));
		System.out.println(names2);
		System.out.printf("%n==================%n");
		String names3 =list.parallelStream().map(Student::getName).collect(Collectors.joining(",","[","]"));
		System.out.println(names3);
		System.out.printf("%n==================%n");
	}

	public static void extracted02(List<Student> list) {
		long cnt1 = list.stream().count();
		long cnt2 = list.stream().collect(Collectors.counting());
		System.out.printf("count %d, %d%n", cnt1, cnt2);
		System.out.printf("%n==================%n");
		int sum1 = list.parallelStream().mapToInt(Student::getTotalScore).peek(System.out::println).sum();
		int sum2 = list.parallelStream().collect(Collectors.summingInt(Student::getTotalScore));
		System.out.printf("totalScore %d, %d%n", sum1, sum2);

		System.out.printf("%n==================%n");
		OptionalInt max1 = list.parallelStream().mapToInt(Student::getTotalScore).peek(System.out::println).max();

		System.out.printf("maxSore %d%n", max1.getAsInt());
		System.out.printf("%n==================%n");

		Optional<Student> maxStd1 = list.parallelStream().max(Comparator.comparingInt(Student::getTotalScore));

		System.out.println(maxStd1.get());
		System.out.printf("%n==================%n");

		Optional<Student> maxStd2 = list.parallelStream()
				.collect(Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore)));

		System.out.println(maxStd2.get());
		System.out.printf("%n==================%n");

		IntSummaryStatistics iss1 = list.parallelStream().mapToInt(Student::getTotalScore).summaryStatistics();
		System.out.println(iss1);
		System.out.printf("%n==================%n");

		IntSummaryStatistics iss2 = list.parallelStream().collect(Collectors.summarizingInt(Student::getTotalScore));
		System.out.println(iss2);
		System.out.printf("%n==================%n");
	}

	public static void extracted(List<Student> list) {
		List<String> stdList = list.stream().map(Student::getName).peek(System.out::println)
				.collect(Collectors.toList());

		System.out.println(stdList);
		ArrayList<Student> arList = list.stream().collect(Collectors.toCollection(ArrayList::new));

		// Map<이름, 학생>
		Map<String, Student> may = list.stream().collect(Collectors.toMap(s -> s.getName(), s -> s));

		for (Entry<String, Student> e : may.entrySet()) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}
	}

}
