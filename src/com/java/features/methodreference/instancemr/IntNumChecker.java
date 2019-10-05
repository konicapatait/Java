package com.java.features.methodreference.instancemr;

import java.util.function.IntPredicate;

public class IntNumChecker {
    final int number ;

    public IntNumChecker(int number) {
        this.number = number;
    }

    boolean isBigger(int num) {
        return num > number;
    }
    
    public static void main(String... args) {
        IntNumChecker intNumChecker = new IntNumChecker(10);

        // Method# 1
        intNumChecker.isBigger(11);

        // Method# 2 :  Lambda
        IntPredicate predicate = num -> intNumChecker.isBigger(num);
        boolean result = predicate.test(9);

        System.out.println("Result: "+ result);

        // Method# 3 : Method Reference
        IntPredicate predicate2 = intNumChecker::isBigger;

        boolean result2 = predicate2.test(11);

        System.out.println("Result: "+ result2);



    }
}
