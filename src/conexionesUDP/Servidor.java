package conexionesUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class Servidor {

	public static void main(String[] args) throws IOException {

		int port = 12345;
		DatagramSocket socket = new DatagramSocket(port);
		System.out.println(" Arrancando Servidor ");
		Scanner ent = new Scanner(System.in);
		boolean seguir = true;

		while (seguir) {
			
			byte [] buffer = new byte[1024];
			DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
			socket.receive(recibo);
			String paquete = new String(recibo.getData());

			if (paquete.trim().equals("quit")) {
				seguir = false;
				

			} else {
				System.out.println("mensaje recibido: " + paquete.trim());

				System.out.println("Introduce respuesta: ");
				String msg = ent.nextLine();
				byte[] mensaje = new byte[1024];
				mensaje = msg.getBytes();

				DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, recibo.getAddress(),
						recibo.getPort());
				socket.send(envio);
				if(msg.equals("quit")) seguir = false;

			}

		}
		System.out.println("Cerrando servidor");
		socket.close();
	}
}
