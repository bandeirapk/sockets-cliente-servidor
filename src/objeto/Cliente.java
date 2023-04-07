package objeto;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
  public static void main(String[] args) throws IOException {
    try {
      Scanner sc = new Scanner(System.in);

      System.out.println("Cliente executando...");
      Socket socket = new Socket("127.0.0.1", 54544);

      System.out.print("Digite o nome da pessoa: ");
      String name = sc.nextLine();
      System.out.print("Digite a idade da pessoa: ");
      int age = sc.nextInt();

      ObjectOutputStream outputSocket = new ObjectOutputStream(socket.getOutputStream());
      Pessoa person = new Pessoa("bandeira", 38);
      outputSocket.writeObject(person);

      outputSocket.close();

      socket.close();

      sc.close();
    } catch (Exception e) {
      System.out.println("Erro: " + e.getMessage());
    }
  }
}
