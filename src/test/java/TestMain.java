import com.gumtree.tasks.domain.Person;
import com.gumtree.tasks.process.InputProcessor;
import org.joda.time.format.DateTimeFormat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
    public void testCount() throws IOException {
        List<Person> persons = inputProcessor.process(inputStream);
        assertEquals(5,persons.size());
    }

    @Test
    public void testBill() throws IOException {
        List<Person> persons = inputProcessor.process(inputStream);
        Person bill = persons.get(0);
        assertEquals("Bill McKnight",bill.getFullName());
        assertEquals("Male",bill.getGender());
        assertEquals("16/03/77",bill.getDateOfBirth().toString(DateTimeFormat.forPattern("dd/MM/yy")));


    }
}
