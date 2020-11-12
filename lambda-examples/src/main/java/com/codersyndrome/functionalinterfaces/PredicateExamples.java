package com.codersyndrome.functionalinterfaces;

import java.util.function.Predicate;
import java.util.function.BiPredicate;

public class PredicateExamples {
    public static void main(String args[]) 
    { 
        System.out.println("** PREDICATE TEST METHOD RETURNS BOOLEAN AND TAKES ONE IN ARG"); 
        Predicate<Integer> greaterThanTen = (i) -> i > 10; 
        System.out.println("** PREDICATE CHAINING USING OR AND NEGATE METHODS EX -"); 
        boolean result = greaterThanTen.and(greaterThanTen).test(15); 
        System.out.println(" Predicate<Integer> greaterThanTen = (i) -> i > 10; \n greaterThanTen.and(lowerThanTwenty).test(15) = " +result);  
        boolean result2 = greaterThanTen.and(greaterThanTen).negate().test(15); 
        System.out.println("** greaterThanTen.and(greaterThanTen).negate().test(15) = " + result2);

        System.out.println("** PREDICATE IS USED TO PASS CONDITION TO A METHOD  Ex printIfGreaterThanTen(10, (i) -> i < 10) = ");
        printIfGreaterThanTen(10, i -> i < 100);

        System.out.println("** PREDICATE LONGPREDICATE/INTPREDICATE/DOUBLEPREDICATE TAKES SPECIFIC IN ARG EG AND RETURNS DOUBLE"); 

        System.out.println("** BIPREDICATE TAKES TWO ARGS AND RETURNS BOOLEAN");
        BiPredicate<Integer, Integer> bi = (x, y) -> x > y;
        System.out.println("** (x, y) -> x > y" + bi.test(2, 3)); 

    }

    static void printIfGreaterThanTen(int number, Predicate<Integer> predicate) 
    { 
        if (predicate.test(number)) { 
            System.out.println("Number = " + number); 
        } 
    } 
}