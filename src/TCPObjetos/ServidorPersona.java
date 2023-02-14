package TCPObjetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorPersona {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int puerto = 6000;
		ServerSocket servidor = null;
		Socket cliente = null;
		ObjectInputStream entrada = null;
		ObjectOutputStream salida = null;
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
			System.out.println("atendiendo al cliente y estableciendo IO");

			entrada = new ObjectInputStream(cliente.getInputStream());
			// DataInputStream flujoEntrada = new DataInputStream(entrada);

			salida = new ObjectOutputStream(cliente.getOutputStream());
			// DataOutputStream flujoSalida = new DataOutputStream(salida);

			Persona p;
			String n;
			int e;
			float nota;

			// cliente envia persona
			p = (Persona) entrada.readObject();

			System.out.println("Recibiendo del Cliente una Persona");
			System.out.println(p.toString());

			System.out.println("----MODIFICA info de la persona----");
			System.out.println("----cambia nombre----");
			n = sc.nextLine();
			System.out.println("----cambia edad----");
			e = sc.nextInt();
			System.out.println("----cambia nota----");
			nota = sc.nextInt();
			p.setEdad(e);
			p.setNombre(n);
			p.setNota(nota);

			System.out.println("Enviando al cliente una Persona modificada");
			System.out.println(p.toString());
			salida.writeObject(p);

			entrada.close();
			salida.close();
			cliente.close();

			// EL SERVER SOCKET no lo modificaremos hasta usar un runnable para cada cliente
			servidor.close();
			System.out.println("cerramos el servidor");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}