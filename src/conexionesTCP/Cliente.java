package conexionesTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// mi direccion IP 10.101.19.37
		String host = "localhost";
		int puerto = 6000;
		System.out.println("iniciando cliente..");

		// pedir conexion //gerstion de la comunicacion IO
		Socket cliente = null;
		OutputStream salida = null;
		InputStream entrada = null;
		boolean seguir = true;

		try {
			cliente = new Socket(host, puerto);
			InetAddress ip = cliente.getInetAddress();

			/*
			 * precisamos los puntos basicos de la conexion
			 * System.out.println("puerto local: "+cliente.getLocalPort());
			 * System.out.println("puerto remoto: "+cliente.getPort());
			 * System.out.println("host remoto: "+ ip.getHostName());
			 * System.out.println("host remoto IP: "+ip.getHostAddress().toString());
			 */

			// flujo salida
			salida = cliente.getOutputStream();
			DataOutputStream flujoSalida = new DataOutputStream(salida);
			// flujo entrada
			entrada = cliente.getInputStream();
			DataInputStream flujoEntrada = new DataInputStream(entrada);

			while (seguir) {
				// pedir mensaje por teclado
				System.out.println("----introduce X para cortar la conexion----");
				System.out.println("mensaje: ");
				String mensaje = sc.nextLine();
				if (mensaje.charAt(0) != 'X') {
					flujoSalida.writeUTF(mensaje);
					System.out.println("mensaje recibido desde el servidor " + flujoEntrada.readUTF());
				} else {
					seguir = false;
					flujoSalida.writeUTF(mensaje);
					flujoEntrada.close();

				}

			}

			// cierre del zocalo
			System.out.println("cerrando flujos y socket");

			flujoSalida.close();
			cliente.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}