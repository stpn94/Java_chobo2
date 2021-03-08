package Java_chobo2.ch14.stream;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamForEachToArrayEx {

	public static void main(String[] args) {
		
		// 스트림의 모든 요소에 지정된 작업을 수행
		System.out.printf("%n=============================================%n");
		IntStream.range(1, 10).sequential().forEach(new IntConsumer() {
			
			@Override
			public void accept(int value) {
				System.out.print(value);
			}
		});
		
		IntStream.range(1, 10).parallel().forEach(System.out::print);
		
		IntStream.range(1, 10).parallel().forEach(e -> System.out.print(e));
		
		System.out.printf("%n=============================================%n");
		
		IntStream.range(1, 10).parallel().forEachOrdered(System.out::print);
		
		System.out.printf("%n=============================================%n");
		// 스트림을 배열로 변환
		Student[] stdArr = {new Student("김인환",1,280),
							new Student("이태훈",1,280),
							new Student("김상건",1,280),
							new Student("전수린",1,280)
							};
		Stream<Student> studentStream = Arrays.stream(stdArr);
		
		Student[] tempArr = studentStream.toArray(Student[]::new);
		System.out.println(Arrays.toString(tempArr));
		
		studentStream = Arrays.stream(stdArr);
		Object[] objArr = studentStream.toArray();
		System.out.println(Arrays.toString(objArr));
		
		
		
		
	}

}
