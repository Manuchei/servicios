package servicios;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAdress2 {

	public static void main(String[] args) {

		InetAddress dir = null;
		System.out.println("SALIDA PARA UNA URL");
		try {
			dir = InetAddress.getByName("www.ebay.com");
			pruebaMetoddos(dir);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

	private static void pruebaMetoddos(InetAddress dir) {
		// TODO Auto-generated method stub

		System.out.println("\tMetodo getByName(): " + dir);
		InetAddress dir2;
		try {
			dir2 = InetAddress.getLocalHost();
			System.out.println("\tMetodo getLocalHost(): " + dir2);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		// USAMOS METODOS DE LA CLASE
		System.out.println("\tMetodo getHostName(): " + dir.getHostName());
		System.out.println("\tMetodo getHostAddress(): " + dir.getHostAddress());
		System.out.println("\tMetodo toString(): " + dir.toString());
		System.out.println("\tMetodo getCanonicalHostName(): " + dir.getCanonicalHostName());
	}// pruebaMetodos
}