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

public class CSVAdapterImplPublisherTest {

    @ClassRule
    public static TemporaryFolder temporaryFolder = new TemporaryFolder();
    private static File file;
    private static final String delimiter = ";";
    private static CSVLineParser csvLineParser = new CSVLineParser(delimiter);

    @Before
    public void createFile() {
        try {
            file = temporaryFolder.newFile("TestFile.csv");
            BufferedWriter bufferedWriter = Files.newBufferedWriter(file.toPath(),
                    StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            bufferedWriter.write("Horns and Hooves" + delimiter + "Moscow" + delimiter + "100500");
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @After
    public void deleteFile() {
        file.delete();
    }

    @Test
    public void read() {
        CSVAdapter<Publisher> csvAdapt = new CSVAdapterImpl<>(Publisher.class, file, csvLineParser);
        Publisher publisher = csvAdapt.read(0);

        assertEquals("Horns and Hooves", publisher.getName());
        assertEquals("Moscow", publisher.getHeadOfficeLocation());
        assertEquals(100500, publisher.getCountOfContracts());
    }

    @Test
    public void append() {
        String name = "Graphomanianc";
        String headOfficeLocation = "Saint-Peterburg";
        int countOfContracts = 999999999;

        Publisher publisher = new Publisher(name, headOfficeLocation, countOfContracts);
        CSVAdapter<Publisher> csvAdapt = new CSVAdapterImpl<>(Publisher.class, file, csvLineParser);
        int row = csvAdapt.append(publisher);
        Publisher anotherPublisher = csvAdapt.read(row);
        assertEquals(name, anotherPublisher.getName());
        assertEquals(headOfficeLocation, anotherPublisher.getHeadOfficeLocation());
        assertEquals(countOfContracts, anotherPublisher.getCountOfContracts());
    }
}