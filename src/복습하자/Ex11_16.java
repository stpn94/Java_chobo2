package 복습하자;

import java.util.HashMap;
// Map을 구현했으므로 key 와 value를 묶어서 하나의 데이터(entry)로 저장한다는 특징
// hasing을 사용 하기 때문에 많은 양의 데이터를 검색하는데 있어서 뛰어나다.
// key = 컬렉션 내의 키(key) 중에서 *유일*해야 한다. like ID
// value = 키(key)와 달리 데이터의 중복을 허용한다. like password
import java.util.Scanner;

public class Ex11_16 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("myId", "1234"); // map 객체 안에 넣는다(아이디,비밀번호)
		map.put("asdf", "1111");
		map.put("asdf", "1234");
		
		Scanner s = new Scanner(System.in);
		
		while(true) { //무한반복	
			System.out.println("id를 입력해주세요");
			System.out.print("id :");
			String id = s.nextLine().trim(); // ID 은 입력 값
			 
			System.out.print("password : ");
			String password = s.nextLine().trim(); // 비민번호 는 입력 값
			System.out.println();
			
			if(!map.containsKey(id)) { //만약 map에 ID(key)가 포함되어있지 않으면 true
				System.out.println("존재하지 않는 아이디 입니다. 다시입력"); //true면 출력
				continue; //while 다시 가자
			} else {                                               // false
				if(!(map.get(id)).equals(password)) { //get(id)==password(value)반환했는것이.입력 password와 똑같이 않으면 true 똑같은면 false
					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
				} else {
					System.out.println("id와 비밀번호가 일치합니다.");
					break;
				}
			}
		}
	}
}
