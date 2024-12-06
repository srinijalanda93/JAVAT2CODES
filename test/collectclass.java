import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.*;
//collections--> class,collection -->interface

public class collectclass {
    public static void main(String[] args) {
        Collection collections = new ArrayList();
        // int val[]=new int[9];
        // val[1]=1;
        // val[2]="java"; //error
        /*
         * in java Object are parent all the inbuilt the class are inherited from the
         * object
         */
        // Object o[]=new Object[9]; //hetergenous ,but still it has fixed size,not
        // aligned with DS
        // int i = 1;
        collections.add(1);
        collections.add(1.4f);
        collections.add("srinija");
        collections.add(true);
        System.out.println(collections);
        // fetching the values using iterator-->implement interface
        // or while loop i.hasNext() -->i.next()
        // Iterator i=collections.iterator();
        // while(i.hasNext()){
        // System.out.println(i.next());
        // }
        /**
         * using of iterator we can mainpulate the data
         */

        /**
         * concept called enhanced for loop
         */

        for (Object i : collections) {
            System.out.println(i);
        }
        /**
         * Other way we use is stream API,lamda
         */
        // Add the elemenet in the frist index as the collection don't have these type
        // of concept using indexing
        // collection.add();
        List L = new ArrayList(); // child of the collection interface
        L.add(23);
        L.add(23.4f);
        L.add(1, 34);
        // shifting or the element can be done which is demerit during the inserting the
        // new element
        /**
         * when there is frequency usage of insert and delete we are not supposed to use
         * the List
         * The alternative way is linked list
         */

        /**
         * Generic concept we can store the value of those we can use
         */
        List<Integer> c = new ArrayList<Integer>();
        c.add(124);
        c.add(210);
        c.add(23);
        c.add(42);
        c.add(27);
        c.forEach(System.out::println);
        // sorting the elements based on the last digits
        Collections.sort(c);
        c.forEach(System.out::println);
        // take the number digit by last
        Iterator i = c.iterator();

        while (i.hasNext()) {
      //  int  a=  i.next()%10;
            System.out.println(i.next());
        }

    }

}
