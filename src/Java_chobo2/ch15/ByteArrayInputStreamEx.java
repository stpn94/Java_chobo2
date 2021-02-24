package Java_chobo2.ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class ByteArrayInputStreamEx {

	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
	
		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int data = 0;
		
		while( (data = bais.read()) != -1) { //data에 저장된 값이 -1이 아닐 때 까지, byte 배열(스트림)에 하나씩 저장한다.
			
			baos.write(data); // void write( int b)
			
		}
		
		outSrc = baos.toByteArray(); // 스트림의 내용을 byte 배열로 반환한다.
		
		System.out.println("Input Source  :" + Arrays.toString(inSrc));
		System.out.println("Output Source :" + Arrays.toString(outSrc));
	}
}
