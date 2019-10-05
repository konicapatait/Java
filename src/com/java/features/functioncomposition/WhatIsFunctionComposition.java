package com.java.features.functioncomposition;

import java.util.Arrays;
import java.util.List;

public class WhatIsFunctionComposition {
    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /* Given the values, double the even numbers and total */

        /** In Imperative Style **/

        int result = 0;

        for (int element : numbers) {
            if (element % 2 == 0) {
                result += element * 2;
            }
        }

        System.out.println(result);

        /** In Functional Style **/
        numbers.stream()
                .filter(element -> element % 2 == 0)
                .map(element -> element * 2)
                .reduce(0, Integer::sum);
        /** OR **/
        numbers.stream()
                .filter(element -> element % 2 == 0)
                .mapToInt(element -> element * 2)
                .sum();

        /** **/

    }
}
