package adventofcode2015;

import java.util.HashMap;

public class Test {



    public static void main(String[] args) {
/*        123 -> x
        456 -> y
        x AND y -> d
        x OR y -> e
        x LSHIFT 2 -> f
        y RSHIFT 2 -> g
        NOT x -> h
        NOT y -> i*/

        int maxSignal = 65535;



//        123 -> x
        short x = 3;

//        456 -> y
        short y = 2;

//        x AND y -> d
        int d = (x & y);
        System.out.println(d);

//        x OR y -> e

        int e = (x | y);
        System.out.println(e);

//        x LSHIFT 2 -> f

        int f = (x << 1);
        System.out.println("f: " + f);

//        y RSHIFT 2 -> g

        int g = (y >> 3);
        System.out.println("RHISFT: " + g);

//        NOT x -> h

        int h = ~ x;
        System.out.println("H: " + h);

        System.out.println(maxSignal - x);

//        NOT y -> i*/
        int i = ~ y;
        System.out.println(maxSignal - y);

        System.out.println(x);
        System.out.println(y);













    }
}
