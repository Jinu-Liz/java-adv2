package annotation.basic;

import util.MyLogger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// 기본적으로 제공하는 타입들만 반환 가능

/**
 * RetentionPolicy - 어노테이션의 생존 기간을 지정
 * SOURCE : 소스 코드에만 남아있다. 컴파일 시점에 제거된다.
 * CLASS : 컴파일 후, class파일까지는 남아있지만 자바 실행 시점에 제거된다. (기본값)
 * RUNTIME : 자바 실행 중에도 남아있다. 대부분 이 설정 사용.
 *
 * ElementType - 어노테이션을 사용할 수 있는 곳
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AnnoElement {

  String value();

  int count() default 0;

  String[] tags() default {};

  // MyLogger data();  // 다른 타입은 적용X
  Class<? extends MyLogger> annoData() default MyLogger.class;  // 클래스 정보는 가능

}
