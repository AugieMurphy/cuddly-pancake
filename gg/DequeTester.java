/*
Gilvir Gill
APCS2 pd3
HW29 Streess is the Best
2017-04-05
*/

import java.util.Iterator;

//test Deque implementations by interacting with universally available object
//Instructions on screen should match input
//if any inputs do not show up, likely a toString() mistake somewhere
//THIS CLASS REQUIRES EXTENDING QUEUE AND ITERABLE AT THE LEAST TO RUN
public class DequeTester {
    //shorten sop:
    public static Object sop(Object s) {
        try {
            System.out.println(s.toString());
            return s;
        }
        catch (Exception e) {
            return null;
        }
    }
    //print factors of a number and return them in a deque
    public static Deque<Integer> printFactors(int num) {
        Deque<Integer> d = new DLDeque<Integer>();
        sop("Factors of " + num+ ", assembled inside out:");
        //let d1 be a deque containing the ordered factors of 30: 1, 2, 3, 5, 6, 10, 15, 30
        //all numbers equal to or less than the sqrt
        int cur = (int) Math.sqrt(num);
        while (cur > 0) {
            //if the number is a factor, add it to the left and add it's partner to the right
            if (num%cur == 0) {
                d.addFirst(cur);
                d.addLast(num/cur);
                sop(d);
            }
            cur--;
        }
        return d;
    }
    public static void main(String[] args) {
        //parse input:
        int length = 10;
        try {
            length = Integer.parseInt(args[0]);
        }
        catch (Exception e) {
        }
        sop("SUPER COOL TEST CASES \n\n\n\n----------");
        //create your deques:
        //INTEGER DEQUE:
        Deque<Integer> d1 = new DLDeque<Integer>();
        Deque<Integer> d2 = new DLDeque<Integer>();
        //try to type it into a regular queue:
        Queue<Integer> q1 = (Queue<Integer>) d2;
        //super deques:
        //this one allows for deques or queues of any object
        //xlint warning is the only way for this to work, since you can't type a Deque<Integer> into Deque<Object>
        @SuppressWarnings("unchecked")
        Deque<Queue> dd1 = new DLDeque<Queue>();
        //strongly typed:
        Deque<Deque<Integer>> dd2 = new DLDeque<Deque<Integer>>();
        //set d1 to factors of a random number:
        for (int i = 0; i < length; i++) {
            //random int:
            Integer num = (int) (Math.random()*10000);
            q1.enqueue(num);
            //use queue d2 to keep track of numbers:
            d1 = printFactors(num);
            //add this to both the strongly typed and weakly typed 2d qs
            dd1.enqueue(d1);
            dd2.enqueue(d1);
        }

        sop("\n\n\nAt this point, both dd1 and dd2 should have the same content. Lets test for equality and print both:");
        sop(Boolean.toString(dd1.toString().equals(dd2.toString())));

        sop("\nq1/d2 (same thing) contain the random numbers, while dd1 and dd2 contain a deque of their factors in parallel order");
        sop("Ensure that d2 and dd2 are the same length. If they are, parallelness was likely maintained");
        sop(Boolean.toString(dd2.size()==d2.size()));
        sop("Also ensure that size() works properly:");
        sop(dd2.size());
        sop("Lets just print the numbers with a for loop to see if it works");
        for (Integer i : d2) sop(i);
        for (Deque<Integer> fac: dd2) sop(fac);
        sop("\n\n");


        //ITR WORK: TIME TO REMOVE THE NONPRIMES:
        try {
            Iterator<Integer> numsIt = d2.iterator();
            Iterator<Deque<Integer>> factorsIt = dd2.iterator();

            //parellel iterators:
            Deque<Integer> cur;
            while (factorsIt.hasNext()&& numsIt.hasNext()) {
                sop(numsIt.next());
                cur = factorsIt.next();
                sop(cur.size() + ": "+ cur);
                //if the next nums has a length of 2, issa prime
                if (cur.size() != 2) {
                    numsIt.remove();
                    factorsIt.remove();
                }
            }
        }
        catch (Exception e) {
            sop("Uhoh! You didn't code an iterator. How'd you even get past compiling?");
        }

        sop("\n\nAt this point, d2 should only contain prime numbers. Let's see:");
        sop(d2);
    }
}
