package Java_chobo2.ch15;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializableEx {

	public static void main(String[] args) {

		try (FileOutputStream fos = new FileOutputStream(fileName);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos)) {

			UserInfo u1 = new UserInfo("JavaMan", "1234", 30);
			UserInfo u2 = new UserInfo("JavaWeMan", "4321", 26);
			
			ArrayList<UserInfo> list = new ArrayList<>();
			
			oos.writeObject(u1);
			oos.writeObject(u2);
			oos.writeObject(list);
			
			list.add(u1);
			list.add(u2);

		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
