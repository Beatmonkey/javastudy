package iwilllearnjava.strings;

/**
 * Created by david on 2/19/2017.
 */
public class MainString {
    public static void main(String[] args) {
        char dollar = '$';
        int dollarNumber = dollar;
//        byte b = dollarNumber;
        long l = dollarNumber;
        short c = 131;
        byte a = (byte) c;
        long ll = 40;
        System.out.println(dollarNumber);
        System.out.println(a);
        char[] phrase = new char[10];
        phrase[0] = 'H';
        phrase[1] = 'e';
        phrase[2] = 'l';
        phrase[3] = 'l';
        phrase[4] = 'o';
        System.out.println(phrase);
        String s = "I will learn. will java will";
        System.out.println(findAnyMiddleWord(s, "learnt"));
    }

    public static int findAnyMiddleWord(String s, String word) {
        int countOfWordsThatMatters = countNumberOfWords(s, word);
        int numberOfWordsThatMatters = findNumberOfWordThatMatters(countOfWordsThatMatters);
        int indexOfWordThatMatters = findIndexOfWordThatMatters(s, word, numberOfWordsThatMatters);
        return indexOfWordThatMatters;
    }

    public static int countNumberOfWords(String s, String word) {
        int result = 0;
        int indexOfFirstWord = s.indexOf(word);
        while (indexOfFirstWord != -1) {
            result++;
            String next = s.substring(indexOfFirstWord + word.length());
            indexOfFirstWord = next.indexOf(word);
            s = next;
        }
        return result;
    }

    public static int findNumberOfWordThatMatters(int number) {
        if (number % 2 == 0) {
            return number / 2;
        } else {
            return (number + 1) / 2 - 1;
        }
    }

    public static String revert(String s) {
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length];

        for (int i = chars.length - 1, b = 0; i >= 0; i--) {
            char c = chars[i];
            result [b] = c;
            b++;
        }
        return new String (result);
    }


    public static int findIndexOfWordThatMatters(String s, String word, int number) {
        int accumulatedIndex = 0;
        int countOfOtryvanya = 0;
        int indexOfFirstWord = s.indexOf(word);
        accumulatedIndex += indexOfFirstWord;
        while (indexOfFirstWord != -1) {
            String next = s.substring(indexOfFirstWord + word.length());
            if (countOfOtryvanya == number) {
                return accumulatedIndex;
            }
            countOfOtryvanya++;
            accumulatedIndex += word.length() + next.indexOf(word);
            indexOfFirstWord = next.indexOf(word);
            s = next;
        }
        return -1;
    }


    public static int findMiddleWill(String s) {
        String will = "will";
        return findAnyMiddleWord(s, will);

    }

    public static String findAllLettersTillPoint (String s) {
        return findAllLettersTillChar(s, '.');
    }

    public static String findAllLettersTillChar(String s, char c) {
        return s.substring(0, s.indexOf(c));

    }
}

