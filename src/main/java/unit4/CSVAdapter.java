package unit4;

public interface CSVAdapter<T> {
    T read(int rowIndex);
    int append(T entry);
}
