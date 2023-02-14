package servicios;

import java.net.MalformedURLException;
import java.net.URL;

public class TestURL2 {

	public static void main(String[] args) {

		URL url;

		try {

			url = new URL("http://localhost/PFC/gest/cli_gestion.php?S=3");
			visualizar(url);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	private static void visualizar(URL url) {
		// TODO Auto-generated method stub
		System.out.println("\tURL completa: " + url.toString());
		System.out.println("\tgetProtocol: " + url.getProtocol());
		System.out.println("\tgetHost: " + url.getHost());
		System.out.println("\tgetPort: " + url.getPort());
		System.out.println("\tgetFile: " + url.getFile());
		System.out.println("\tgetUserInfo: " + url.getUserInfo());
		System.out.println("\tgetPath: " + url.getPath());
		System.out.println("\tgetAuthority: " + url.getAuthority());
		System.out.println("\tgetQuery: " + url.getQuery());
		System.out.println("======================================");
	}
}
