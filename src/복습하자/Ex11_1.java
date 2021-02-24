package 복습하자;

import java.util.*;

public class Ex11_1 {

	public static void main(String[] args) {
		ArrayList list1  = new ArrayList(10);
		list1.add(new Integer(5));    // list1 리스트에 정수(5) 추가
		list1.add(new Integer(4));    // list1 리스트에 정수(4) 추가
		list1.add(new Integer(2));    // list1 리스트에 정수(2) 추가
		list1.add(new Integer(0));    // list1 리스트에 정수(0) 추가
		list1.add(new Integer(1));    // list1 리스트에 정수(1) 추가
		list1.add(new Integer(3));    // list1 리스트에 정수(3) 추가
		
		ArrayList list2 = new ArrayList(list1.subList(0, 3)); // list2에 새로운  ArrayList 타입의 객체 (list의 0번째에서 3번째까지) 넣는다.
		print(list1, list2); //출력
		
		Collections.sort(list1); //정렬
		Collections.sort(list2); //정렬
		
		print(list1, list2);
		
		System.out.println("list1.containsAll(list2):" + list1.containsAll(list2));
		System.out.println("--------------------------------------------------------");
		list2.add("B"); //B 추가
		list2.add("C"); //C 추가
		list2.add(3,"AAAAA"); //index[3] 안에  A추가
		print(list1, list2);
		
		System.out.println("--------------------------------------------------------");
		
		
		list2.set(3, "AAAAAAAAA"); //index[3] 안에  A추가
		print(list1, list2);
		
		System.out.println("--------------------------------------------------------");

		System.out.println("list1.retainAll(list2) == " +  list1.retainAll(list2)); //list1.과 .
		

	}

	
	
	
	private static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		System.out.println();
		
	}

}
