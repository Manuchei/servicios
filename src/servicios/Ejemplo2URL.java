package servicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Ejemplo2URL {

	public static void main(String[] args) {

		URL url = null;
		try {
			url = new URL("https://www.hoteldelmarvigo.es/");

		} catch (MalformedURLException mue) {

		}
		BufferedReader br;

		try {
			InputStream is = url.openStream();
			br = new BufferedReader(new InputStreamReader(is));

			String ln;
			while ((ln = br.readLine()) != null)
				System.out.println(ln);

		} catch (IOException ioe) {
			ioe.printStackTrace();

		}

	}

}
