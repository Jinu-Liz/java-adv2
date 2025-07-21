package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class OldFileMain {

  public static void main(String[] args) throws IOException {
    File file = new File("temp/example.txt");
    File directory = new File("temp/exampleDir");

    // 파일 존재 여부 확인
    System.out.println("File exists: " + file.exists());

    // 새 파일 생성
    boolean created = file.createNewFile();
    System.out.println("File created: " + created);

    // 새 디렉토리 생성
    boolean dirCreated = directory.mkdir();
    System.out.println("Directory created: " + dirCreated);

    // 파일 삭제
//    boolean deleted = file.delete();
//    System.out.println("File deleted: " + deleted);

    // 파일인지 확인
    System.out.println("Is file: " + file.isFile());

    // 디렉토리인지 확인
    System.out.println("Is directory: " + directory.isDirectory());

    // 파일 또는 디렉토리 이름 확인
    System.out.println("File Name: " + file.getName());

    // 파일 크기를 바이트 단위로 반환
    System.out.println("File Size: " + file.length() + " bytes");

    // 파일의 이름을 변경하거나 이동
    File newFile = new File("temp/newExample.txt");
    boolean renamed = file.renameTo(newFile);
    System.out.println("File renamed: " + renamed);

    // 마지막으로 수정된 시간 반환
    long lastModified = newFile.lastModified();
    System.out.println("Last modified: " + new Date(lastModified) );
  }
}
