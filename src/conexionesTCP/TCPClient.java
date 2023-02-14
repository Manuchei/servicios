package conexionesTCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class TCPClient {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Que dia es hoy? (yyyy-MM-dd): ");
		String dateString = scanner.nextLine();
		Socket socket = new Socket("localhost", 6000);
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		DataInputStream input = new DataInputStream(socket.getInputStream());
		output.writeUTF(dateString);
		String dayOfWeek = input.readUTF();
		System.out.println("Hoy es: " + dayOfWeek);
		socket.close();
	}
}
