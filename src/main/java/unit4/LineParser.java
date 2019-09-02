package unit4;

import java.util.List;

public interface LineParser {
    List<String> fromLine(String line);
    String toLine(List<String> stringList);
}
