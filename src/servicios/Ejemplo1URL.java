package servicios;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Ejemplo1URL {

	public static void main(String[] args) {

		URL url = null;
		// obtener un conector a la URL para gestionar
		// dos flujos is y os
		URLConnection urlCon = null;

		try {
			url = new URL("https://www.cebem.net");
			urlCon = url.openConnection();
			BufferedReader in;
			// gestionamos con metodos del conector
			InputStream inputStream = urlCon.getInputStream();
			// se podria obtener tambien un flujo de entrada

			in = new BufferedReader(new InputStreamReader(inputStream));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
