package algorithms;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by 220333 on 12/1/2015.
 */
public class Fibonacci {

    public static BigInteger findFib(int a, int b, int iteration) {
        BigInteger[] fibArray = new BigInteger[iteration];
        fibArray[0] = BigInteger.valueOf(a);
        fibArray[1] = BigInteger.valueOf(b);

        for (int i = 2; i < iteration; i++) {
            BigInteger num = fibArray[i - 1].multiply(fibArray[i - 1]);
            num = num.add(fibArray[i - 2]);
            fibArray[i] = num;
        }

        return fibArray[iteration - 1];
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int iteration = input.nextInt();



        System.out.println(Fibonacci.findFib(a, b, iteration));
    }
}
