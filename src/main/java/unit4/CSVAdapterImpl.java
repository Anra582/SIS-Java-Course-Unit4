package unit4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class CSVAdapterImpl<T extends IAuthor> implements CSVAdapter<T> {

    private Scanner scanner;
    private BufferedWriter bufferedWriter;
    private File inputFile;

    public CSVAdapterImpl(File inputFile) {


        try {
            bufferedWriter = Files.newBufferedWriter(inputFile.toPath(), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T read(int rowIndex) {
        try {
            scanner = new Scanner(inputFile, String.valueOf(StandardCharsets.UTF_8));

            String stringPattern = String.format("(\n){%s}", rowIndex);

            scanner.skip(stringPattern);

            if(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                return null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int append(T entry) {

        return 0;
    }
}
