package Java_chobo2.ch14.stream;

public class Student implements Comparable<Student> {
	
	private String name;
	private int ban;
	private int totalScore;
	
	public Student() {
	}


	public Student(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}

	public String getName() {
		return name;
	}

	public int getBan() {
		return ban;
	}
	public int getTotalScore() {
		return totalScore;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setBan(int ban) {
		this.ban = ban;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;

	}


	@Override
	public int compareTo(Student o) {
		return (this.totalScore - o.totalScore * -1);
	}

	@Override
	public String toString() {
		return String.format("Student [name=%s, ban=%s, totalScore=%s]", name, ban, totalScore);
	}
}
