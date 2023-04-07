package objeto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    try (ServerSocket serverSocket = new ServerSocket(54544)) {
      System.out.println("Servidor executando na porta 54544");
      System.out.println("Aguardando conexão do cliente...");

      Socket socket = serverSocket.accept();
      System.out.println("Cliente: " + socket.getInetAddress().getHostAddress() + " conectado.");

      ObjectInputStream inputSocket = new ObjectInputStream(socket.getInputStream());
      Pessoa person = (Pessoa) inputSocket.readObject();
      System.out.println("Nome: " + person.getNome() + " \nIdade: " + person.getIdade());

      inputSocket.close();

      socket.close();
    } catch (IOException e) {
      System.out.println("Erro: " + e.getMessage());
    }
  }
}
