package Java_chobo2.ch14.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamStateEx {

	public static void main(String[] args) {
		System.out.printf("%n=============================================%n");

		// count()
		// reduce()
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
		
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		long cnt1=list.stream().count();
		long cnt2=intList.stream().count();
		System.out.printf("list cnt = %d, intList cnt = %d%n",cnt1,cnt2);
		System.out.printf("%n=============================================%n");
		// max()
		Optional<Student> optStd =list.stream().max(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getTotalScore()-o2.getTotalScore();
			}
			
		});
		System.out.println("Max Total Score Student"+optStd);
		// min()
		Optional<Student> optStd2 = list.stream().min((o1,o2)->o1.getTotalScore()-o2.getTotalScore());
		System.out.println("Min Total Score Student"+optStd2);
		// 병렬
		Optional<Student> optStd3 = list.parallelStream().min((o1,o2)->o1.getTotalScore()-o2.getTotalScore());
		System.out.println("Min Student paralle"+optStd3);
		
		System.out.printf("=============================================%n");
		//sum()
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		IntStream intStream = IntStream.of(arr);
		
		int sum = intStream.sum();
		OptionalDouble avg = IntStream.of(arr).average();
		OptionalInt max = IntStream.of(arr).max();
		OptionalInt min= IntStream.of(arr).min();
		
		System.out.printf("sum = %d , avg = %.2f, max = %d, min =%d%n", sum, avg.getAsDouble(), max.getAsInt(), min.getAsInt());
		
		IntSummaryStatistics summary = IntStream.of(arr).summaryStatistics();
		System.out.println(summary);
		summary.getAverage();
		System.out.printf("count = %d, sum = %d , avg = %.2f, max = %d, min =%d%n",
				summary.getCount(),	summary.getSum(), summary.getAverage(), summary.getMax(), summary.getMin());
		
		System.out.printf("=============================================%n");
	}

}
