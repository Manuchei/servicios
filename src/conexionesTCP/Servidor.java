package conexionesTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	public static String convertirMayusculas(String mensaje) {
		return mensaje.toUpperCase();
	}

	public static void main(String[] args) {

		boolean seguir = true;
		Scanner sc = new Scanner(System.in);
		// apertura de servicio
		int puerto = 6000;
		ServerSocket servidor = null;
		Socket cliente = null;
		InputStream entrada = null;
		OutputStream salida = null;
		System.out.println("Esperando conexion cliente...");

		try {
			servidor = new ServerSocket(puerto);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("escuchando peticiones en " + servidor.getLocalPort());

		// gestion de conexion
		try {
			cliente = servidor.accept();
			// dar servicio gestion de IO
			System.out.println("atendiendo al cliente y estableciendo IO");

			// creamos un flujo de Entrada del Cliente
			entrada = cliente.getInputStream();
			DataInputStream flujoEntrada = new DataInputStream(entrada);

			// creamos flujo de salida al cliente
			salida = cliente.getOutputStream();
			DataOutputStream flujoSalida = new DataOutputStream(salida);

			while (seguir) {
				// cliente envia mensaje
				String recibida = flujoEntrada.readUTF();
				recibida = convertirMayusculas(recibida);
				System.out.println("Recibiendo del Cliente :\n\t" + recibida);

				if (recibida.charAt(0) == 'X') {
					seguir = false;
					flujoEntrada.close();
					flujoSalida.close();
				} else {
					System.out.println("mensaje: ");
					String mensaje = sc.nextLine();
					mensaje = convertirMayusculas(mensaje);
					flujoSalida.writeUTF(mensaje);
				}
			}

			// ya metere un boleano de corte en el cliente
			// cierre de FLUJOS Y DEL SOCKET CLIENTE Y DEL serverSocket
			entrada.close();
			salida.close();
			cliente.close();

			// YA NO ESTA DANDO SERVICIO
			servidor.close();
			System.out.println("cerramos el servidor");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}