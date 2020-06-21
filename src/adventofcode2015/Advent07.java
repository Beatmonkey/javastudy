package adventofcode2015;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Advent07 {
    final static short maxSignal = (short) 65535;
    final static int totalStrings = 335;
    final static short a =3;

    public HashMap<String, Short> wiresWithSignals = new HashMap<>();






    public static void main(String[] args) {
        String[] fileLines = FileUtils.readFromFile("/Input_07.txt");



        Advent07 adv1 = new Advent07();
        HashMap result = adv1.process(fileLines);

        System.out.println(result.get("a"));






    }

    public HashMap<String, Short> process(String[] input) {




        Pattern and = Pattern.compile("(^\\D.*|\\d.*) (AND) (\\D.*|\\d.*) -> (\\D.*)");
        Pattern or = Pattern.compile("(^\\D.*|\\d.*) (OR) (\\D.*|\\d.*) -> (\\D.*)");
        Pattern rshift = Pattern.compile("(^\\D.*|\\d.*) (RSHIFT) (\\D.*|\\d.*) -> (\\D.*)");
        Pattern lshift = Pattern.compile("(^\\D.*|\\d.*) (LSHIFT) (\\D.*|\\d.*) -> (\\D.*)");
        Pattern not = Pattern.compile("NOT (\\D.*) -> (\\D.*)");
        Pattern provide = Pattern.compile("(^\\d*|[a-z].*) -> (\\D)$");


            for (String fileLine : input) {
                Matcher andM = and.matcher(fileLine);
                Matcher orM = or.matcher(fileLine);
                Matcher rhsiftM = rshift.matcher(fileLine);
                Matcher lhsiftM = lshift.matcher(fileLine);
                Matcher notM = not.matcher(fileLine);
                Matcher provideM = provide.matcher(fileLine);

                if (andM.matches()) {
                    String signalString1 = andM.group(1);
                    String signalString2 = andM.group(3);
                    String wireName = andM.group(4);
                    if (isNumber(signalString1)) {
                        short signal1 = Short.valueOf(signalString1);
                        short signal2 = getValueOrZero(signalString2);
                        short signal = bitwiseAND(signal1, signal2);
                        wiresWithSignals.put(wireName, signal);
                    } else  {
                        short signal1 = getValueOrZero(signalString1);
                        short signal2 = getValueOrZero(signalString2);
                        short signal = bitwiseAND(signal1, signal2);
                        wiresWithSignals.put(wireName, signal);
                    }

                } else if (orM.matches()) {
                    String signalString1 = orM.group(1);
                    String signalString2 = orM.group(3);
                    String wireName = orM.group(4);
                    short signal1 = getValueOrZero(signalString1);
                    short signal2 = getValueOrZero(signalString2);
                    short signal = bitwiseOR(signal1, signal2);
                    wiresWithSignals.put(wireName, signal);


                } else if (rhsiftM.matches()) {
                    String signalString1 = rhsiftM.group(1);
                    short shiftValue = Short.valueOf(rhsiftM.group(3));
                    String wireName = rhsiftM.group(4);
                    Short signal1 = getValueOrZero(signalString1);
                    short signal = rShift(signal1, shiftValue);
                    wiresWithSignals.put(wireName, signal);


                } else if (lhsiftM.matches()) {
                    String signalString1 = lhsiftM.group(1);
                    short shiftValue = Short.valueOf(lhsiftM.group(3));
                    String wireName = lhsiftM.group(4);
                    Short signal1 = getValueOrZero(signalString1);
                    short signal = lShift(signal1, shiftValue);
                    wiresWithSignals.put(wireName, signal);


                } else if (notM.matches()) {
                    String signalString = notM.group(1);
                    String wireName = notM.group(2);
                    Short signal = bitwiseNot(getValueOrZero(signalString));
                    wiresWithSignals.put(wireName, signal);


                } else if (provideM.matches()) {
                    String signalString = provideM.group(1);
                    String wireName = provideM.group(2);
                    if (isNumber(signalString)) {
                        short signal = Short.valueOf(signalString);
                        wiresWithSignals.put(wireName, signal);
                    } else {
                        Short signal = getValueOrZero(signalString); // TODO: here can be null, need to think in future how to handle this
                        wiresWithSignals.put(wireName, signal);
                    }

                }




            }




         return wiresWithSignals;
    }




    static boolean isNumber(String string) {
        if (string == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(string);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;

    }

    public short getValueOrZero(String pattern) {
        Short value = wiresWithSignals.get(pattern);
        if (value == null) {
            wiresWithSignals.put(pattern, (short) 0);
            value = 0;

        }
        return value;
    }







    public static short bitwiseAND(short a, short b) {

        return (short) (a & b);

    }

    public static short bitwiseNot(short a) {


        return (short) ~a;

    }

    public static short bitwiseOR(short a, short b) {

        return (short) (a | b);

    }

    public static short lShift(short a, short b) {



        return (short) (a << b);

    }

    public static short rShift(short a, short b) {

        return (short) (a >> b);

    }
}









