import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server running on port " + port);

            while (true) {
                Socket client = serverSocket.accept();
                new Thread(() -> handleClient(client)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket client) {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true)
        ) {

            String request = in.readLine();
            System.out.println("Request: " + request);

            if (request.startsWith("GET")) {
                File file = new File("server_files/sample.txt");

                if (!file.exists()) {
                    out.println("HTTP/1.1 404 Not Found\r\n");
                    return;
                }

                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/plain");
                out.println("Content-Length: " + file.length());
                out.println();

                BufferedReader fileReader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = fileReader.readLine()) != null) {
                    out.println(line);
                }
                fileReader.close();

            } else if (request.startsWith("POST")) {

                // Skip headers
                String line;
                while (!(line = in.readLine()).isEmpty()) {}

                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("server_files/received.txt")
                );

                while (in.ready()) {
                    writer.write(in.readLine());
                    writer.newLine();
                }

                writer.close();
                System.out.println("File received");

                out.println("HTTP/1.1 200 OK\r\n");
            }

            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
