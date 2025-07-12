package io.buffered;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.*;

public class CreateFileV1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        /**
         * OS의 시스템 콜을 통해 파일을 읽거나 쓰는 명령어를 전달.
         * 이는 상대적으로 무거운 작업이다.이를 1000만 번 반복.
         * 따라서 매우 느려진다.
         */
        for (int i = 0; i < FILE_SIZE; i++) {
            fos.write(1);   // 단순 반복 저장
        }
        fos.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File created: " + FILE_NAME);
        System.out.println("File size: " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
