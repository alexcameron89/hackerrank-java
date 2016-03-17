package algorithms;

import java.util.Scanner;

/**
 * Created by 220333 on 11/13/2015.
 */
public class Flowers {
    int[] friendsByPurchaseCount;
    int[] flowerPrices;
    int friends;
    int flowers;

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

    public Flowers(int flowers, int friends, int[] prices) {
        this.friends = friends;

        this.flowers = flowers;
        this.flowerPrices = Flowers.MergeSort.sort(prices);
    }

    public long findTotal() {
        this.divvyUpFlowers();
        int extras = flowers % friends;
        long total = 0;
        int flowerPointer = this.flowers - 1;
        int multiplier = 1;

        for(int i = 0; i < flowers / friends; i++) {
            for(int j = 0; j < friends; j++) {
                total += flowerPrices[flowerPointer] * multiplier;
                flowerPointer -= 1;
            }
            multiplier += 1;
        }

        for(int i = 0; i < extras; i++) {
            total += flowerPrices[flowerPointer] * multiplier;
            flowerPointer -= 1;
        }

        return total;
    }

    public void divvyUpFlowers() {
        int flowersSplitEqually = flowers / friends;
        int extras = flowers % friends;
        int[] friendsByPurchaseCount = new int[friends];

        for(int i = 0; i < friends; i++) {
            if(extras > 0) {
                friendsByPurchaseCount[i] = flowersSplitEqually + 1;
                extras -= 1;
            } else {
                friendsByPurchaseCount[i] = flowersSplitEqually;
            }
        }

        this.friendsByPurchaseCount = friendsByPurchaseCount;
    }

    public static void main( String args[] ){
        Scanner in = new Scanner(System.in);

        int N, K;
        N = in.nextInt();
        K = in.nextInt();

        int C[] = new int[N];
        for(int i=0; i<N; i++){
            C[i] = in.nextInt();
        }

        Flowers test = new Flowers(N, K, C);
        System.out.println(test.findTotal());

    }
}
