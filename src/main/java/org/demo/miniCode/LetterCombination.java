package org.demo.miniCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {
    private Map<Character, char[]> map = new HashMap<>();
    private List<String> result = new ArrayList<>();

    public LetterCombination() {
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public String letterCombinationStageOne(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("the parameter( int[] numbers ) can't be null or empty.");
        }
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("the parameter( int[] numbers ) can't include negative integer.");
            }
            if (digits(number) > 1) {
                throw new IllegalArgumentException("the every element's digits of numbers can't greater than one.");
            }
        }

        String numbersString = numbersToString(numbers);
        combine("", numbersString);

        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s).append(' ');
        }
        if (result.size() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        result.clear();

        String resultString = sb.toString();
        System.out.println(resultString);
        return resultString;
    }

    public String letterCombinationStageTwo(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("the parameter( int[] numbers ) can't be null or empty.");
        }
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("the parameter( int[] numbers ) can't include negative integer.");
            }
            if (digits(number) > 2) {
                throw new IllegalArgumentException("the every element's digits of numbers can't greater than two.");
            }
        }


        String numbersString = numbersToString(numbers);
        combine("", numbersString);
        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s).append(' ');
        }
        if (result.size() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        result.clear();

        String resultString = sb.toString();
        System.out.println(resultString);
        return resultString;
    }

    private void combine(String nowStr, String numbersString) {
        int length = numbersString.length();
        if (length == 0) {
            result.add(nowStr);
            return;
        }
        char now = numbersString.charAt(0);
        char[] letters = map.get(now);

        while (true) {
            if (letters == null) {
                numbersString = numbersString.substring(1);
                length = numbersString.length();
                if (length == 0) {
                    result.add(nowStr);
                    return;
                }
                now = numbersString.charAt(0);
                letters = map.get(now);
            } else {
                break;
            }
        }

        for (char nowChar : letters) {
            combine(nowStr + nowChar, numbersString.substring(1));
        }
    }

    private String numbersToString(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number);
        }
        return sb.toString();
    }

    private int digits(int number) {
        int count = 0;
        if (number == 0) {
            return 1;
        } else {
            while (number > 0) {
                number = number / 10;
                count++;
            }
            return count;
        }
    }
}
