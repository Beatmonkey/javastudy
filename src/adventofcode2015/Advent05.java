package adventofcode2015;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 4/6/2017.
 */
public class Advent05 {
    public static void main(String[] args) {
        String[] fileLines = FileUtils.readFromFile("/Users/macbookpro13/Desktop/Shares/iwilllearnjava/src/main/resources/Input_05.txt");
        List<String> niceStrings = new ArrayList();
        char[] vowelChars = {'a', 'e', 'i', 'o', 'u'};
        for (String fileLine : fileLines) {
            char[] chars = fileLine.toCharArray();
            int howMuchSovpadenie = 0;
            for (int i = 0; i < chars.length; i++) {
                char currentChar = chars[i];
                for (char vowelChar : vowelChars) {
                    if (vowelChar == currentChar) {
                        // its a vowel!!! yay
                        howMuchSovpadenie++;
                        break;
                    }
                }


            }

            // at least three vowels exist in the string
            boolean hasThreeVowels = false;
            if (howMuchSovpadenie >= 3) {
                hasThreeVowels = true;
                // YAYAYAYAYAYA!!!
            }

            // It contains at least one letter that appears twice in a row
            boolean hasDoubleLetter = false;
            for (int i = 0; i < chars.length - 1; i++) {
                char currentChar = chars[i];
                char nextChar = chars[i + 1];
                if (currentChar == nextChar) {
                    hasDoubleLetter = true;
                    break;

                }

            }

            // It does not contain the strings ab, cd, pq, or xy
            boolean hasNoSpecificStrings = false;
            if (!fileLine.contains("ab") && !fileLine.contains("cd") && !fileLine.contains("pq") && !fileLine.contains("xy")) {
                hasNoSpecificStrings = true;

            }


            // It contains at least one letter that appears twice in a row
            boolean hasTwoPairLetters = false;
            for (int i = 0; i < chars.length - 4; i++) {
                char currentChar = chars[i];
                char nextChar = chars[i + 1];
                if (currentChar == nextChar) {
                    hasTwoPairLetters = true;
                    break;

                }

            }


            if (hasThreeVowels && hasDoubleLetter && hasNoSpecificStrings ) {
                niceStrings.add(fileLine);
            }

        }

        System.out.println(niceStrings.size());
    }

}
