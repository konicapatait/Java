package com.java.features.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Streams use lazy evaluation. (Efficient evaluation)
 *
 * Stream don't apply function on entire collection whereas it waits for terminate function.
 * Stream applies on the entire sequence of functions on element instead of apply one function on entire stream.
 *
 * NOTE: Lazy evaluation is only possible if the functions don't have side effects (don't print the stuff like in below class)
 */
public class LazyEvaluation {
    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5 , 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        // Given a list of numbers find the double of the first even number greater than 3.

        /**
         * Imperative Style
         *      8 Units of work
         */

        int result = 0;
        for (int element : numbers) {
            if (element > 3 && element % 2 == 0) {
                result = element * 2;
                break;
            }
        }

        System.out.println("Result: " + result);

        /**
         * Functional Style
         *  8 Units of work
         */

        Optional<Integer> firstElement = numbers.stream()
                .filter(e -> e > 3)
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .findFirst();

        System.out.println("Result: " + firstElement);

        // Rewrite the code using method reference
        Optional<Integer> firstElement2 = numbers.stream()
                .filter(LazyEvaluation::isGT3)
                .filter(LazyEvaluation::isEven)
                .map(LazyEvaluation::doubleIt)
                .findFirst();

        System.out.println("Result when called from method reference: " + firstElement2);
    }

    public static boolean isEven(int number) {
        System.out.println("isEven::Number:"+number);
        return number % 2 == 0;
    }

    public static boolean isGT3(int number) {
        System.out.println("isGT3::Number:"+number);
        return number > 3;
    }

    public static int doubleIt(int number) {
        System.out.println("doubleIt::Number:"+number);
        return number * 2;
    }
}
