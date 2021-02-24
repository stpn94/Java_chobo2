package Java_chobo2.ch12;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public enum Direction1 {
	EAST(1), SOUTH(5), WEST(10), NORTH(15);
	
	private final int value;
			
	private Direction1(int value) {
		this.value = value;
	}

	private int getValue() {
		return value;
	}
}

