package TCPObjetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientePersona {

	// quiero un arrayList de Personas
	// el ciente pedira el nombre y edad de personas
	// y las añadira a la lista
	// hasta que el usuario mande parar

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// mi direccion IP 10.101.19.37
		String host = "localhost";
		int puerto = 6000;
		System.out.println("iniciando cliente..");

		Socket cliente = null;
		ObjectOutputStream salida = null;
		ObjectInputStream entrada = null;
		// boolean seguir=true;

		try {
			cliente = new Socket(host, puerto);
			InetAddress ip = cliente.getInetAddress();

			salida = new ObjectOutputStream(cliente.getOutputStream());
			// DataOutputStream flujoSalida=new DataOutputStream(salida);

			entrada = new ObjectInputStream(cliente.getInputStream());
			// DataInputStream flujoEntrada = new DataInputStream(entrada);
			Persona p;
			String n;
			int e;
			float nota;

			System.out.println("----introduce info de la persona----");
			System.out.println("----introduce nombre----");
			n = sc.nextLine();
			System.out.println("----introduce edad----");
			e = sc.nextInt();
			System.out.println("----introduce nota----");
			nota = sc.nextInt();
			p = new Persona(n, e, nota);
			System.out.println(p.toString());

			// envio persona
			salida.writeObject(p);

			// recibo persona
			p = (Persona) entrada.readObject();
			System.out.println("persona MODIFICADA recibida desde el servidor ");
			System.out.println(p.toString());

			System.out.println("cerrando flujos y socket");
			salida.close();
			entrada.close();
			cliente.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}