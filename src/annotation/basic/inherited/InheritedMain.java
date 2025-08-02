package annotation.basic.inherited;

import java.lang.annotation.Annotation;

/**
 * 클래스 상속은 부모 클래스의 속성과 메서드를 상속받기 때문에 논리적 기반이 있지만,
 * 인터페이스는 메서드의 시그니처만 정의하고 상태나 행위를 가지지 않기 때문에 개념이 맞지 않는다.
 *
 * 또한 인터페이스는 다중 구현이 가능하기 때문에 인터 페이스 간에 충돌이나 모호한 상황이 발생할 수 있다.
 *
 * 따라서 클래스 상속에만 적용된다.
 */
public class InheritedMain {

  public static void main(String[] args) {
    print(Parent.class);
    print(Child.class);
    print(TestInterface.class);
    print(TestInterfaceImpl.class);
  }

  private static void print(Class<?> clazz) {
    System.out.println("class: " + clazz);
    Annotation[] annotations = clazz.getAnnotations();
    for (Annotation annotation : annotations) {
      System.out.println(" - " + annotation.annotationType().getSimpleName());
    }

    System.out.println();
  }

}
