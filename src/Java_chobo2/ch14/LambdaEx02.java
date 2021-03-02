package Java_chobo2.ch14;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaEx02 {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("abc","aaa","bbb","ddd","aaa");
		//정렬 (abc 순으로 : 사전순)
		System.out.println(list);

		//역순정렬
		Comparator<String> comp = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		};
		Collections.sort(list,comp);
		System.out.println(list);
		
		//람다식을 이용해서 사전수으로 정렬
		Collections.sort(list, (o1,o2)->o1.compareTo(o2));
		System.out.println(list);
	}

}
