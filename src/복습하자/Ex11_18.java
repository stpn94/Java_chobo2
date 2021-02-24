package 복습하자;

import java.util.HashMap;

public class Ex11_18 {
	public static void main(String[] args) {
		String[] data = { "A","K","A","K","D","K","A","K","K","K","Z","D"};
		
		HashMap map = new HashMap();
		
		for(int i=0; i < data.length; i++) {  // 0 부터  data배열의 길이(12)까지 반복
			if(map.containsKey(data[i])	) {   // 만약 map안에 data의 i번째 값이 포함이 되어있다면
				Integer value = (Integer)map.get(data[i]);
				map.put(data[i],new Integer(value.intValue()+1));
			}
		}
	}
}
