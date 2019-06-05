package com.kamlesh.trial.algo.string;

import java.util.*;

public class ShortestSubstring {

    public static void main( String... args) {

        String str = "ThisIsATestString";
        String pattern = "TisT";
        System.out.println("Answer: " + findShortestSubString(str, pattern));
    }

    public static String findShortestSubString(String str, String pattern) {
        int strLenght = str.length();
        List<String> subs = new LinkedList<String>();

        int[] patternCountMap = convertToCharCountMap(pattern);

        if (strLenght < pattern.length()) {
            return "";
        }

        // all substrings
        for (int i = 0; i < strLenght; i++ ) {
            for (int j = i + 1; j <= strLenght; j++) {
                String substr = str.substring(i, j);
                if (pattern.length() <= substr.length()) {
                    subs.add(str.substring(i, j));
                }
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<String>(subs.size(), Comparator.comparing(String::length));

        for (String sub: subs) {
            if (ifSubStringContainsPattern(sub, patternCountMap, pattern)) {
                pq.add(sub);
            }
        }

        return pq.poll();
    }

    private static int[] convertToCharCountMap(String str) {
        int[] hash = new int[256];
        for (int i = 0; i < str.length(); i++) {
            hash[str.charAt(i)]++;
        }
        return hash;
    }

    private static boolean ifSubStringContainsPattern(String str, int[] patternCountMap, String pattern) {
        int[] strCountMap = convertToCharCountMap(str);

        for (int i = 0; i < pattern.length(); i++ ) {
            int ch = pattern.charAt(i);
            if (strCountMap[ch] < patternCountMap[ch]) {
                return false;
            }
        }
        return true;
    }

}
