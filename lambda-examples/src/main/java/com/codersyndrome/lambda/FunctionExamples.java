package com.codersyndrome.lambda;

import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.LongFunction;
import java.util.function.IntFunction;
import java.lang.Integer;

public class FunctionExamples {
    public static void main(String args[]) 
    { 
        System.out.println("** Function APPLY METHOD HAS ONE OUTPUT AND ONE INPUT");
        System.out.println("** Function APPLY METHOD CAN BE USED TO POINT TO LAMBDA OR METHOD REFERENCES AND EXECUTED");
        Function<Integer, Integer> squareFn = (a) -> { return a*a; }; 
        System.out.println("** SQUARE FUNCTION ON 10 = " + squareFn.apply(10));

        Function<Integer, Integer> doubleFn = (Integer x) -> { return (x+x);};
        System.out.println("** FUNCTION PRODUCES OUTPUT ON ONE ARG EG A + A = 10 + 10 ");
        System.out.println(applyFnInParameter(10, doubleFn));

        System.out.println("** Function andThen DEFAULT METHOD CAN BE USED FOR CHAINING EG A + A + 10");
        Function<Integer, Integer> addTen = (a) -> { return (a + 10); };
        System.out.println(applyFnInParameter(10,doubleFn.andThen(addTen)));

        BiFunction<Integer, Integer, Integer> biFnSumOfTwoNum = (a,b) -> { return (a + b);} ;
        System.out.println("** BiFunction A + B = 10 + 20 = " + biFnSumOfTwoNum.apply(10, 20));

        System.out.println("** INT / DOUBLE / LONG Function TAKES SPECIFIC ARG");
        IntFunction<Long> intFunction = (int x) -> { System.out.println("** INTEGER IN LONG RESULT  1000000 + 1000000 = "); return Long.valueOf(x+x); };
        LongFunction<Long> longFunction = (long x) -> { System.out.println("** LONG IN DOUBLE RESULT 1000000 + 1000000 = " ); return x + x;}; 
        DoubleFunction<Double> doubleFunction = (double x) -> { System.out.println("** DOUBLE IN DOUBLE RESULT 1000000 + 1000000 = "); return x+x; }; 
        
        System.out.println(intFunction.apply(1000000));
        System.out.println(longFunction.apply(1000000));
        System.out.println(doubleFunction.apply(1000000));

    }

    static <T> T applyFnInParameter(T number, Function<T,T> function) {
            return function.apply(number);
    }

}