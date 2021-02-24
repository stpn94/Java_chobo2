package 복습하자;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Ex11_17 {
	public static void main(String[] args) {
		HashMap map = new HashMap(); // map 생성
		map.put("김자바",new Integer(90)); // hash map 에 김자바 와 객체 정수 90 입력
		map.put("김자바",new Integer(100));
		map.put("이자바",new Integer(100));
		map.put("강자바",new Integer(80));
		map.put("안자바",new Integer(90));
		
		Set set = map.entrySet(); //set에다가 map의엔트리셋(키들과 값들)을 저장
		Iterator it = map.entrySet().iterator(); // Iterator it에다가 map의엔트리셋(키들과 값들)의iterator형식(주소)형식으로 저장
		
		while(it.hasNext()) {
			Map.Entry e = (Entry) it.next();
			System.out.println("이름 : " + e.getKey() + ", 점수: " +e.getValue());
		}
		
		set = map.keySet();
		System.out.println("참가자 명단 : " + set);
		
		Collection values = map.values();
		it = values. iterator();
		
		int total = 0;
		while(it.hasNext()) {
			Integer i = (Integer)it.next();
			total += i.intValue();
		}
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (float)total/set.size());
		System.out.println("최고점수 : " + Collections.max(values));
		System.out.println("최고점수 : " + Collections.min(values));
	}
}
