package Java_chobo2.ch14.join;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class MyClass {
	public MyClass(int x) {
		this.x = x;
	}


	public MyClass(int x, int y) {
		this.x = x;
		this.y = y;
	}
	

	public MyClass() {
		// TODO Auto-generated constructor stub
	}

	int x;
	int y;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MyClass) {
			MyClass other = (MyClass) obj;
			if (x == other.x) {
				return true;
			}
		}
		return false;
	}// end of equals

	@Override
	public String toString() {
		return String.format("MyClass [x=%s, y=%s]", x, y);
	}

}// end of MyClass class

public class MethodRefEx {

	public static void main(String[] args) {
		Function<String, Integer> f = s -> Integer.parseInt(s);
		System.out.println(f.apply("16"));

		Function<String, Integer> f2 = Integer::parseInt;
		System.out.println(f2.apply("16"));

		BiFunction<String, String, Boolean> g = (s1, s2) -> s1.equals(s2);
		System.out.println(g.apply("abc", "abc"));

		BiFunction<String, String, Boolean> h = String::equals;
		System.out.println(h.apply("abc", "abc"));

		System.out.println("---------------------------");

		MyClass m1 = new MyClass(5, 2);
		MyClass m2 = new MyClass(4, 2);
		MyClass m3 = new MyClass(5, 3);

		Function<MyClass, Boolean> j = i -> m1.equals(i);
		System.out.println(j.apply(m2));
		System.out.println(j.apply(m3));

		Function<MyClass, Boolean> k = m1::equals;
		System.out.println(k.apply(m2));
		System.out.println(k.apply(m3));
		
		Supplier<MyClass> s =() -> new MyClass();
		System.out.println(s.get());
		Supplier<MyClass> s1 =() -> new MyClass(2,3);
		System.out.println(s1.get());
		
		Function<Integer, MyClass> t = MyClass::new;
		System.out.println(t.apply(10));

		//MyClass(int,int)
		
		BiFunction<Integer,Integer , MyClass> u = MyClass::new;
		System.out.println(u.apply(10,50));
		//array
		Function<Integer, int[]> v = int[]::new;
		System.out.println(Arrays.toString(v.apply(5)));
		
		
	}// end of class

}
