package TCPObjetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClienteArrPersona {

	// quiero un arrayList de Personas
	// el ciente pedira el nombre y edad de personas
	// y las añadira a la lista
	// hasta que el usuario mande parar

	public static ArrayList<Persona> lista;

	public static Persona pideDatos() {
		Scanner sc = new Scanner(System.in);

		Persona p;
		String n;
		int e;
		float nota;

		System.out.println("----introduce nombre----");
		n = sc.nextLine();
		System.out.println("----introduce edad----");
		e = sc.nextInt();
		System.out.println("----introduce nota----");
		nota = sc.nextFloat();
		p = new Persona(n, e, nota);
		System.out.println(p.toString());

		return p;

	}

	public static ArrayList<Persona> generaLista() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Persona> lista = new ArrayList<Persona>();
		String continuar = "s";
		while (continuar.equals("s")) {
			Persona persona = pideDatos();
			lista.add(persona);

			System.out.println("¿Desea añadir otra persona? (s/n)");
			continuar = sc.nextLine();
		}

		return lista;
	}

	public static void main(String[] args) throws ClassNotFoundException {

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

			lista = generaLista();

			salida.writeObject(lista);

			lista = (ArrayList<Persona>) entrada.readObject();
			for (Persona p : lista) {
				System.out.println("persona MODIFICADA recibida desde el servidor ");
				System.out.println(p.toString());
			}

			System.out.println("cerrando flujos y socket");
			salida.close();
			entrada.close();
			cliente.close();

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
