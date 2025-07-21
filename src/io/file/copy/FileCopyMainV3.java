package io.file.copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileCopyMainV3 {

  public static void main(String[] args) throws IOException {
    long start = System.currentTimeMillis();

    Path source = Path.of("temp/copy.dat");
    Path target = Path.of("temp/copy_new.dat");

    /**
     * 지금까지는 파일을 복사할 때,
     * 파일(copy.dat) -> 자바(byte) -> 파일(copy_new.dat)의 과정을 거쳤다.
     * 이 과정들은 파일의 데이터를 자바로 불러온 후, 해당 데이터를 다시 파일에 전달해야 한다.
     *
     * 그러나 Files.copy()는 운영체제의 파일 복사 기능을 사용한다.
     * 따라서, 중간 과정이 생력된다.
     * 파일(copy.dat) -> 파일(copy_new.dat)
     */
    Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

    long end = System.currentTimeMillis();

    System.out.println("Time taken: " + (end - start) + "ms");
  }
}
