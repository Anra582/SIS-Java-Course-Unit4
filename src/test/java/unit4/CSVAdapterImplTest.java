package unit4;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import static org.junit.Assert.assertEquals;

public class CSVAdapterImplTest {

    @ClassRule
    public static TemporaryFolder temporaryFolder = new TemporaryFolder();
    private static File file;

    @Before
    public void createFile() {
        try {
            file = temporaryFolder.newFile("TestFile.csv");
            BufferedWriter bufferedWriter = Files.newBufferedWriter(file.toPath(),
                    StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            bufferedWriter.write("Лев Николаевич Толстой;Ясная Поляна");
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @After
    public void deleteFile() {
        file.delete();
    }

    @Test
    public void read() {
        CSVAdapter<Author> csvAdapt = new CSVAdapterImpl<>(Author.class, file);
        Author author = csvAdapt.read(0);

        assertEquals("Лев Николаевич Толстой", author.getName());
        assertEquals("Ясная Поляна", author.getBirthPlace());
    }

    @Test
    public void append() {
        String name = "Someone";
        String birthPlace = "Somewhere";

        Author author = new Author(name, birthPlace);
        CSVAdapter<Author> csvAdapt = new CSVAdapterImpl<>(Author.class, file);
        int row = csvAdapt.append(author);
        Author anotherAuthor = csvAdapt.read(row);
        assertEquals(name, anotherAuthor.getName());
        assertEquals(birthPlace, anotherAuthor.getBirthPlace());
    }
}