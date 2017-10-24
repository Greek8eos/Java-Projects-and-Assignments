/**
 * Created by George on 9/16/17. Assignment 3 for CS/SWE 332
 */

import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.junit.Assume.*;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import java.util.*;

@RunWith (Theories.class)

public class SetTheories
{
    private static int testGenerateCounter1 = 0;
    private static int testPassCounter1 = 0;
    private static int testGenerateCounter2 = 0;
    private static int testPassCounter2 = 0;
    private static int testGenerateCounter3 = 0;
    private static int testPassCounter3 =0;

    @DataPoints
    public static String[] str={"a","b","c",null};

    @DataPoints
    public static Set[] stringSets =
            {
                    new HashSet (Arrays.asList ("a","b","c")),
                    new HashSet (Arrays.asList ("c","hello","mouse")),
                    new HashSet (Arrays.asList ("a","cat", "mouse")),
                    new HashSet (Arrays.asList ("a","bike","boat","train")),
                    new HashSet (Arrays.asList ("b","cat","bike")),
                    null
            };

    @Theory public void UnionOfTwoSetsAndIntersectionOfOneOfSetsEqualsOneOfTheSets (Set<String> setA, Set<String> setB)
            /**
             * Let A, B, and C be sets. The union of A and B gives C.
             * The intersection between either A with C or B with C will yield A or B respectively if the following constraint is met:
	         * A and B cannot equal null.
             * This theory will be true for all possible data points as long as the above constraints are met.
             * For example, if A={1,2,3} and B={4,5,6}, then A∪B=C={1,2,3,4,5,6}. Then, C∩B={4,5,6}=B or C∩A={1,2,3}=A.
             * Tests Generated: 49  Tests Passed: 25
             */
    {
        testGenerateCounter1= testGenerateCounter1+1;
        System.out.println("Tests Generated: "+testGenerateCounter1); //to keep track of how many tests were generated

        assumeTrue (setA != null);
        assumeTrue (setB != null);


        Set<String> copySetA = new HashSet<>(setA);
        Set<String> copySetB = new HashSet<>(setB);

        copySetA.addAll(copySetB);                      //does union of setA with setB
        copySetA.retainAll(copySetB);                   // does intersection of union resulting set and setB

        assertTrue (copySetA.equals (copySetB));

        testPassCounter1=testPassCounter1+1;
        System.out.println("\n\n\nTests Passed: "+testPassCounter1+"\n\n\n" ); //to see how many tests passed
    }

    @Theory public void IntersectionIsTransitive (Set<String> setA, Set<String> setB, Set<String> setC,String s)
            /**
             *  Let A, B, and C be sets. The intersection of these sets is transitive if the following constraints are met:
        	 *  There exists a string that is in sets A, B, and C.
	         *  A, B, C are not null
	         *  A does not equal B
	         *  A does not equal C
	         *  B does not equal A
             *  This will be true for all possible sets as long as the constraints are met.
             *  For example, A={cat, dog, mouse} B={dog, wolf, bear} C={dog}. If,A∩B={dog}  and B∩C={dog},then A∩C={dog}.
             *  Tests Generated: 1715 Tests Passed: 3
             */
    {

        testGenerateCounter2= testGenerateCounter2+1;
        System.out.println("Tests Generated2: "+testGenerateCounter2);

        assumeTrue(setA != null);  //verifies sets are not null
        assumeTrue(setB != null);
        assumeTrue(setC != null);

        assumeTrue(!(setA.equals(setB)));    //makes sure that sets are not duplicates
        assumeTrue(!(setB.equals(setC)));
        assumeTrue(!(setC.equals(setA)));

        assumeTrue(setA.contains(s));  //makes sure a string exists in all three sets
        assumeTrue(setB.contains(s));
        assumeTrue(setC.contains(s));

        Set<String> copySetAIntersect= new HashSet<>(setA);  // creates a copy of setA so setA intersect setB is possible
        Set<String> copySetBIntersect= new HashSet<>(setB);  // creates a copy of setB so setB intersect setC is possible
        Set<String> copySetC= new HashSet<> (setC);

        copySetAIntersect.retainAll(setB);  //computes setA intersect setB

        copySetBIntersect.retainAll(copySetC);  //computes SetB intersect SetC

        setA.retainAll(setC);  //computes SetA intersect Set C

        assumeTrue(copySetBIntersect.equals(copySetAIntersect));
        assertTrue(setA.equals(copySetBIntersect));

        testPassCounter2= testPassCounter2 + 1;
        System.out.println("\n\n\nTests Passed2: "+testPassCounter2+"\n\n\n");

    }

    @Theory public void addDoesNotChangeSet(Set<String> setA, String s)
            /**
             * Let A be a set and S be an arbitrary element. Adding an element to a set will always
             * yield the same set if the following constraints are met:
	         * A cannot equal null
	         * A contains the element S
             * This will always work if the above constraints are met. For example, if A={a, b, c, d, e, f, g, h, null}
             * and S=f, then adding f to A yields: A=={a, b, c, d, e, f, g, h, null}.
             * Tests Generated: 35  Tests Passed: 5
             */
    {
        testGenerateCounter3= testGenerateCounter3+1;
        System.out.println("Tests Generated3: "+testGenerateCounter3);

        assumeTrue(setA!=null);         //makes sure set is not null
        assumeTrue(setA.contains(s));       // makes sure set contains the string that will be added

        Set<String> setACopy= new HashSet<>(setA);

        setACopy.add(s);

        assertTrue(setA.equals(setACopy));   //checks to see if sets are equal to eachother

        testPassCounter3= testPassCounter3 + 1;
        System.out.println("\n\n\nTests Passed3: "+testPassCounter3+"\n\n\n");

    }

}
