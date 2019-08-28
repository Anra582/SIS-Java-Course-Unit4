package unit4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class CSVAdapterImpl<T extends CSVEditable> implements CSVAdapter<T> {

    private Class<T> t;
    private File inputFile;
    private LineParser lineParser;

    public CSVAdapterImpl(Class<T> t, File inputFile, LineParser lineParser) {

        this.t = t;
        this.inputFile = inputFile;
        this.lineParser = lineParser;
    }

    @Override
    public T read(int rowIndex) {
        try (Scanner scanner = new Scanner(new BufferedReader
                (new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8)))) {
            String line = null;

            for (int i = 0; i < rowIndex + 1; i++)
            {
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                }
            }

            List<String> stringList = lineParser.fromLine(line);
            T obj = t.newInstance();
            obj.fromArray(stringList);
            return obj;
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        /*
        Trying to use patterns for skip rows. Fail
         */
//        Pattern pattern = Pattern.compile(String.format("\\n{%s}", rowIndex));
//        if (scanner != null) {
//            scanner.skip(pattern);
//        }

        return null;
    }

    @Override
    public int append(T entry) {
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(inputFile.toPath(),
                StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            String line = lineParser.toLine(entry.getParamsAsArray());
            bufferedWriter.write(line + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Scanner scanner = new Scanner(new BufferedReader
                (new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8)))) {
            int countOfRows = -1;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                countOfRows++;
            }
            return countOfRows;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
