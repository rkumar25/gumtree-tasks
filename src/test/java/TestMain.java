import com.gumtree.tasks.Main;
import com.gumtree.tasks.domain.Person;
import com.gumtree.tasks.process.InputProcessor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sameer on 25/01/2015.
 */
public class TestMain {

    InputProcessor inputProcessor;

    InputStream inputStream;

    @Before
    public void setUp() {
        inputStream = this.getClass().getResourceAsStream("/input.csv");
        inputProcessor = new InputProcessor();
    }

    @After
    public void tearDown() throws IOException {
        inputStream.close();
    }

    @Test
    public void noOfMales() throws IOException {
        List<Person> persons = inputProcessor.process(inputStream);
        Main main = new Main(persons);
        assertEquals(3, main.getCountOfMales());
    }

    @Test
    public void oldestPerson() throws IOException {
        List<Person> persons = inputProcessor.process(inputStream);
        Main main = new Main(persons);
        assertEquals("Wes Jackson", main.getOldestPerson().getFullName());
    }

    @Test
    public void daysBillOlderThanPaul() throws IOException {
        List<Person> persons = inputProcessor.process(inputStream);
        Main main = new Main(persons);
        assertEquals(2862, main.daysByWhichBillIsOlderThanPaul());

    }



}
