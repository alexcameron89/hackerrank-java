package aiml;

import java.util.Scanner;

/**
 * Created by 220333 on 11/10/2015.
 */
public class BasicStatistics {
    int[] array;
    float mean;
    float median;
    int mode;
    float sDev;
    float upBound;
    float lowBound;

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

    public BasicStatistics(int[] array) {
        this.array = BasicStatistics.MergeSort.sort(array);
        this.mean = findMean();
        this.median = findMedian();
        this.mode = findMode();
        this.sDev = findStandardDeviation();

        float[] bounds  = findBounds();
        this.lowBound = bounds[0];
        this.upBound = bounds[1];
    }



    public float findStandardDeviation() {
        float sDev = 0;
        mean = findMean();
        for(int i = 0; i < array.length; i++) {
            sDev += Math.pow(array[i] - mean, 2);
        }

        sDev /= array.length;
        return (float)Math.sqrt(sDev);
    }

    public float[] findBounds() {
        float confInt = 1.96f;
        mean = findMean();
        sDev = findStandardDeviation();
        float sem = sDev/ (float)Math.sqrt(array.length);
        float[] bounds = new float[2];

        bounds[0] = mean - confInt*sem;
        bounds[1] = mean + confInt*sem;

        return bounds;
    }

    public int findMode() {
        int bestValue = array[0];
        int bestValueCount = 1;
        int currentValue = bestValue;
        int currentValueCount = bestValueCount;

        for(int i = 1; i < array.length; i++) {
            if(array[i] != currentValue) {
                if (currentValueCount > bestValueCount) {
                    bestValue = currentValue;
                    bestValueCount = currentValueCount;
                }
                currentValue = array[i];
                currentValueCount = 1;
            } else {
                currentValueCount += 1;
            }
        }
        return bestValue;
    }

    public float findMedian() {
        int length = array.length;
        if(length % 2 == 0) {
            float result = array[length/2 - 1] + array[length/2];
            return result / 2.0f;
        } else {
            return (float) array[length/2];
        }
    }

    public float findMean() {
        float average = 0.0f;
        for(int i = 0; i < array.length; i++) {
            average += array[i];
        }
        return average / array.length;
    }

    public void printStatistics() {
        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(sDev);
        System.out.println(lowBound + " " + upBound);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numbers = Integer.parseInt(input.nextLine());
        int[] array = new int[numbers];
        for(int i = 0; i < numbers; i++) {
            array[i] = input.nextInt();
        }

        BasicStatistics result = new BasicStatistics(array);
        result.printStatistics();
    }
}
