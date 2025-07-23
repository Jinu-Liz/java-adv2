package network.tcp.autocloseable;

/**
 * try-with-resources가 해결해주는 문제
 * 2가지 핵심 문제
 * 1. close() 시점에 실수로 예외를 던지면, 이후 다른 자원을 닫을 수 없는 문제
 * 2. finally 블럭 안에서 자원을 닫을 때 예외가 발생하면, 핵심 예외가 finally에서 발생한 부가 예외로 바뀌면서 핵심예외가 사라지는 문제
 *
 * 4가지 부가 문제
 * 1. resource 변수를 선언하면서 동시에 할당할 수 없는 문제 (try, finally 코드 블록과 변수 스코프가 달라서)
 * 2. catch 이후에 finally 호출, 자원 정리가 조금 늦어지는 문제
 * 3. 개발자가 실수로 close()를 호출하지 않을 가능성이 있던 문제
 * 4. 개발자가 close() 호출 순서를 실수하여 생성 순서와 반대로 닫지 않는 문제.
 */
public class ResourceCloseMainV4 {

  public static void main(String[] args) {
    try {
      logic();
    } catch (CallException e) {
      System.out.println("CallException 예외 처리");

      // 핵심 예외 안에 이후 예외들을 담아준다.
      Throwable[] suppressed = e.getSuppressed();
      for (Throwable throwable : suppressed) {
        System.out.println("suppressedEx = " + throwable);
      }

      throw new RuntimeException(e);

    } catch (CloseException e) {
      System.out.println("CloseException 예외 처리");
      throw new RuntimeException(e);

    }
  }

  private static void logic() throws CallException, CloseException {
    try (ResourceV2 resource1 = new ResourceV2("resource1");
         ResourceV2 resource2 = new ResourceV2("resource2")) {
      resource1.call();
      resource2.callEx();
    } catch (CallException e) {
      System.out.println("ex: " + e);
      throw e;
    }

  }

}
