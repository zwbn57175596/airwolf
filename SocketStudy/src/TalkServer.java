import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TalkServer {
	public static void main(String args[]) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(4700); // create a listner on port 4700
			Socket socket = null;
			socket = server.accept();
			// user accpet to access to client. When Client comes, create a socket
			// object, then exxcute
			String line;
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Client : " + is.readLine());
			line = sin.readLine();
			while (true) {
				os.println(line);
				os.flush();
				System.out.println("Server : " + line);
				String clientSays = is.readLine();
				System.out.println("Client : " + clientSays);
				if (null == clientSays) {
					os.close();
					is.close();
					socket.close();
				}
				line = sin.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
