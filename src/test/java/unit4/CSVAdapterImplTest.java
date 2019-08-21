package unit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class CSVAdapterImplTest {

    @Test
    public void read() throws FileNotFoundException {

        File tempFile = Paths.get("Authors.csv").toFile();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(tempFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        CSVAdapter<Author> csvAdapt = new CSVAdapterImpl<Author>(Author.class, tempFile);
        try {
            Author author = (Author) csvAdapt.read(0);
            System.out.println(author.getName());
            System.out.println(author.getBirthPlace());
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void append() throws FileNotFoundException {
        File tempFile = Paths.get("Authors.csv").toFile();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(tempFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Author author = new Author("Howdy", "Partner");
        CSVAdapter<Author> csvAdapt = new CSVAdapterImpl<Author>(Author.class, tempFile);
        csvAdapt.append(author);


    }
}