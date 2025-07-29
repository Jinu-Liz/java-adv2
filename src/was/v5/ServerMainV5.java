package was.v5;


import was.httpserver.HttpServer;
import was.httpserver.ServletManager;
import was.httpserver.servlet.DiscardServlet;
import was.v5.servlet.HomeServlet;
import was.v5.servlet.SearchServlet;
import was.v5.servlet.Site1Servlet;
import was.v5.servlet.Site2Servlet;

import java.io.IOException;

public class ServerMainV5 {

  private static final int PORT = 12345;

  public static void main(String[] args) throws IOException {
    ServletManager manager = new ServletManager();
    manager.add("/", new HomeServlet());
    manager.add("/site1", new Site1Servlet());
    manager.add("/site2", new Site2Servlet());
    manager.add("/search", new SearchServlet());
    manager.add("/favicon.ico", new DiscardServlet());

    HttpServer server = new HttpServer(PORT, manager);
    server.start();
  }

}
