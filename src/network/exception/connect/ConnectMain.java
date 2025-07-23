package network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectMain {

  public static void main(String[] args) throws IOException {
    unknownHostEx1();
    unknownHostEx2();
    connectionRefused();
  }

  // 없는 IP 주소
  private static void unknownHostEx1() throws IOException {
    try {
      Socket socket = new Socket("999.999.999.999", 80);
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }

  // 없는 도메인
  private static void unknownHostEx2() throws IOException {
    try {
      Socket socket = new Socket("google.gogo", 80);
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }

  // 45678 포트를 사용하지 않기 때문에 TCP 연결 거절
  private static void connectionRefused() throws IOException {
    try {
      Socket socket = new Socket("localhost", 45678);
    } catch (ConnectException e) {
      e.printStackTrace();
    }
  }
}
