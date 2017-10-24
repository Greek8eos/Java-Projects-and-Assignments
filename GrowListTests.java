/**
 * Created by George on 9/25/17.
 * Test Cases for Immutable version of GrowList Class
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GrowListTests
{
    private GrowList<String> list;
    @Before
    public void setUp()
    {
        list = new GrowList<String>();
    }

    @After
    public void reset()
    {
        list = null; //resets list to null so it can be used fresh for next test.
    }

    @Test
    public void addToListTest()
    {
        list=list.add("Hello");

        assert(list.toString().equals("[Hello]"));

    }

    @Test
    public void setToListTest()
    {
        list=list.add("Hello");
        list=list.add("World");

        list=list.set(1,"Everyone");

        assert(list.toString().equals("[Hello,Everyone]"));
    }

    @Test
    public void inRangeTest()
    {
        list=list.add("Hello");
        list=list.add("World");

        assertTrue(list.size()==2);
    }
}
