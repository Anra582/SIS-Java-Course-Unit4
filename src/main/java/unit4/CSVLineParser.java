package unit4;

import java.util.Arrays;
import java.util.List;

public class CSVLineParser implements LineParser {
    private String delimiter;

    public CSVLineParser(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public List<String> fromLine(String line) {
        return Arrays.asList(line.split(delimiter));
    }

    @Override
    public String toLine(List<String> stringList) {
        return String.join(delimiter, stringList);
    }
}
