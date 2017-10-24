/**
 * George Kountouris   CS332 Mon/Wed. 9-10:15AM
 * Last Modified: 10/23/17
 */
import java.util.*;
import java.lang.*;
public class AbsComp implements Comparator<Integer>
{
    @Override
    public int compare(Integer o1, Integer o2)
    {
        int val1,val2, comp;

        comp=0;

        val1=  Math.abs(o1);
        val2= Math.abs(o2);

        if(val1<val2)
        {
            comp= -1;
        }
        else if(val1> val2)
        {
            comp= 1;
        }
        else if(val1==val2)
        {
            comp= 0;
        }
        return comp;
    }

    public static void main(String[] args)
    {
        Set s1 = new HashSet<>();
        Set s2 = new TreeSet<>(new AbsComp());

        s1. add(-2);
        s1.add(1);
        s1.add(-1);

        s2.add(-2);
        s2.add(1);
        s2.add(-1);

        System.out.println(" HashSet size: "+s1.size()+" TreeSet size: "+s2.size() + " \n The two sets have different size because according to the contract \n" +
                "of Comparator, it should return a negative number if o1 < o2, a positive if o1 > O2, and 0 if o1 = o2. \nAn Absolute Comparator breaks" +
                "this part of the contract because it modifies o1 and o2 before it compares them and the absolute value of a number \n is not always equal to that number" +
                ". This can bee seen with s1 and s2. \n S2 uses an absolute comparator, so if  1 exists in s2 and the client tried to add -1, the absolute comparator" +
                " would find the absolute \n value of -1 which is 1. Then it would compare that to the 1 that is in the set, resulting in not adding the -1 to the set since\n " +
                "it believes that -1 exists in the set (absolute value comparator would return 0).");

    }
}
