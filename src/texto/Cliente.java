package texto;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
  public static void main(String[] args) throws IOException {
    try  {
      Scanner input = new Scanner(System.in);

      Socket socket = new Socket("127.0.0.1", 54321);
      DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
      System.out.print("Digite a palavra: ");
      String inputName = input.nextLine();

      saida.writeUTF(inputName);

      DataInputStream entrada = new DataInputStream(socket.getInputStream());
      String novaMensagem = entrada.readUTF();
      System.out.println(novaMensagem);

      entrada.close();
      saida.close();

      input.close();

      socket.close();
    } catch (IOException error) {
    System.out.println("Erro: " + error.getMessage());
    }
  }
}
