package com.codersyndrome.functionalinterfaces;

import java.util.function.Predicate;

public class PredicateExamples {
    public static void main(String args[]) 
    { 
        System.out.println("** PREDICATE TEST METHOD RETURNS BOOLEAN"); 
        Predicate<Integer> greaterThanTen = (i) -> i > 10; 
        System.out.println("** PREDICATE CHAINING USING OR AND NEGATE METHODS EX -"); 
        boolean result = greaterThanTen.and(greaterThanTen).test(15); 
        System.out.println(" Predicate<Integer> greaterThanTen = (i) -> i > 10; \n greaterThanTen.and(lowerThanTwenty).test(15) = " +result);  
        boolean result2 = greaterThanTen.and(greaterThanTen).negate().test(15); 
        System.out.println("** greaterThanTen.and(greaterThanTen).negate().test(15) = " + result2);

        System.out.println("** PREDICATE IS USED TO PASS CONDITION TO A METHOD  Ex printIfGreaterThanTen(10, (i) -> i < 10) = ");
        printIfGreaterThanTen(10, (i) -> i < 100);
    }

    static void printIfGreaterThanTen(int number, Predicate<Integer> predicate) 
    { 
        if (predicate.test(number)) { 
            System.out.println("Number = " + number); 
        } 
    } 
}