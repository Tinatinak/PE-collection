package com.company;

import java.math.BigInteger;

public class Main {

    final static BigInteger BILLION = new BigInteger("1000000000");

    public static void main(String[] args) {

        int x = 5;
        BigInteger triangleNumber = new BigInteger("1");
        BigInteger count = new BigInteger("1");

        int factors;
        boolean flag = true;

        BigInteger lowestPossibleValue = factorialOf(x); //minsta möjliga värd med x faktorer är x!
        System.out.println("Lowest possible number is: \n" + lowestPossibleValue.toString());

        //räkna fram lägsta trianglevärde > x!
        do {
            count = count.add(BigInteger.ONE);
            triangleNumber = triangleNumber.add(count);
        } while (triangleNumber.compareTo(lowestPossibleValue) == -1); //-1 <=> mindre än

        System.out.println("Lowest possible triangle number is: \n" + triangleNumber.toString() +
                            "\nCount: " + count);


        /*
        do {
            factors = numberOfFactors(triangleNumber);
            System.out.println(count + ": " + triangleNumber +
                    ", Factors: " + factors);
            if (factors > x) {
                System.out.println("Här är svaret: " + count + ": " + triangleNumber +
                        ", Factors: " + factors);
                flag = false;
            }
            count++;
            triangleNumber += count;

        } while (flag);
*/

    }

    private static int numberOfFactors (int x) {
        int factors = 2; // divisible by 1 and itself
        for (int i = 2; i <= x/2; i++) {
            if (x % i == 0) {
                factors++;
            }
        }
        return factors;
    }

    private static BigInteger factorialOf(int x) {
        BigInteger startValue = new BigInteger("1");
        for (int i = 1; i <= x; i++) {
            BigInteger multiplier = new BigInteger(String.valueOf(i));
            startValue = startValue.multiply(multiplier);
        }
        return startValue;
    }

    /*
    private static BigInteger nextTriangleNumber(BigInteger x) {
        BigInteger triangleNumber = new BigInteger("1");
        BigInteger additor = new BigInteger("2");
        do {
            triangleNumber = triangleNumber.add(additor);
            additor = additor.add(BigInteger.ONE);
        } while (triangleNumber.compareTo(x) == -1);
        return triangleNumber;
    }
    */
}
