package unit4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class CSVAdapterImpl<T extends Author> implements CSVAdapter<T> {

    private Scanner scanner;
    private BufferedWriter bufferedWriter;

    public CSVAdapterImpl(File inputFile) {
        try {
            scanner = new Scanner(inputFile, String.valueOf(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            bufferedWriter = Files.newBufferedWriter(inputFile.toPath(), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T read(int rowIndex) {

        return null;
    }

    @Override
    public int append(T entry) {

        return 0;
    }
}
