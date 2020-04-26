package test;

import adventofcode2015.Advent07;

import java.util.HashMap;

public class Advent07Test {
    public static void main(String[] args) {

        testProvide1();
        testProvide2();
        testProvide3();
        testProvide4();
        testProvide5();

    }

    static void testProvide1() {
        Advent07 adv = new Advent07();

        // Precondtions: 2 -> y Expected: hashmap contains key = y; value = 2;
        String[] test1Input = new String[1];

        test1Input[0] = "2 -> y";
        HashMap<String, Short> map = adv.process(test1Input);
        map.get("y");
//        assert map.get("y").equals(2) ;
        if (map.get("y") == 2) {
            System.out.println("Test testProvide1 is passed");
        } else {
            System.out.println("Test testProvide1 is failed");
        }

    }

    static void testProvide2() {
        Advent07 adv = new Advent07();


        // Precondtions: 2 -> y Expected: hashmap contains key = y; value = 2;
        String[] test1Input = new String[3];


        test1Input[0] = "2 -> y";
        test1Input[1] = "3 -> x";
        test1Input[2] = "x -> b";


        HashMap<String, Short> map = adv.process(test1Input);

        if (map.get("b") == 3 && map.get("x") == 3 && map.get("y") == 2) {
            System.out.println("Test testProvide2 is passed");
        } else {
            System.out.println("Test testProvide2 is failed");
        }
    }

    static void testProvide3() {
        Advent07 adv = new Advent07();


        // Precondtions: "x AND y -> c" Expected: hashmap contains key = с; value = 2;
        String[] test1Input = new String[5];


        test1Input[0] = "2 -> y";
        test1Input[1] = "3 -> x";
        test1Input[2] = "x -> b";
        test1Input[3] = "x AND y -> c";
        test1Input[4] = "1 AND y -> e";


        HashMap<String, Short> map = adv.process(test1Input);

        if (map.get("b") == 3 && map.get("x") == 3 && map.get("y") == 2 && map.get("c") ==2 && map.get("e") ==0 ) {
            System.out.println("Test testProvide3 is passed");
        } else {
            System.out.println("Test testProvide3 is failed");
        }
    }

    static void testProvide4() {
        Advent07 adv = new Advent07();


        // Precondtions: "x LSHIFT y -> c" Expected: hashmap contains key = с; value = 2;
        String[] test1Input = new String[4];


        test1Input[0] = "2 -> y";
        test1Input[1] = "3 -> x";
        test1Input[2] = "x LSHIFT 1 -> b";
        test1Input[3] = "y RHISFT 3 -> c";





        HashMap<String, Short> map = adv.process(test1Input);

        if (map.get("x") == 3 && map.get("y") == 2   && map.get("b") == 6 && map.get("c") == 0) {
            System.out.println("Test testProvide4 is passed");
        } else {
            System.out.println("Test testProvide4 is failed");
        }
    }

    static void testProvide5() {
        Advent07 adv = new Advent07();


        // Precondtions: "NOT x -> b" Expected: hashmap contains key = b; value = 65532;
        String[] test1Input = new String[3];


        test1Input[0] = "2 -> y";
        test1Input[1] = "3 -> x";
        test1Input[2] = "NOT x -> b";



        HashMap<String, Short> map = adv.process(test1Input);

        if (map.get("x") == 3 && map.get("y") == 2   && map.get("b") == -4 ) {
            System.out.println("Test testProvide5 is passed");
        } else {
            System.out.println("Test testProvide5 is failed");
        }
    }
}
