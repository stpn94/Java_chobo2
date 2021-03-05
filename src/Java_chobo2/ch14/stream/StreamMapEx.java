package Java_chobo2.ch14.stream;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMapEx {

	public static void main(String[] args) {
//		extracted();
		
//		extracted2();
		
		IntStream intStream = new Random().ints(1,46); // 1~45사이의 정수(46은 포함안됨)
		
		Stream<Integer> integerStream = intStream.boxed();     // IntStream → Stream<Integer>
		integerStream.limit(6).forEach(System.out::println);
		
		Stream<String> lottoStream = new Random().ints(1,46).distinct().limit(6).sorted()
		                                 .mapToObj(i -> i+","); // IntStream → Stream<String> 
		lottoStream.forEach(System.out::print); // 12,14,20,23,26,29,

		
	}//end of main

	public static void extracted2() {
		List<Student> list = new ArrayList<>();
		
		list.add(new Student("이자바",3,300));
		list.add(new Student("김자바",3,200));
		list.add(new Student("연자바",3,100));
		list.add(new Student("박자바",3,150));
		list.add(new Student("소자바",3,200));
		list.add(new Student("나자바",3,290));
		list.add(new Student("감자바",3,100));
		
		Stream<Student> stdStream  =list.stream();
		
		System.out.printf("%n==============================================%n");
		
		//스트림을 그본 스트림으로 변환
		Stream<Integer> stdScoreStream = stdStream.map(Student :: getTotalScore);
//		stdScoreStream.forEach(System.out::println);
		int total = stdScoreStream.reduce(0, (a,b) -> a+b);
		System.out.println(total);

		System.out.printf("%n==============================================%n");
		stdStream = list.stream();
		IntStream stdScoreIntStream = stdStream.mapToInt(Student::getTotalScore);
		total = stdScoreIntStream.max().getAsInt();
		System.out.println(total);
		System.out.printf("%n==============================================%n");
	}

	public static void extracted() {
		List<File> list = new ArrayList<File>();
		list.add(new File("Ex1.java"));
		list.add(new File("Ex1.bak"));
		list.add(new File("Ex2.java"));
		list.add(new File("Ex1"));
		list.add(new File("Ex1.txt"));
		
		
		// map()으로 Stream<File>을 Stream<String>으로 변환
		// 파일 이름들을 String형식의 배열에 넣기
		Stream<File> fileStream = list.stream();
		Stream<String> fileNameStream = fileStream.map(File :: getName);
		fileNameStream.forEach(System.out::println);
		
		System.out.printf("%n==============================================%n");
		list.stream().map(File::getName)
		.filter(s->s.indexOf('.') != -1)
		.peek(System.out::println)
		.map(s->s.substring(s.indexOf('.')+1))//확장자가 있는것 찾기
		.peek(s->System.out.printf("filename=%s%n",s))
		.map(String::toUpperCase)
		.peek(s->System.out.printf("extension=%s%n",s))
		.distinct()
		.forEach(System.out::print);
		System.out.printf("%n==============================================%n");
		
		Set<String> s = new HashSet<>();
		for(File f : list) {
			s.add(f.getName());
		}
		System.out.println(s);
		
		Set<String> a = new HashSet<>();
		for(File f : list) {
			String ext =  f.getName();
			if(ext.indexOf('.') != -1) {
				a.add(ext.substring(ext.indexOf('.')+1).toUpperCase());
			}
		}
		System.out.println(a);
		System.out.printf("%n==============================================%n");
		File file = new File("test.java");
		String fileName = file.getName();		//"test.java"
		int idx = fileName.indexOf(".");		//4
		System.out.println(fileName.substring(idx+1).toUpperCase());
	}

}
