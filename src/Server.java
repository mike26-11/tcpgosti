import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    private int porta;

    public Server(int porta) {
        this.porta = porta;
        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("Il server è in ascolto");
        } catch (IOException e) {
            System.err.println("...");
        }
    }

    public Socket attendi(){
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Il server ha accettato la richiesta!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         finally {
            return clientSocket;
        }
    }

    public void leggi(){
        try{
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String testo = br.readLine();
            System.out.println("CLIENT: " + testo);
        } catch (IOException e) {
            //
        }
    }




    public void termina(){
        try {
            serverSocket.close();
        } catch (IOException e) {
            //
        }
    }
}
