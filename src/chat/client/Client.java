package chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

public class Client {

  private final String host;

  private final int port;

  private Socket socket;

  private DataInputStream input;

  private DataOutputStream output;

  private Readhandler readhandler;

  private WriteHandler writehandler;

  private boolean closed = false;

  public Client(String host, int port) {
    this.host = host;
    this.port = port;
  }

  public void start() throws IOException {
    log("클라이언트 시작");
    this.socket = new Socket(host, port);
    this.input = new DataInputStream(socket.getInputStream());
    this.output = new DataOutputStream(socket.getOutputStream());

    this.readhandler = new Readhandler(input, this);
    this.writehandler = new WriteHandler(output, this);
    Thread readThread = new Thread(readhandler, "readHandler");
    Thread writeThread = new Thread(writehandler, "writehandler");
    readThread.start();
    writeThread.start();
  }

  public void close() {
    if (closed) return;

    writehandler.close();
    readhandler.close();
    closeAll(socket, input, output);
    closed = true;
    log("연결 종료: " + socket);
  }
}
