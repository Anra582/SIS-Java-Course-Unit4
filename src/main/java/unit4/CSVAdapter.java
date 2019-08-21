package unit4;

import java.io.FileNotFoundException;

public interface CSVAdapter<T> {
    T read(int rowIndex) throws IllegalAccessException, InstantiationException;
    int append(T entry) throws FileNotFoundException;
}
