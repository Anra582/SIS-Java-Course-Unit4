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
    private File inputFile;

    public CSVAdapterImpl(Class<T> t, File inputFile) {

        this.t = t;
        this.inputFile = inputFile;
//        this.fileInputStream = fileInputStream;
//        this.fileOutputStream = fileOutputStream;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T read(int rowIndex) throws IllegalAccessException, InstantiationException {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        Scanner scanner = null;
        scanner = new Scanner(bufferedReader);   //inputFile.toPath(), String.valueOf(StandardCharsets.UTF_8));

//        Pattern pattern = Pattern.compile(String.format("\n{%s}", rowIndex));
//        if (scanner != null) {
//            scanner.skip(pattern);
//        }
        String line = null;

        if (scanner != null) {
            for (int i = 0; i < rowIndex + 1; i++)
            {
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                }
            }
            return (T) t.newInstance().fromLine(line);
        }
        return null;
    }

    @Override
    public int append(T entry) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream("Authors.csv", true));
        String entryLine = entry.getLine();

        printWriter.println(entryLine);
        printWriter.close();


        return 0;
    }
}
