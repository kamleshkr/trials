package com.kamlesh.trial.algo.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayPairFinderTest {

    private ArrayPairFinder arrayPairFinder = new ArrayPairFinder();

    @Test
    public void testForPresenceOfPair() {
        int arr[] = new int[] {1, 7, 9, 2, 11};
        int sum = 10;
        String result = arrayPairFinder.findPairUsingHash(arr, sum);
        Assert.assertEquals("19", result);
    }

    @Test
    public void testForPresenceOfMultiplePairs() {
        int arr[] = new int[] {1, 5, 6, 7, 9, 2, 11};
        int sum = 11;
        String result = arrayPairFinder.findPairUsingHash(arr, sum);
        Assert.assertEquals("5692", result);
    }

    @Test
    public void testForAbsenceOfPair() {
        int arr[] = new int[] {1, 5, 6, 7, 9, 2, 11};
        int sum = 99;
        String result = arrayPairFinder.findPairUsingHash(arr, sum);
        Assert.assertEquals("", result);
    }

    @Test
    public void testForPresenceOfPairAfterSorting() {
        int arr[] = new int[] {1, 7, 9, 2, 11};
        int sum = 10;
        String result = arrayPairFinder.sortAndFindPair(arr, sum);
        Assert.assertEquals("19", result);
    }

    @Test
    public void testForPresenceOfMultiplePairsAfterSorting() {
        int arr[] = new int[] {1, 5, 6, 7, 9, 2, 11};
        int sum = 11;
        String result = arrayPairFinder.sortAndFindPair(arr, sum);
        Assert.assertEquals("2956", result);
    }

    @Test
    public void testForAbsenceOfPairAfterSorting() {
        int arr[] = new int[] {1, 5, 6, 7, 9, 2, 11};
        int sum = 99;
        String result = arrayPairFinder.sortAndFindPair(arr, sum);
        Assert.assertEquals("", result);
    }
}
