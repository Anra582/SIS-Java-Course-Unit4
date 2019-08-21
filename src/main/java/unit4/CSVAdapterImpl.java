package unit4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CSVAdapterImpl<T extends IAuthor> implements CSVAdapter<T> {

    private Class<T> t;
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;

    public CSVAdapterImpl(Class<T> t, FileInputStream fileInputStream, FileOutputStream fileOutputStream) {

        this.t = t;
        this.fileInputStream = fileInputStream;
        this.fileOutputStream = fileOutputStream;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T read(int rowIndex) throws IllegalAccessException, InstantiationException {
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        Scanner scanner = new Scanner(bufferedReader);

        Pattern pattern = Pattern.compile(String.format("\n{%s}", rowIndex));
        scanner.skip(pattern);

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            return (T) t.newInstance().fromLine(line);
        }
        return  null;
    }

    @Override
    public int append(T entry) {
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        String entryLine = entry.getLine();
        
        printWriter.println(entryLine);
        printWriter.close();


        return 0;
    }
}
