package unit4;

import org.junit.Test;

import java.nio.file.Paths;

import static org.junit.Assert.*;

public class CSVAdapterImplTest {

    @Test
    public void read() {
        CSVAdapter<Author> csvAdapter= new CSVAdapterImpl(Paths.get(".").resolve("inputAuthors.csv").toFile());
    }

    @Test
    public void append() {
    }
}