/**
 * Created by George on 10/3/17.
 * CS 332 M/W 9:00m-10:15am
 */
import java.util.*;
//  GrowList is a mutable list that only gets longer.
public class MGrowList <E> {

    private Map<Integer, E> values;

    public MGrowList() {
        values = new HashMap<Integer, E>();
    }

    public MGrowList(int i) //for the SDL where the rep invariant fails
    {
        values = null;
    }

    public boolean repOk() //rep check method
    {
        // HashMaps dont allow duplicate keys so that takes care of itself
        // since the key is an integer, caller is not allowed to put a null as a key, so that takes care of that.

        if (values == null) {
            throw new NullPointerException("Map cannot be null");
        }

        return true;
    }

    // add to the end of the list
    public void add(E o) {
        values.put(size(), o);
    }

    public void sdlAdd(E o) //where the contract fails
    {
        values.put(0, o);
    }

    // number of values in list
    public int size() {
        return values.size();
    }

    // get ith value in list
    public E get(int i) {
        if (!inRange(i)) throw new IndexOutOfBoundsException("GrowList.get");
        return values.get(i);
    }

    // update ith value in list;  return previous value or null if none
    public E set(int i, E o) {
        if (!inRange(i)) throw new IndexOutOfBoundsException("GrowList.set");
        return values.put(i, o);
    }

    // private helper method
    private boolean inRange(int i) {
        return (i >= 0) && (i < size());
    }

    public String toString() {
        if (size() == 0) return "[]";
        String result = "[";
        for (int i = 0; i < size() - 1; i++) {
            result += values.get(i) + ",";
        }

        return result + values.get(size() - 1) + "]";
    }

    public static void main(String[] args) {
        MGrowList<String> list = new MGrowList<String>();

        System.out.println("list is:" + list);
        list.add("cat");
        System.out.println("list is:" + list);
        list.add("dog");
        System.out.println("list is:" + list);
        list.set(1, "bat");
        System.out.println("list is:" + list);


    }
}