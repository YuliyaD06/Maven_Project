import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyFirstMavenTest {

    @Test
    public void MyTest1(){
        assertTrue("5 is greater then 4", 5 > 4);
    }

    @Ignore("Test is ignored as a fake")
    @Test
    public void MyTest2(){
        assertEquals("correct!", 1, 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void empty(){
        new ArrayList<Object>().get(0);
    }

}
