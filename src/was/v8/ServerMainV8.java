package was.v8;

import was.httpserver.HttpServer;
import was.httpserver.HttpServlet;
import was.httpserver.ServletManager;
import was.httpserver.servlet.DiscardServlet;
import was.httpserver.servlet.annotation.AnnotationServletV2;
import was.httpserver.servlet.annotation.AnnotationServletV3;

import java.io.IOException;
import java.util.List;

public class ServerMainV8 {

  private static final int PORT = 12345;

  public static void main(String[] args) throws IOException {
    List<Object> contorollers = List.of(new SiteControllerV8(), new SearchControllerV8());
//    HttpServlet annotationServlet = new AnnotationServletV2(contorollers);
    HttpServlet annotationServlet = new AnnotationServletV3(contorollers);

    ServletManager servletManager = new ServletManager();
    servletManager.setDefaultServlet(annotationServlet);
    servletManager.add("/favicon.ico", new DiscardServlet());

    HttpServer server = new HttpServer(PORT, servletManager);
    server.start();
  }

}
