package com.java.features.functioncomposition;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Since you can use parallel stream doesn't mean you should use it  since it uses more resource to save the time.
 * So, it is resources v/s time. So, one need to be very careful while using parallel stream.
 * Use parallel stream only when:
 * 1.) data/ computation doesn't get impacted with parallel processing
 * 2.) you are willing to spent more resources
 * 3.) Data is large enough that you actually get the benefit of using the parallel processing
 */
public class Parallelization {
    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long startDate = new Date().getTime();
        numbers.stream()
                .filter(element -> element % 2 == 0)
                .mapToInt(Parallelization::compute)
                .sum();
        long endDate = new Date().getTime();
        long timeTaken = endDate - startDate;
        System.out.println("Time Taken in sequential stream: " + timeTaken);


        startDate = new Date().getTime();
        numbers.parallelStream()
                .filter(element -> element % 2 == 0)
                .mapToInt(Parallelization::compute)
                .sum();
        endDate = new Date().getTime();
        timeTaken = endDate - startDate;
        System.out.println("Time Taken in parallel stream: " + timeTaken);
    }

    public static int compute(Integer i) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        return i * 2;
    }
}
