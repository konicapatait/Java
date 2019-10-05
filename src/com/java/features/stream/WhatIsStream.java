package com.java.features.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Stream is an abstraction. It is a bunch of functions that evaluate.
 * Also, can be called as non-mutating pipeline
 * Stream operations:
 * 1.) filter :
 * 0 <= number of elements in the output <= number of elements in the input
 * parameter: Stream<T> filter takes Predicate<T>
 * 2.) map:
 * It transform values
 * number of output = number of input
 * No guarantee on the type of output with respect to the type of input
 * parameter: Stream<T> map takes Function<T,R> to return Stream<R>
 * <p>
 * NOTE: Both filter and map remain in their swimlanes i.e.
 * Numbers     filter      map           reduce
 *                                          0.0
 * x1           /                             \
 * --------------------------------------      \
 * x2          ->          x2'         ->      +
 * --------------------------------------       \
 * x3          /                                 \
 * --------------------------------------         \
 * x4          ->          x4'         ->          +
 * --------------------------------------           \
 * <p>
 * 3.) reduce:
 * cuts across the swim lanes
 * reduce on Stream<T> takes two parameters:
 * 1.) parameter of type T
 * 2.) parameter of type Bifunction<R, T, R> to produce a result of type R
 * <p>
 *      1             2              3              4
 *      |             |              |              |
 * 1 -> *   -->  1 -> *  -->  2   -> *  --> 6    -> * -> 24
 */
public class WhatIsStream {
    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(
                numbers.stream()
                        .filter(i -> i % 2 == 0)
                        .map(i -> i * 2.0)  // taking integer and returning double
                        .reduce(0.0, (carry, element) -> carry + element));

        System.out.println( "Can be coded as :"+
                numbers.stream()
                        .filter(i -> i % 2 == 0)
                        .mapToDouble(i -> i * 2.0)  // taking integer and returning double
                        .sum());

    }
}
