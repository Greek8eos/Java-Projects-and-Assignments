/**
 * Created by George on 9/12/17.
 * Test code for FindDup Class. Test for the preconditions of findDup(int a[], int b[])
 */

import org.junit.Test;
import static org.junit.Assert.*;


public class FindDupTests
{

    @Test
    public void nullArrayTest()
    {
        {
            try {
                int a[]= new int[3];
                int b[]= new int[3];

                a=null;
                b=null;

                FindDup.findDup(a,b);

                fail("Expected an NullPointerException to be thrown");
            } catch(NullPointerException e)
            {
               return;
            }
        }
    }

    @Test
    public void indexesNotEqualTest()
    {
        try
        {
            int a[]={1,2,3};
            int b[]={-1,-2,-3};

            FindDup.findDup(a,b);
            fail("Expected an IllegalArgumentException to be thrown");
        }catch(IllegalArgumentException e)
        {
            return;
        }
    }

    @Test
    public void indexesEqualTest()
    {

        int a[]={1,2,3};
        int b[]={-5,4,3,6};
        int position= FindDup.findDup(a,b);

        if( position==2)
        {
            assertTrue(position==2);
        }
        else
        {
            fail("No matching index exists.");
        }


    }
}
