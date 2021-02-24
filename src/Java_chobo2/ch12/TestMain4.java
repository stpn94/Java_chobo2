package Java_chobo2.ch12;

public enum Direction1 {
	EAST(1), SOUTH(5), WEST(10), NORTH(15);
	
	private final int value;
			
	private Direction1(int value) {
		this.value = value;
	}

	private int getValue() {
		return value;
	}

public class TestMain4 {

	public static void main(String[] args) {

		Direction1 d1 = Direction1.EAST;
		Direction1 d2 = Direction1.valueOf("WEST");
		Direction1 d3 = Enum.valueOf(Direction1.class, "EAST");

		System.out.println((d1 + " : " + d2 + " : " + d3));

		System.out.println("d1==d2? " + (d1 == d2));
		System.out.println("d1.equals(d3)? " + d1.equals(d3));
		System.out.println("d2.equals(d3)? " + d2.equals(d3));
		System.out.println("d1.compareTo(d3)?  " + (d1.compareTo(d3)));

		switch (d3) {
		case EAST:
			System.out.println("The direction is EAST.");
			break;
		case SOUTH:
			System.out.println("The direction is SOUTH.");
			break;
		case WEST:
			System.out.println("The direction is WEST.");
			break;
		case NORTH:
			System.out.println("The direction is NORTH.");
			break;
		default:
			System.out.println("Invalid direction.");
			break;
		}
		Direction[] dArr = Direction.values();

		for(Direction d : dArr)  // for(Direction d : Direction.values()) 
			System.out.printf("%s=%d%n", d.name(), d.getValue()); 
	

	}

}
