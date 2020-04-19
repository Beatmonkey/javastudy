package iwilllearnjava.strings;

/**
 * Created by david on 2/18/2017.
 */
public class Main {

    public static void main(String[] args) {
        int result;
        result = sum(1, 2, 6, 8, 6);
        System.out.println(result);
        boolean trueVariable = true;
        boolean falseVariable = false;
        boolean resultOfTrueAndFalse = and(trueVariable, falseVariable);
        System.out.println(resultOfTrueAndFalse);
    }

    public static int sum(int... numbers) {
        int result = 0;
        for (int number : numbers) {
            System.out.println(number);
            result = result + number;
        }
        return result;
    }

    public static boolean and(boolean a, boolean b) {
        return a && b;
    }
}
