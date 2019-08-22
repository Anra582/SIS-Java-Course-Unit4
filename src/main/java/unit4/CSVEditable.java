package unit4;

public interface CSVEditable {
    CSVEditable fromLine(String line, String delimiter);
    String getLine(String delimiter);
}
