/**
 * Created by George on 9/23/17.
 * Assignment 4  CS332 Mon-Wed  9:00-10:15am
 * Immutable Version of GrowList 
 */

import java.util.*;
//  GrowList is a mutable list that only gets longer.


public class GrowList <E>
{
    final Map<Integer,E> values;

    // constructor needed to initialize a copy of the list object
    private GrowList( Map<Integer,E> map)
    {
        this.values=new HashMap<Integer,E>(map);
    }

    //initializes empty list
    public GrowList()
    {
        this.values = new HashMap<Integer,E>();
    }

    // add to the end of the list
    public GrowList add(E o)
    {
       final GrowList<E> listCopy = new GrowList(values);
        listCopy.values.put(size(), o);
        return listCopy;
    }

    // number of values in list
    public int size()
    {
        return this.values.size();
    }

    // get ith value in list
    public E get(int i)
    {
        if (! inRange(i))
            throw new IndexOutOfBoundsException("GrowList.get");
        final GrowList<E> listCopy = new GrowList(values);
        return listCopy.values.get(i);
    }

    // update ith value in list;  return previous value or null if none
    public GrowList set(int i, E o)
    {
        if (! inRange(i))
            throw new IndexOutOfBoundsException("GrowList.set");
        final GrowList<E> listCopy = new GrowList(values);

        listCopy.values.put(i, o);
        return listCopy;
    }

    // private helper method
    private boolean inRange(int i)
    {
        return (i >= 0) && (i < size());
    }

    public String toString()
    {
        if (size() == 0) return "[]";
        String result = "[";
        for (int i = 0; i < size()-1; i++)
        {
            result += this.values.get(i) + ",";
        }
        return result + this.values.get(size() - 1) + "]";
    }

    public static void main(String[] args)
    {
        GrowList<String> list = new GrowList<String>();

        System.out.println("list is:" + list);
        list=list.add("cat");
        System.out.println("list is:" + list);
        list=list.add("dog");
        System.out.println("list is:" + list);
        list=list.set(1,"bat");
        System.out.println("list is:" + list);
    }
}
