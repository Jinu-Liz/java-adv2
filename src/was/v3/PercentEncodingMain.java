package was.v3;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PercentEncodingMain {

  public static void main(String[] args) throws UnsupportedEncodingException {
    String encode = URLEncoder.encode("가", UTF_8);
    System.out.println(encode);

    String decode = URLDecoder.decode(encode, UTF_8);
    System.out.println(decode);
  }
}
