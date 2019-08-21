package unit4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class CSVAdapterImpl<T extends IAuthor> implements CSVAdapter<T> {

    private T t;
    private InputStream inputStream;
    private OutputStream outputStream;

    public CSVAdapterImpl(T t/*, InputStream inputStream, OutputStream outputStream*/) {

        this.t = t;
//        this.inputStream = inputStream;
//        this.outputStream = outputStream;

    }

    @Override
    public T read(int rowIndex) throws IllegalAccessException, InstantiationException {
        return (T) t.fromLine("dhbgk;kf");
    }

    @Override
    public int append(T entry) {
        return 0;
    }
}
