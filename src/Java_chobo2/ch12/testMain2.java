package Java_chobo2.ch12;

import java.util.ArrayList;
import java.util.Iterator;

class Product {
}

class Tv extends Product {
}

class Audio extends Product {
}

public class testMain2 {

	public static void main(String[] args) {
		
		ArrayList<Tv> listTv = new ArrayList<Tv>();
//		ArrayList<Product> listProduct = new ArrayList<Tv>();//아무리 부모 자식 관에 관계에 있어도 Product 는 Product만 사용가능하다  
		ArrayList<Product> listProduct = new ArrayList<>(); // <=== 이렇게 사용 가능하다.
		
		listTv.add(new Tv());
		
		listProduct.add(new Product());
		listProduct.add(new Tv());
		listProduct.add(new Audio());
		
		Iterator<Product> it = listProduct.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		

	}

}
