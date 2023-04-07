package texto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
  public static void main(String[] args) throws IOException {
    try (ServerSocket serverSocket = new ServerSocket(54321)) {

      System.out.println("A porta 54321 foi aberta!");
      System.out.println("Servidor aguardando receber mensagem do cliente...");

      Socket socket = serverSocket.accept();
      System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + " conectado!");

      DataInputStream entrada = new DataInputStream(socket.getInputStream());
      String mensagem = entrada.readUTF();
      String novaMensagem = mensagem.toUpperCase();

      DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
      saida.writeUTF(novaMensagem);

      entrada.close();
      saida.close();

      socket.close();
    } catch (IOException error) {
      System.out.println("Erro: " + error.getMessage());
    }
  }
}
