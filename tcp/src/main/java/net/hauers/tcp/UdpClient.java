package net.hauers.tcp;

import java.net.Socket;
import java.net.InetSocketAddress;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UdpClient {
  
  public String sendAndReceive(String stringToSend) throws IOException{

    Socket socket = new Socket();
    socket.connect(new InetSocketAddress("localhost", 2000));

    PrintWriter out =
        new PrintWriter(socket.getOutputStream(), true);
    BufferedReader in =
        new BufferedReader(
            new InputStreamReader(socket.getInputStream()));

    out.write("Hello");


    return in.readLine();

  }
}