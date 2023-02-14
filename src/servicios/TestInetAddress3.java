package servicios;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress3 {

	public static void main(String[] args) {

		InetAddress dir = null;

		System.out.println("SALIDA PARA UNA URL(incluso direcciones simples:)");
		try {
			// URL de www.google.es
			System.out.println("==================================");
			System.out.println("SALIDA PARA UNA URL(incluso direcciones multiples):");
			dir = InetAddress.getByName("www.google.com");

			// Array de tipo InetAddress con todas las direcciones IP
			// asignadas a google.es
			System.out.println("\tDIRECCIONES IP PARA: " + dir.getHostName());
			InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());
			for (int i = 0; i < direcciones.length; i++) {
				System.out.println("\t\t" + direcciones[i].toString());
			}

			System.out.println("=============================");

		} catch (UnknownHostException e) {
			// TODO: handle exception
		}

	}

}
