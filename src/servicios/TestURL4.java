package servicios;

import java.net.MalformedURLException;
import java.net.URL;

public class TestURL4 {
	
	public static void main(String[] args) {
		
		URL url;

		try {

			System.out.println("constructor con cuatro parametros de URL");
			
			URL urlhome = new URL("https://docs.oracle.com");
			url = new URL(urlhome, "/javase/8/docs/api/java/net/URL.html");
			visualizar(url);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	private static void visualizar(URL url) {
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
