import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyFirstMavenTest1 {

    @Test
    public void MyTest1(){
        assertTrue("5 is greater then 4", 5 > 4);
    }

    @Test
    public void MyTest2(){
        assertEquals("correct!", 1, 1);
    }

}
