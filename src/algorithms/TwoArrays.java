package algorithms;

import java.util.Scanner;

/**
 * Created by 220333 on 11/12/2015.
 */
public class TwoArrays {

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

    public static int[] stringToSortedArray(String text) {
        String[] textSplit = text.split(" ");
        int[] array = new int[textSplit.length];

        for(int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(textSplit[i]);
        }

        return TwoArrays.MergeSort.sort(array);
    }

    public static int[] stringToReverseSortedArray(String array) {
        int[] sortedArray = stringToSortedArray(array);
        int[] reverseArray = new int[sortedArray.length];

        for(int i = sortedArray.length - 1; i >= 0; i--) {
            reverseArray[i] = sortedArray[sortedArray.length - 1 - i];
        }

        return  reverseArray;
    }

    public static boolean permutationPossible(long comparator, String a, String b) {
        int[] arrayA = TwoArrays.stringToSortedArray(a);
        int[] arrayB = TwoArrays.stringToReverseSortedArray(b);

        for(int i = 0; i < arrayA.length; i++) {
            if(arrayA[i] + arrayB[i] < comparator) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = Integer.parseInt(in.nextLine());

        for(int i = 0; i < tests; i++) {
            String counts = in.nextLine();
            String[] countSplit = counts.split(" ");

            String a = in.nextLine();
            String b = in.nextLine();

            if(TwoArrays.permutationPossible(Integer.parseInt(countSplit[1]), a, b)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
