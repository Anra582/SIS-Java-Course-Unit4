package unit4;

import org.junit.Test;

import java.nio.file.Paths;

import static org.junit.Assert.*;

public class CSVAdapterImplTest {

    @Test
    public void read() {
        CSVAdapter<Author> csvAdapt = new CSVAdapterImpl<Author>(Author.class);
        try {
            Author author = (Author) csvAdapt.read(0);
            System.out.println(author.getName());
            System.out.println(author.getBirthPlace());
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void append() {
    }
}