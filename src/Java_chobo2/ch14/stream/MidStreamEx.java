package Java_chobo2.ch14.stream;

import java.util.Comparator;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MidStreamEx {

	public static void main(String[] args) {
		Stream<Student> stdStream  =Stream.of(
				new Student("이자바",3,300),
				new Student("김자바",3,200),
				new Student("연자바",3,100),
				new Student("박자바",3,150),
				new Student("소자바",3,200),
				new Student("나자바",3,290),
				new Student("감자바",3,100)
				);
		stdStream.sorted(Comparator.comparing(Student::getBan).thenComparing(Comparator.naturalOrder())).forEach(System.out::println);
		
//		stdStream.sorted(Comparator.comparing(Student::getBan).thenComparing(Student::getName)).forEach(System.out::println);
		
		
		
		
//		extracted();
//		extracted05();

	}

	public static void extracted05() {
		//soreted
		Stream<String> strStream = Stream.of("dd","aaa","CC","cc","b");
		strStream.sorted().forEach(s -> System.out.print(s + " ")); //대-소 정렬
		System.out.printf("%n=================================================================%n");
		Stream.of("dd","aaa","cc","CC","b").sorted().forEach(s -> System.out.print(s + " "));
		System.out.printf("%n=================================================================%n");
		Stream.of("dd","aaa","cc","CC","b").sorted( (s1,s2) -> s1.compareTo(s2)).forEach(s -> System.out.print(s + " "));
		System.out.printf("%n=================================================================%n");
		Stream.of("dd","aaa","cc","CC","b").sorted(String::compareTo).forEach(s -> System.out.print(s + " "));
		System.out.printf("%n=================================================================%n");
		Stream.of("dd","aaa","cc","CC","b").sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s + " "));
		System.out.printf("%n=================================================================%n");
		Stream.of("dd","aaa","cc","CC","b").sorted(String.CASE_INSENSITIVE_ORDER).forEach(s -> System.out.print(s + " "));
		System.out.printf("%n=================================================================%n");
		Stream.of("dd","aaa","cc","CC","b").sorted(String.CASE_INSENSITIVE_ORDER.reversed()).forEach(s -> System.out.print(s + " "));
		System.out.printf("%n=================================================================%n");
	}

	public static void extracted() {
		// 중간연산
		// 1. skip(),limit()
		IntStream.rangeClosed(1, 10).skip(2).limit(5).forEach(System.out::print);
		System.out.printf("%n=================================================================%n");
		// 2. filter(),distinct()
		IntStream.of(1, 3, 2, 4, 5, 5, 5, 6, 8, 9, 7).distinct().sorted().forEach(s -> System.out.print(s + " "));
		System.out.printf("%n=================================================================%n");
		IntStream.rangeClosed(1, 20).filter(i -> i % 2 == 0).forEach(s -> System.out.print(s + " "));
		System.out.printf("%n=================================================================%n");
		IntStream.rangeClosed(1, 20).filter(i -> i % 2 == 0).filter(i -> i % 3 == 0)
				.forEach(s -> System.out.print(s + " "));
		System.out.printf("%n=================================================================%n");
		IntPredicate test = new IntPredicate() {
			@Override
			public boolean test(int value) {
				return value % 2 == 0;
			}
		};
		IntPredicate p = t -> t % 2 == 0;
		IntStream.rangeClosed(1, 20).filter(p).forEach(s -> System.out.print(s + " "));
		System.out.printf("%n=================================================================%n");
	}
	

}
