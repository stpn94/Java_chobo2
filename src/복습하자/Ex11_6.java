package 복습하자;

import java.util.Arrays;

public class Ex11_6 {
	public static void main(String[] args) {
		int[]	arr		= {0 , 1 , 3 , 8 , 5}; //배열생성
		int[][] arr2D	= {{ 11 , 12 , 13 },   //2차원 배열 생성
						   { 21 , 22 , 23 }};
		
		System.out.println("arr = "+Arrays.toString(arr));
		System.out.println("arr2D = "+Arrays.deepToString(arr2D));
		int[] arr2 = Arrays.copyOf(arr, arr.length);   // 복사(arr 을 arr 길이만)
		int[] arr3 = Arrays.copyOf(arr, 3);            // 복사(arr 을 3       길이만)
		int[] arr4 = Arrays.copyOf(arr, 7);            // 복사(arr 을 7       길이만 만약 데이터가 없다면 빈공간은 0)
		int[] arr5 = Arrays.copyOfRange(arr, 1, 4);    // 복사(arr 을 1에서 4번째까지 복사)
		int[] arr6 = Arrays.copyOfRange(arr, 1 ,3);    // 복사(arr 을 0에서 3번째까지 복사)
		
		System.out.println("----------------------------------------------------------------------------");		
		System.out.println("arr2 =" + Arrays.toString(arr2)); 
		System.out.println("arr3 =" + Arrays.toString(arr3));
		System.out.println("arr4 =" + Arrays.toString(arr4));
		System.out.println("arr5 =" + Arrays.toString(arr5));
		System.out.println("arr6 =" + Arrays.toString(arr6));
		
		System.out.println("----------------------------------------------------------------------------");		
		int[] arr7 = new int[5];
		Arrays.fill(arr7, 9);                          // arr7배열에 9를 채운다
		System.out.println(Arrays.toString(arr7));
		
		
		System.out.println("----------------------------------------------------------------------------");		
		Arrays.parallelSetAll(arr7,  i ->(int)(Math.random()*10)+1); //1부터 10까지랜덤하게 정수 형식인 i를 arr7 배열에 넣는다
		System.out.println(Arrays.toString(arr7));
		char[] g =new char[3];
		System.out.println(Arrays.toString(g));
		
		System.out.println("----------------------------------------------------------------------------");		
		for(int i : arr7) {
			char[] graph =new char[i];                   //문자 배열이인 graph에 i개 문자배열을 생성 하여 넣는다.
			Arrays.fill(graph, '*');                     //graph에 '*'을 채운다.
			System.out.println(new String(graph)+i);     //출력
		}
		
		String[][] str2D = new String[][] {{"aaa","bbb"},{"AAA","BBB"}};
		String[][] str2D2 = new String[][] {{"aaa","bbb"},{"AAA","BBB"}};
		
		System.out.println("----------------------------------------------------------------------------");		
		System.out.println(Arrays.deepEquals(str2D, str2D2));
		System.out.println(Arrays.equals(str2D, str2D2));
		
		System.out.println("----------------------------------------------------------------------------");		
		
		char[] chArr = {'a','d','b','c','e'};
		System.out.println("chArr =" + Arrays.toString(chArr));
		System.out.println("index of B = " + Arrays.binarySearch(chArr,'a'));
				
		Arrays.parallelSort(chArr);
		System.out.println("정렬 후...");		
		System.out.println("index of B = " + Arrays.binarySearch(chArr,'d'));
		
		System.out.println("----------------------------------------------------------------------------");		
		
		
		
		
		
		
	}

}
