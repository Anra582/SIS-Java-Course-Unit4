package unit4;

import org.junit.Test;

import java.nio.file.Paths;

import static org.junit.Assert.*;

public class CSVAdapterImplTest {

    @Test
    public void read() {
        CSVAdapter<Author> csvAdapt = new CSVAdapterImpl<Author>(new Author());
        try {
            System.out.println("Hello there");
            Author author = (Author) csvAdapt.read(0);
            System.out.println(author.getName());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void append() {
    }
}