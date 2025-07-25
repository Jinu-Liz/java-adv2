package charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.SortedMap;

public class AvailableCharsetsMain {
  public static void main(String[] args) {
    SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();
    for (String charsetName : stringCharsetSortedMap.keySet()) {
      System.out.println(charsetName + " : " + stringCharsetSortedMap.get(charsetName));
    }

    System.out.println("=====");

    // 문자로 조회(대소문자 구분X), MS949, ms949, x-windows-949
    Charset charset1 = Charset.forName("MS949");
    System.out.println("charset1 = " + charset1);

    // 별칭 조회
    Set<String> aliases = charset1.aliases();
    aliases.forEach(System.out::println);

    // UTF-8 문자로 조회
    Charset charset2 = Charset.forName("UTF-8");
    System.out.println("charset2 = " + charset2);

    // UTF-8 상수로 조회
    Charset utf8 = StandardCharsets.UTF_8;
    System.out.println("utf8 = " + utf8);

    // 시스템의 기본 Charset 조회
    Charset defaultCharset = Charset.defaultCharset();
    System.out.println("defaultCharset = " + defaultCharset);
  }
}
