package unit4;

public interface CSVAdapter<T extends Author> {
    T read(int rowIndex);
    int append(T entry);
}
