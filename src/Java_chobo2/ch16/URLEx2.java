package Java_chobo2.ch16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class URLEx2 {
	public static void main(String args[]) throws MalformedURLException {
		URL url = new URL("https://news.naver.com/main/ranking/read.nhn?mode=LSD&mid=shm&sid1=001&oid=025&aid=0003080763&rankingType=RANKING");

		try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test.html")))) {

			String line = null;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
