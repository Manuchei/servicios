package conexionesTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TCPServer {
	public static void main(String[] args) throws IOException, Exception {
		ServerSocket serverSocket = new ServerSocket(6000);
		while (true) {
			Socket socket = serverSocket.accept();
			DataInputStream input = new DataInputStream(socket.getInputStream());
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			String dateString = input.readUTF();
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			String dayOfWeekString = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
			output.writeUTF(dayOfWeekString);
			socket.close();
		}
	}
}
