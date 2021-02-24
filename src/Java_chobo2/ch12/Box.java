package Java_chobo2.ch12;

import java.util.ArrayList;

public class Box1<T> {
//	private ArrayList<T> list = new ArrayList<T>();
	private ArrayList<T> list;
	
	public Box() {
		list = new ArrayList<T>();
		
	}

	public void add(T item) {
		list.add(item);
				
	}
	
	public T get(int idx) {
		return list.get(idx);
	}

	public ArrayList<T> getList() {
		return list;
	}

	public int size() {
		return list.size();
		
	}

	@Override
	public String toString() {
		return String.format("Box [list=%s]", list);
	}
	
}
