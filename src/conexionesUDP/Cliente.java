package conexionesUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {

		// conexion
		int port = 12345; // puerto al que enviamos el DP
		InetAddress destino = InetAddress.getLocalHost();
		DatagramSocket socket = new DatagramSocket();
		boolean seguir = true;
		Scanner ent = new Scanner(System.in);

		while (seguir) {
			// mensaje
			byte[] mensaje = new byte[1024]; // array de bytes con msg

			// Scanner y que escriba la respuest
			System.out.println("Introduce el mensaje: ");
			String saludo = ent.nextLine();

			mensaje = saludo.getBytes();
			DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
			socket.send(envio);
			System.out.println("mensaje enviado");

			if (!saludo.trim().equals("quit")) {

				byte[] buffer = new byte[1024];

				DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
				socket.receive(recibo);

				String paquete = new String(recibo.getData());
				System.out.println("mensaje del servidor: " + paquete.trim());
			} else {
				seguir = false;
			}

		}
		System.out.println("Cerrando cliente");
		socket.close();

	}
}

// socket.close();
