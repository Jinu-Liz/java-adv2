package annotation.java;

public class OverrideMain {

  static class A {
    public void call() {
      System.out.println("A.call");
    }
  }

  static class B extends A {
    @Override   // 메서드명이 다르면 컴파일러가 오류를 터트림.
    public void call() {
      System.out.println("B.call");
    }
  }

  public static void main(String[] args) {
    A a = new B();
    a.call();
  }
}
