package com.java.features.methodreference.parametermr;

@FunctionalInterface
public interface IntNumPredicate {

   // boolean check(int n);
   boolean check(IntNumChecker m, int n);
}
