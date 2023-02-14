package conexionesUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class ServidorBisiesto {
	public static void main(String[] args) {

		byte[] bufer = new byte[1024];
		Scanner entr = new Scanner(System.in);
		boolean seguir = true;

		try {
			DatagramSocket socket = new DatagramSocket(12345);

			System.out.println("Esperando Datagrama");

			while (seguir) {
				DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);

				socket.receive(recibo);
				// int bytesRec = recibo.getLength();

				String paquete = new String(recibo.getData());

				if (paquete.trim().equals("quit")) {
					seguir = false;
					System.out.println("Contenido del Paquete: " + paquete.trim());
				} else {

					System.out.println("Contenido del Paquete: " + paquete.trim());

					String msg = comprobracion(paquete.trim());
					byte[] mensaje = new byte[1024];
					mensaje = msg.getBytes();
					DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, recibo.getAddress(),
							recibo.getPort());
					socket.send(envio);
					if (msg.equals("quit"))
						seguir = false;
				}
			}

			socket.close();
			entr.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String comprobracion(String recibida) {

		String respuesta = "";
		int anho = Integer.parseInt(recibida);

		if (anho % 4 == 0 && anho % 100 != 0 || anho % 400 == 0) {

			respuesta = "ES BISIESTO";

		} else {
			respuesta = "NO ES BISIESTO";
		}

		return respuesta;

	}

}
