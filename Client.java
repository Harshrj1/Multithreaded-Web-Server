import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {

    public Consumer<Socket> getConsumer(){
        return(clientSocket)->{
            try{
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream());
                toClient.println("Hello from the server");
                toClient.close();
                clientSocket.close();
            }catch (Exception e){
                System.out.println("Exception caught by catch of Consumer function");
                e.printStackTrace();
            }
        };
    }


    public static void main(String[] args) throws IOException {
        int port = 8080;
        Server server = new Server();
        try {
            ServerSocket socket = new ServerSocket(port);
            socket.setSoTimeout(10000);
            System.out.println("Server listing on the port: 8080");
            while(true){
                Socket accepted_con = socket.accept();
                Thread thread= new Thread(()->server.getConsumer().accept(accepted_con));
                thread.start();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
