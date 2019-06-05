package com.kamlesh.trial.algo.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * You are given an array A of size N.
 * You need to find all pairs in the array that sum to a number K.
 * If no such pair exists then output will be -1.
 */
public class ArrayPairFinder {


    public String findPairUsingHash(int[] arr, int sum) {
        StringBuilder result = new StringBuilder();
        if (Objects.isNull(arr) || arr.length < 2) {
            return result.toString();
        }

        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr).forEach((element -> {
            if (!set.contains(element)) {
                set.add(sum - element);
            } else {
                result.append((sum - element)).append(element);
            }
        }));

        return result.toString();
    }

    public String sortAndFindPair(int[] arr, int sum) {
        StringBuilder result = new StringBuilder();
        if (Objects.isNull(arr) || arr.length < 2) {
            return result.toString();
        }

        // sort the array
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int currentSum = arr[left] + arr[right];

            if (currentSum == sum) {
                result.append(arr[left]).append(arr[right]);
                left++; // to find multiple pairs .. need to check if it works in all the cases
            } else if (currentSum < sum) {
                left++;
            } else {
                right--;
            }

        }

        return result.toString();
    }
}
