package io.buffered;

public class BufferedConst {

    public static final String FILE_NAME = "temp/buffered.dat";

    public static final int FILE_SIZE = 10 * 1024 * 1024;   // 10MB

    /**
     * 디스크나 파일 시스템에서 데이터를 읽고 쓰는 기본 단위가
     * 보통 4KB / 8KB이다.
     * 따라서, 8KB이상으로 버퍼 사이즈를 늘려도 속도에 차이가 없다.
     */
    public static final int BUFFER_SIZE = 8192; // 8KB

}
