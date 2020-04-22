package adventofcode2015;

import java.math.BigInteger;
import java.security.MessageDigest;


public class Advent04 {
    public static String getHash(String str) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes("UTF-8"));
        String s2 = new BigInteger(1, md.digest()).toString(16);
        while (s2.length() < 32) {
            s2 = "0" + s2;
        }
        return s2;
    }

    public static void main(String[] args) throws Exception {
        final String input = "yzbqklnj";
        int increment = 0;
        String key = input;
        String partOfkey = getHash(key).substring(0,6);
        System.out.println(getHash(key));
        System.out.println(partOfkey);

        while (!partOfkey.equals("000000")) {
            key = input + increment;
            increment ++;
            partOfkey = getHash(key).substring(0,6);
//            System.out.println(getHash(key));
//            System.out.println(partOfkey);
        }
        System.out.println(key);


    }
}
