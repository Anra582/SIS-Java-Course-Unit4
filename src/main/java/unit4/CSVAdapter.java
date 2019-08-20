package unit4;

public interface CSVAdapter<T extends IAuthor> {
    T read(int rowIndex);
    int append(T entry);
}
