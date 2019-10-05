package com.java.features.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ImperativeVsFunctionalStyle {

    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /**
         * external iterator
         * 1.) User have to initialize the variable
         * 2.) User have set the boundary condition.
         * 2.) User have to increment the number
         * It is not simple, it is familiar
         */

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        /**
         * External Iterator
         * User still is controlling the iterator
         */
        for (int i : numbers) {
            System.out.println(numbers.get(i));
        }

        /**
         * Internal Iterator
         * It is using polymorphism. Internal detail is hidden, it could be using sequential, parrallel etc
         */
        numbers.forEach(new Consumer<Integer>() {

            @Override
            public void accept(Integer i) {
                System.out.println(i);
            }
        });

        /**
         * It can be written as below using Lambda expression.
         * Since Lambda 8 has type inference, it finally hold your tweets, but only for lambda expressions
         * Parenthesis is optional but only for one parameter lambdas.
         */
        numbers.forEach(i -> System.out.println(i));


        /**
         * Below function is taking the value and passes the value. So above code can be written as below.
         *
         */
        numbers.forEach(System.out::println);

        /**
         * Lambda expressions should be glue code.
         * Two lines may be too many
         * To answer why:
         * 1.) Too difficult to read
         * 2.) It's noisy
         * 3.) Leads to duplication
         * 4.) Hard to Test
         * Never put the logic in Lambda. Rather create the function (get it unit tested) and call the function from the lambda
         */

    }


}
