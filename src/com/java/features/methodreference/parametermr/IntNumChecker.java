package com.java.features.methodreference.parametermr;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class IntNumChecker {

    final private int num;

    public IntNumChecker(int num) {
        this.num = num;
    }

    boolean isBigger(int n) {
        return num > n;
    }

    public static void main(String... args) {
        IntNumChecker intNumChecker = new IntNumChecker(10);

        IntPredicate pre = intNumChecker::isBigger;     // Instance method reference

        IntNumPredicate predicate = IntNumChecker::isBigger;
        boolean result = predicate.check(intNumChecker,12);
        System.out.println("Result:"+result);

        IntNumChecker intNumChecker2 = new IntNumChecker(10);

        IntNumPredicate predicate2 = IntNumChecker::isBigger;
        boolean result2 = predicate2.check(intNumChecker2,9);
        System.out.println("Result:"+result2);
    }
}
