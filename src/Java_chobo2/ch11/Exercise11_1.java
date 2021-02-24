package Java_chobo2.ch11;

import java.util.*;

public class Exercise11_1 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		Stack stack = new Stack();
	
		stack.add(list);
		
		System.out.println(!stack.empty());
		stack.pop();
	}

}
