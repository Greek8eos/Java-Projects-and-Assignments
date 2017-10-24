/**
 * Created by George Kountouris on 9/4/17 for Assignment 1.
 * Revised for Assignment 2 on: 9/12/17
 * CS 332 Mon/Wed 9:00-10:15am
 */
public class FindDup
{
    public static int findDup (int[] a, int[] b)
            throws NullPointerException, IllegalArgumentException
    /*
    // REVISED CONTRACT:
    //
    // Precondition: a not null;
    //               b not null
    //               There is some index i such that a[i] == b[i]
    //
    // Post-condition: return the first index i at which a[i] == b[i]
    //                 throws NullPointerException if a or b are null
    //                 throws IllegalArgumentException if there is not an index i such that a[i]==b[i];
    */
    {
        if (a==null || b==null)
        {
            throw new  NullPointerException(" Array a or array b is null");
        }

        int i=0;
        while(i<a.length && i<b.length)
        {
            if((a[i]==b[i])||(i==a.length-1)||(i==b.length-1))
            {
                break;
            }
            else
            {
                i++;
            }

        }

        if(a[i] != b[i])
        {
            throw new IllegalArgumentException("There must be an index i such that a[i]=b[i]");
        }
        return i;
    }

}
