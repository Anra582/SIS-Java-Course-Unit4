package unit4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class CSVAdapterImpl<T extends IAuthor> implements CSVAdapter<T> {

    private Class<T> t;
    private File inputFile;

    public CSVAdapterImpl(Class<T> t, File inputFile) {

        this.t = t;
        this.inputFile = inputFile;
    }

    @SuppressWarnings("unchecked")
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
            scanner.close();

            return (T) t.newInstance().fromLine(line);
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
            bufferedWriter.write(entry.getLine() + "\n");
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
