package conexionesUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteBisiesto {

	public static void main(String[] args) {

		int port = 12345; // puerto al que enivamos el DP
		boolean seguir = true;
		try {

			DatagramSocket socket = new DatagramSocket();

			InetAddress destino = InetAddress.getLocalHost(); /// IP destino

			while (seguir) {

				byte[] mensaje = new byte[1024]; // array de bytes con msg
				System.out.println("Cliente comprobacion año bisiesto ");
				String saludo = filtro();

				mensaje = saludo.getBytes(); // conversion string a byte arr

				// enviamos el mensaje
				DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
				socket.send(envio);

				if (saludo.equals("quit")) {
					seguir = false;
				} else {
					// recepcion de mensajes
					byte[] buffer = new byte[1024];

					DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);

					socket.receive(recibo);

					String paquete = new String(recibo.getData());

					System.out.println("mensaje del servidor: " + paquete.trim());

					if (paquete.trim().equals("quit"))
						seguir = false;
				}

			}
			socket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String filtro() {

		Scanner entr = new Scanner(System.in);
		System.out.println("Introduce año para comprobacion: ");
		String cadena = entr.nextLine();
		boolean valido = true;

		if (cadena.equals("quit")) {

			return cadena;

		} else {

			int anho = Integer.parseInt(cadena);

			do {

				if (anho < 2500 && anho > 0) {

					valido = false;
					cadena = String.valueOf(anho);

				} else {
					System.out.println("Año no valido");
					System.out.println("Introduce año para comprobacion: ");
					cadena = entr.nextLine();
				}

			} while (valido);

			return cadena;
		}

	}

}
