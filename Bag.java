/*
    Last Modified: 10/17/17
    George Kountouris CS332 9:00am-10:15am
    G00928016   Assignment 7
 */
import java.util.*;

// See Liskov exercise 7.11
// This version is generified
public class Bag<E> {

    // rep: map each object to the count of that object in this
    // rep-inv:  range of map contains only positive integers
    // Example:  A bag of 2 cats and a dog is map = { cat=2, dog=1 }

    private Map<E, Integer> map;

    public Bag()
    {
        map = new HashMap<E, Integer>();
    }

    private boolean repOk()
    {
        int valid;
        valid=0;
        for(int i:map.values())
        {
           if(i < valid)
           {
               return false;
           }
        }

        return true;
    }

    // add 1 occurrence of e to this
    public void insert(E e)
    {
        if(!repOk())
        {
            throw new IllegalStateException(" rep was broken ");
        }
        if(map.containsKey(e))
        {
            map.put(e,map.get(e)+1);
        }
        else
        {
            map.put(e,1);
        }
        if(!repOk())
        {
            throw new IllegalStateException(" rep was broken ");
        }
    }

    // remove 1 occurrence of e from this
    public void remove(E e)
    {
        if(!repOk())
        {
            throw new IllegalStateException(" rep was broken ");
        }
        int val= map.get(e);

        if(val==1)
        {
            map.remove(e);
        }
        else
        {
            map.remove(e);
            val= val-1;
            map.put(e,val);
        }
        if(!repOk())
        {
            throw new IllegalStateException(" rep was broken ");
        }
    }

    // return true iff e is in this
    public boolean isIn(E e)
    {
        if(!repOk())
        {
            throw new IllegalStateException(" rep was broken ");
        }

        if( map.containsKey(e))
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    // return cardinality of this
    public int size()
    {
        return map.size();
    }

    // if this is empty throw ISE
    // else return arbitrary element of this
    public E choose()
    {
        if(!repOk())
        {
            throw new IllegalStateException(" rep was broken ");
        }

        if( map.isEmpty())
        {
            throw new IllegalStateException("this is empty");
        }
        else
        {
            if(!repOk())
            {
                throw new IllegalStateException(" rep was broken ");
            }
            return (E)map.keySet().toArray()[0];
        }

    }

    // conveniently, the <E,Integer> map is exactly the abstract state
    public String toString()
    {
        return map.toString();
    }

}
