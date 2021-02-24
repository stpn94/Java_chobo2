package Java_chobo2.ch10;

import java.util.ArrayList;
import java.util.Comparator;

class Department {
	private int deptNo;
	private String deptName;
	private int floor;

	public Department() {
	}

	public Department(int deptNo) {
		this.deptNo = deptNo;
	}

	public Department(int deptNo, String deptName, int floor) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.floor = floor;
	}

	@Override
	public String toString() {
		return String.format("Department [%s, %s, %s]", deptNo, deptName, floor);
	}
	// 이꼴즈 오버라이딩

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) // 같은 주소
			return true;
		if (obj == null) // 비교한 필요 없다
			return false;
		if (getClass() != obj.getClass()) // 같은 주소
			return false;
		Department other = (Department) obj;
		// 형변환
		if (deptNo != other.deptNo)
			return false;
		return true;
	}

}

public class ArrayListEx {
	public static void main(String[] args) {
//		extractedMethod01();

		ArrayList<Department> deptList = new ArrayList<Department>();
		deptList.add(new Department(1, "기획", 20));
		deptList.add(new Department(2, "개발", 10));
		deptList.add(new Department(3, "인사", 30));

		System.out.println(deptList);
		prnList(deptList);

		int idx = deptList.indexOf(new Department(2, "개발", 10));
		System.out.println("idx" + idx);

		boolean isContain = deptList.contains(new Department(2));
		System.out.println(isContain);

//		deptList.remove(new Department(2));
//		prnList(deptList);
		Department upDept = new Department(2, "마케팅", 11);
		deptList.set(deptList.indexOf(upDept), upDept);
		prnList(deptList);
	}

	private static void prnList(ArrayList<Department> deptList) {
		for (Department d : deptList) {
			System.out.println(d);
		}
		System.out.println();
	}

	public static void extractedMethod01() {
		ArrayList<Integer> arrList = new ArrayList<>();
		System.out.println(arrList);

		arrList.add(10); // autoboxing되서 들어간다.
		arrList.add(20);
		System.out.println(arrList);
		System.out.println(arrList.size()); // index 개수

		arrList.add(1, 40); // 1의 위치에 40입력
		System.out.println(arrList);
		System.out.println(arrList.size());

		System.out.println("40 indexOf " + arrList.indexOf(40)); // 40의 위치

		arrList.remove(1); // 1배열에 있는 거 삭제
		System.out.println(arrList);
		System.out.println(arrList.size());

		arrList.add(50);
		arrList.add(60);
		System.out.println(arrList);

		arrList.remove(new Integer(50)); // 객체 인티저타입 50 을 삭제
		System.out.println(arrList);

		for (int a : arrList) { // auto 언박싱
			System.out.println(a);
		}

		for (int i = 0; i < arrList.size(); i++) {
			System.out.println(arrList.get(i));
		}

		arrList.set(1, 40); // 1번
		System.out.println(arrList);

		if (arrList.contains(30)) { // 30을 포함하고 있냐?
			System.out.println("있다.");
		} else {
			System.out.println("없다.");
		}

		System.out.println(arrList.contains(60));// 60있냐?

		ArrayList<String> strList = new ArrayList<String>();
		strList.add("bfb");
		strList.add("avv");
		strList.add("csd");

		System.out.println(strList); // 정렬하고 싶다.

		strList.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.hashCode() - o2.hashCode(); // a b -> 97-98
			}
		});
		System.out.println(strList);
	}

}
