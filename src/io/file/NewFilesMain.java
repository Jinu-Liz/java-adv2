package io.file;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class NewFilesMain {

  public static void main(String[] args) throws IOException {
    Path file = Path.of("temp/example.txt");
    Path directory = Path.of("temp/exampleDir");

    System.out.println("File exists: " + Files.exists(file));

    try {
      Files.createFile(file);
      System.out.println("File created");

    } catch (FileAlreadyExistsException e) {
      System.out.println("File already exists");

    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try {
      Files.createDirectory(directory);
    } catch (FileAlreadyExistsException e) {
      System.out.println(directory + " Directory already exists");

    } catch (IOException e) {
      throw new RuntimeException(e);
    }

//    Files.delete(file);
//    System.out.println("File deleted");

    System.out.println("Is regular file: " + Files.isRegularFile(file));
    System.out.println("File name: " + file.getFileName());
    System.out.println("File size: " + Files.size(file) + " bytes");

    Path newFile = Path.of("temp/newExample.txt");
    // 파일 덮어쓰기
    Files.move(file, newFile, StandardCopyOption.REPLACE_EXISTING);
    System.out.println("File moved/renamed");

    System.out.println("Last modified: " + Files.getLastModifiedTime(newFile));

    BasicFileAttributes attrs = Files.readAttributes(newFile, BasicFileAttributes.class);
    System.out.println("===== Attributes =====");
    System.out.println("Creation time: " + attrs.creationTime());
    System.out.println("Is directory: " + attrs.isDirectory());
    System.out.println("Is regular file: " + attrs.isRegularFile());
    System.out.println("Is symbolic link: " + attrs.isSymbolicLink());
    System.out.println("Size: " + attrs.size());
  }
}
