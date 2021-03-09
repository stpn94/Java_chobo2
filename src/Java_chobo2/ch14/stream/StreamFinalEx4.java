package Java_chobo2.ch14.stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamFinalEx4 {

	public static void main(String[] args) {
		
		Student2[] stuArr = {
	            new Student2("나자바", true,  1, 1, 300),   
	            new Student2("김지미", false, 1, 1, 250),   
	            new Student2("김자바", true,  1, 1, 200),   
	            new Student2("이지미", false, 1, 2, 150),   
	            new Student2("남자바", true,  1, 2, 100),   
	            new Student2("안지미", false, 1, 2,  50),   
	            new Student2("황지미", false, 1, 3, 100),   
	            new Student2("강지미", false, 1, 3, 150),   
	            new Student2("이자바", true,  1, 3, 200),   
	            new Student2("나자바", true,  2, 1, 300),   
	            new Student2("김지미", false, 2, 1, 250),   
	            new Student2("김자바", true,  2, 1, 200),   
	            new Student2("이지미", false, 2, 2, 150),   
	            new Student2("남자바", true,  2, 2, 100),   
	            new Student2("안지미", false, 2, 2,  50),   
	            new Student2("황지미", false, 2, 3, 100),   
	            new Student2("강지미", false, 2, 3, 150),   
	            new Student2("이자바", true,  2, 3, 200)   
	         };
		//steam 변환
		
		Map<Boolean, List<Student2>> stdBySex = Arrays.stream(stuArr)
				.collect(partitioningBy(Student2::isMale));
		
		List<Student2> maleStds = stdBySex.get(true);
		System.out.println(maleStds);
		
		List<Student2> femaleStds = stdBySex.get(false);
		System.out.println(femaleStds);
		
		//분할 + 통계
		Map<Boolean, Long> stdNumBySex = Arrays.stream(stuArr)
				.collect(partitioningBy(Student2::isMale,counting()));
		System.out.printf("남학생 %d 명, 여학생 %d 명%n",stdNumBySex.get(true),stdNumBySex.get(false));
		
		// 단순분할 + 통계(성별 1등)
		Map<Boolean, Optional<Student2>> topScoreBySex = Stream.of(stuArr)
				.collect(partitioningBy(Student2::isMale, 
					maxBy(comparingInt(Student2::getScore))
				));
		System.out.println("남학생 1등 :"+ topScoreBySex.get(true));
		System.out.println("여학생 1등 :"+ topScoreBySex.get(false));

		Map<Boolean, Student2> topScoreBySex2 = Stream.of(stuArr)
			.collect(partitioningBy(Student2::isMale, 
				collectingAndThen(
					maxBy(comparingInt(Student2::getScore)), Optional::get
				)
			));

		System.out.println("남학생 1등 :"+ topScoreBySex2.get(true));
		System.out.println("여학생 1등 :"+ topScoreBySex2.get(false));

		//성별로 분할 후 성적으로 분할 (점수가 150점 기준)
		Map<Boolean, Map<Boolean, List<Student2>>> failedStdBySex = 
				Arrays.stream(stuArr)
				.collect(
						partitioningBy(
								Student2::isMale,
								partitioningBy(s->s.getScore()<150)
								));
		
		List<Student2> failedMaleStu   = failedStdBySex.get(true).get(true);
		List<Student2> failedFemaleStu = failedStdBySex.get(false).get(true);
		
		System.out.println("성별 불합격자 목록");
		System.out.println(failedMaleStu);
		System.out.println(failedFemaleStu);
		
		for(Student2 s : failedMaleStu)   System.out.println(s);
		for(Student2 s : failedFemaleStu) System.out.println(s);
		
	}

}
