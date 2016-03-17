package algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Pairs {
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


    public static int countPairs(int k, int[] array) {
        int count = 0;
        int[] sortedArray = MergeSort.sort(array);
        int highPointer = 1;
        int highPointerValueCount = 1;
        int lowPointer = 0;
        int lowPointerValueCount = 1;

        while(highPointer < sortedArray.length) {
            if((sortedArray[highPointer] - sortedArray[lowPointer] < k) || highPointer <= lowPointer) {
                highPointer++;
            } else if (sortedArray[highPointer] - sortedArray[lowPointer] > k) {
                lowPointer++;
            } else {
                while(sortedArray[lowPointer] == sortedArray[lowPointer + 1]) {
                    lowPointerValueCount += 1;
                    lowPointer++;
                }
                while((highPointer < sortedArray.length - 2) && (sortedArray[highPointer] == sortedArray[highPointer + 1])) {
                    highPointerValueCount += 1;
                    highPointer++;
                }
                count += highPointerValueCount * lowPointerValueCount;
                highPointer += highPointerValueCount;
                lowPointer += lowPointerValueCount;
            }

        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        String n = in.nextLine();
        String[] n_split = n.split(" ");

        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);

        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        res = countPairs(_k, _a);
        System.out.println(res);
    }

}