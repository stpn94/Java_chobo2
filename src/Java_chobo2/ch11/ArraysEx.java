package Java_chobo2.ch11;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntUnaryOperator;

public class ArraysEx {

	public static void main(String[] args) {
		// 배열의 출력
		// arrayToString();

		// 다차원 배열
		// arrayDeepToString();

		// 배열의 비교와 출력
		// arrayTOEquals();

		// 배열의 복사 copyOf(),copyOfRange()
		// arrayCopy();

		// 배열 채우기 fill(),setAll()
		// arrayToFill();

		// 배열을 List로 변환 asList
		// arrToList();

		// 배열의 정렬sort() 과 검색binarySerch()
		// arrayTobinarySearchBySort();

		// Comparator(정렬기준 구현)와 Comparable(정렬기준 외 다른 기준 정렬 사용)

		Student[] stdArr = { 
				new Student(3, "가가가", 20,90,90), 
				new Student(2, "가나가", 30,14,90), 
				new Student(1, "가가나", 50,90,90),
				new Student(4, "가가다", 20,20,40) };
		//기본을 학번순으로 정렬
		Arrays.sort(stdArr);
		prnStudent(stdArr);
		System.out.println(Arrays.toString(stdArr));
		
		
		//국어점수 순으로 정렬
		Comparator<Student> comp = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getKor() - o2.getKor();
				
			}
		};
		Arrays.sort(stdArr,comp);
		prnStudent(stdArr);
		
		//수학점수 순으로 정렬
		Comparator<Student> revComp = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getMath() - o2.getMath();
			}
		};
		Arrays.sort(stdArr,comp);
		prnStudent(stdArr);
	}

	private static void prnStudent(Student[] stdArr) {
		System.out.println("정렬");
		for(Student s : stdArr) {
			System.out.println(s);
		}
		System.out.println();
	}

	public static void arrayTobinarySearchBySort() {
		int[] arr = { 1, 2, 3, 4, 8, 2, 9, 6, 7 };
		System.out.println(Arrays.binarySearch(arr, 8));
		System.out.println(Arrays.binarySearch(arr, 1));
		System.out.println("-------------");

		long start = System.nanoTime();
		System.out.println("start ");
		Arrays.sort(arr);
//		Arrays.parallelSort(arr);
		long end = System.nanoTime() - start;
		System.out.println(end + "--end");
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.binarySearch(arr, 8));
		System.out.println(Arrays.binarySearch(arr, 1));
	}

	public static void arrToList() {
		Integer[] intArr = new Integer[] { 1, 2, 3, 4 };

		List<Integer> arList = Arrays.asList(intArr); // 배열을 "리스트로(as list)" 바꿈

		for (int a : arList) {
			System.out.println(a);
		}
		arList.set(1, 6);
		System.out.println(arList);

		ArrayList<Integer> al = new ArrayList<Integer>(arList); // 다시 리스트로 바꿔서 index 추가
		al.add(10);
		System.out.println(al);
	}

	public static void arrayToFill() {
		int[] newArr = new int[10];
		System.out.println(1);
		Arrays.fill(newArr, 10);
		System.out.println(Arrays.toString(newArr));
		// 배열 채우기 setAll()
		System.out.println(2);
		Arrays.setAll(newArr, (i) -> (int) (Math.random() * 5) + 1);
		System.out.println(Arrays.toString(newArr));

		System.out.println(3);
		Arrays.setAll(newArr, new IntUnaryOperator() {
			@Override
			public int applyAsInt(int operand) {
				return (int) (Math.random() * 5) + 1;
			}
		});
		System.out.println(Arrays.toString(newArr));
	}

	public static void arrayCopy() {
		int[] intArr1 = { 1, 2, 3, 4, 5, 6 };
		int[] copyArr1 = Arrays.copyOf(intArr1, intArr1.length);
		System.out.println(Arrays.toString(copyArr1));
		System.out.println(Arrays.equals(copyArr1, intArr1));
		int[] copyArr2 = Arrays.copyOf(intArr1, 3);
		System.out.println(Arrays.toString(copyArr2));
	}

	public static void arrayTOEquals() {
		// 두 배열 같은지 비교하기
		int[] intArr1 = { 1, 2, 3 };
		int[] intArr2 = { 1, 2, 3 };
		System.out.println(Arrays.equals(intArr2, intArr1));

		int[][] intTwoDimen1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] intTwoDimen2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(Arrays.deepEquals(intTwoDimen1, intTwoDimen2));
	}

	public static void arrayDeepToString() {
		// 2차원 배열 출력
		int[][] twoArr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(Arrays.toString(twoArr));
		System.out.println(Arrays.deepToString(twoArr));
	}

	public static void arrayToString() {
		// List를 Array로 변환
		ArrayList<String> arList = new ArrayList<String>(); // 리스트
		arList.add("abc");
		arList.add("def");
		arList.add("ghi");

		Object[] objArr = arList.toArray(); // object type //배열
		String str = Arrays.toString(objArr);
		System.out.println("objArr to String >" + str);

		String[] strArr = new String[arList.size()]; // String type //배열
		arList.toArray(strArr);
		System.out.println(Arrays.deepToString(strArr));
	}

}
