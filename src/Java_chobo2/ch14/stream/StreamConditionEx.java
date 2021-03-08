package Java_chobo2.ch14.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamConditionEx {

	public static void main(String[] args) {
		// allMatch(모든 요소가 일치하면 참)
		// anyMatch(하나의 요소라도 일치하면 참)
		// noneMatch(모든 요소가 불 일치하면 참)
		List<Student> list = new ArrayList<>();
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("연자바", 1, 100));
		list.add(new Student("박자바", 2, 150));
		list.add(new Student("소자바", 2, 200));
		list.add(new Student("나자바", 2, 290));
		list.add(new Student("소자바", 1, 95));
		list.add(new Student("나자바", 3, 200));
		list.add(new Student("감자바", 3, 180));

		matchEx(list);

		findEx(list);

	}

	private static void findEx(List<Student> list) {
		System.out.printf("%n=============================================%n");
		// Optional<T> findFirst() 조건에 일치하는 첫 번째 요소를 반환
		// Optional<T> findAny() 조건에 일치하는 요소를 하나 반환(병렬스트림)
		Stream<Student> stdStream = list.stream();
		Optional<Student> result = stdStream.filter(s->s.getTotalScore()<=100).findFirst();
		System.out.println(result);
		result = list.parallelStream().filter(s->s.getTotalScore()<=100).findAny();
		System.out.println(result);

		System.out.printf("%n=============================================%n");
	}

	private static void matchEx(List<Student> list) {
		System.out.printf("%n=============================================%n");
		Stream<Student> stdStream = list.stream();

		boolean hasRes = stdStream.anyMatch(new Predicate<Student>() {
			@Override
			public boolean test(Student t) {
				return t.getTotalScore() <= 100;
			}
		});
		System.out.printf("hasRes : %s%n", hasRes);

		stdStream = list.stream();
		hasRes = stdStream.allMatch(s -> s.getTotalScore() >= 80); // allMatch
		System.out.printf("hasRes : %s%n", hasRes);

		System.out.printf("%n=============================================%n");
	}

}
