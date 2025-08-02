package annotation.java;

public class DeprecatedClass {

  public void call1() {
    System.out.println("Deprecated class call1");
  }

  @Deprecated
  public void call2() {
    System.out.println("Deprecated class call2");
  }

  /**
   * since: 더이상 사용하지 않게 된 버전 정보
   * forRemoval: 미래 버전에 코드가 제거될 예정이다.
   */
  @Deprecated(since = "2.4", forRemoval = true)
  public void call3() {
    System.out.println("Deprecated class call3");
  }

}
