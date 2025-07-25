package io.text;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV3 {

  public static void main(String[] args) throws IOException {
    String writeString = "ABC";
    System.out.println("write String : " + writeString);

    /**
     * 파일에 쓰기
     * FileOutputStream fos = new FileOutputStream(FILE_NAME);
     * OutputStreamWriter osw = new OutputStreamWriter(fos, UTF_8);
     *
     * 이 두 라인을 합친 것과 동일.
     */
    FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
    fw.write(writeString);
    fw.close();

    // 파일에서 읽기
    StringBuilder content = new StringBuilder();
    FileReader fr = new FileReader(FILE_NAME, UTF_8);
    int ch;
    while ((ch = fr.read()) != -1) {
      content.append((char) ch);
    }
    fr.close();

    String str = content.toString();
    System.out.println("read string = " + str);
  }
}
