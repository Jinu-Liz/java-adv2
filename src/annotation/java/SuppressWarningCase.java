package annotation.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SuppressWarningCase {

  @SuppressWarnings("unused")
  public void multipleWarning() {
    // 사용되지 않는 변수 경고 억제
    int unusedVariable = 10;
  }

  @SuppressWarnings("deprecation")
  public void deprecatedMethod() {
    Date date = new Date();
    int date11 = date.getDate();
  }

  @SuppressWarnings("rawtypes")
  public void uncheckedCast() {
    // 제네릭 타입 캐스팅 경고 억제, raw type 사용 경고
    List list = new ArrayList<>();

    List<String> stringList = (List<String>) list;
  }

  @SuppressWarnings("all")    // 모드 경고 억제
  public void suppressAllWarning() {
    Date date = new Date();
    int date11 = date.getDate();

    List list = new ArrayList<>();
    List<String> stringList = (List<String>) list;
  }
}
