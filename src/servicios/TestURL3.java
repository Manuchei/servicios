package servicios;

import java.net.MalformedURLException;
import java.net.URL;

public class TestURL3 {

	public static void main(String[] args) {

		URL url;

		try {

			System.out.println("constructor con cuatro parametros de URL");
			url = new URL("http", "dcos.oracle.com", 80, "/javase/8");
			visualizar(url);

		} catch (MalformedURLException mex) {
			System.out.println(mex);
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
