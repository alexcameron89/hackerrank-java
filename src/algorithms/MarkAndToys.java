package algorithms;

import java.util.Scanner;

/**
 * Created by 220333 on 11/20/2015.
 */
public class MarkAndToys {

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
        Scanner stdin=new Scanner(System.in);
        int toys =stdin.nextInt();
        int money =stdin.nextInt();
        int prices[]=new int[toys];

        for(int i=0;i<toys;i++) {
            prices[i] = stdin.nextInt();
        }

        // Compute the final answer from n,k,prices
        System.out.println(MarkAndToys.findMaxToys(money, prices));
    }

    private static int findMaxToys(int money, int[] prices) {
        int[] sortedPrices = MarkAndToys.MergeSort.sort(prices);
        int toyCount = 0;
        for(int price: sortedPrices) {
            if(price > money) {
                return toyCount;
            } else {
                toyCount++;
                money -= price;
            }
        }

        return toyCount;
    }
}
