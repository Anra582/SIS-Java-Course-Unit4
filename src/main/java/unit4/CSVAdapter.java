package unit4;

public interface CSVAdapter<T> {
    T read(int rowIndex) throws IllegalAccessException, InstantiationException;
    int append(T entry);
}
