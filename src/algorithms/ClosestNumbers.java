package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 220333 on 11/20/2015.
 */
public class ClosestNumbers {
    public static class MergeSort {

        public static int[] sort(int[] m) {
            // Base case. A list of zero or one elements is sorted, by definition.
            if (m.length <= 1) {
                return m;
            }


            // Recursive case. First, *divide* the list into equal-sized sublists.

            int middle = m.length / 2;
            int[] left = new int[middle];
            int[] right = new int[m.length - middle];
            for(int i = 0; i < middle; i++) {
                left[i] = m[i];
            }
            for(int j = 0; j + middle < m.length; j++) {
                right[j] = m[j + middle];
            }

            // Recursively sort both sublists
            left = sort(left);
            right = sort(right);

            // Then merge the now-sorted sublists.
            return merge(left, right);
        }

        private static boolean notEmpty(int[] array, int pointer) {
            if (array.length > pointer) return true;
            return false;
        }

        private static int[] merge(int[] left, int[] right) {
            int[] result = new int[left.length + right.length];
            int resultPointer = 0;
            int leftPointer = 0;
            int rightPointer = 0;


            while (notEmpty(left, leftPointer) && notEmpty(right, rightPointer)) {
                if (left[leftPointer] <= right[rightPointer]) {
                    result[resultPointer] = left[leftPointer];
                    resultPointer++;
                    leftPointer++;
                } else {
                    result[resultPointer] = right[rightPointer];
                    resultPointer++;
                    rightPointer++;
                }
            }
            // either left or right may have elements left
            while (notEmpty(left, leftPointer)) {
                result[resultPointer] = left[leftPointer];
                resultPointer++;
                leftPointer++;
            }
            while (notEmpty(right, rightPointer)) {
                result[resultPointer] = right[rightPointer];
                resultPointer++;
                rightPointer++;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = Integer.parseInt(input.nextLine());
        int[] numbers = new int[count];

        for(int i = 0; i < count; i++) {
            numbers[i] = input.nextInt();
        }

        System.out.println(ClosestNumbers.find(numbers));
    }

    private static String printPairs(List<Integer> pairs) {
        String result = "";
        while (pairs.size() > 1) {
            result += pairs.remove(0) + " ";
        }

        return result + pairs.remove(0);
    }

    public static String find(int[] numbers) {
        List<Integer> minPairs = new ArrayList<Integer>();
        int[] numbersSorted = ClosestNumbers.MergeSort.sort(numbers);
        int minDifference = 100000000;

        for(int i = 0; i < numbersSorted.length - 1; i++) {
            int difference = Math.abs(numbersSorted[i+1] - numbersSorted[i]);
            if(difference <= minDifference) {
                if (difference < minDifference) {
                    minPairs.removeAll(minPairs);
                    minDifference = difference;
                }
                minPairs.add(numbersSorted[i]);
                minPairs.add(numbersSorted[i + 1]);
            }
        }

        return printPairs(minPairs);
    }
}
