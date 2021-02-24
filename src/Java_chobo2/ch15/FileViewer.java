package Java_chobo2.ch15;
import java.io.*;

class FileViewer {
	public static void main(String args[]) throws IOException {
		FileInputStream fis = new FileInputStream(args[0]);
//	윗 줄 대신 아래 줄 입력하고  Run(ctrl+F11)���� ���� 
//		FileInputStream fis = new FileInputStream(".\\src\\FileViewer.java");

		int data = 0;

		while((data=fis.read())!=-1) {
			char c = (char)data;
			System.out.print(c);
		}
	} 
}