/**
 * Created by George on 10/3/17.
 */
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class MGrowListTests
{
    private MGrowList<String> list;

    @After
    public void reset()
    {
        list = null; //resets list to null so it can be used fresh for next test.
    }

    @Test public void repOk()
    {
        list= new MGrowList<String>();
        assertTrue(list.repOk());
        list.add("rock");
        assertTrue(list.repOk());
        list.add("bottom");
        assertTrue(list.repOk());

    }

    @Test public void repOkFail()
    {
        int sdl=0;
        list= new MGrowList<String>(0);


        try
        {
            assertTrue(list.repOk());
            fail("Expected an NullPointerException to be thrown");
        }
        catch(NullPointerException e)
        {
            return;
        }

    }

    @Test public void contractFail()
    {
        list= new MGrowList<String>();

        list.add("cat");
        assertTrue(list.repOk());
        list.add("dog");
        assertTrue(list.repOk());
        list.sdlAdd("fish");

        assertFalse(list.toString().equals("[cat,dog,fish]"));
    }
}
