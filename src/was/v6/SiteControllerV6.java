package was.v6;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;

public class SiteControllerV6 {

  public void site1(HttpRequest req, HttpResponse res) {
    res.writeBody("<h1>Site 1</h1>");
  }

  public void site2(HttpRequest req, HttpResponse res) {
    res.writeBody("<h1>Site 2</h1>");
  }
}
