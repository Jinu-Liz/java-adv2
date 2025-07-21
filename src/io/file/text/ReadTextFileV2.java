package io.file.text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadTextFileV2 {

  public static final String PATH = "temp/hello2.txt";

  public static void main(String[] args) throws IOException {
    String writeString = "abc\n가나다";
    System.out.println("== Write String ==");
    System.out.println(writeString);

    Path path = Paths.get(PATH);

    // 파일에 쓰기
    Files.writeString(path, writeString, UTF_8);

    // 파일에서 읽기
    /**
     * 이 경우, 파일의 내용을 한 번에 메모리에 올리기 때문에
     * 내용이 너무 많은 경우에 부담이 생길 수 있다.
     */
    System.out.println("== Read String ==");
    List<String> lines = Files.readAllLines(path, UTF_8);
    for (int i = 0; i < lines.size(); i++) {
      System.out.println((i + 1) + ": " + lines.get(i));
    }

    /**
     * 한 줄씩 메모리에 올린다.
     */
    Stream<String> lineStream = Files.lines(path, UTF_8);
    lineStream.forEach(System.out::println);
    lineStream.close();
  }

}
