package com.codersyndrome.functionalinterfaces;

import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.LongFunction;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.BinaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToDoubleBiFunction;

public class FunctionExamples {
    public static void main(String args[]) 
    { 
        System.out.println("** FUNCTION APPLY METHOD HAS ONE OUTPUT AND ONE INPUT");
        System.out.println("** FUNCTION APPLY METHOD CAN BE USED TO POINT TO LAMBDA OR METHOD REFERENCES AND EXECUTED");
        Function<Integer, Integer> squareFn = (a) -> { return a*a; }; 
        System.out.println("** SQUARE FUNCTION ON 10 = " + squareFn.apply(10));

        Function<Integer, Integer> doubleFn = (Integer x) -> { return (x+x);};
        System.out.println("** FUNCTION PRODUCES OUTPUT ON ONE ARG EG A + A = 10 + 10 ");
        System.out.println(applyFnInParameter(10, doubleFn));

        System.out.println("** FUNCTION andThen DEFAULT METHOD CAN BE USED FOR CHAINING EG A + A + 10");
        Function<Integer, Integer> addTen = (a) -> { return (a + 10); };
        System.out.println(applyFnInParameter(10,doubleFn.andThen(addTen)));

        System.out.println("** INT / DOUBLE / LONG FUNCTION TAKES SPECIFIC ARG AND PARAMETERIZED OP");
        IntFunction<Long> intFunction = (int x) -> { System.out.println("** INTEGER IN LONG OP  1000000 + 1000000 = "); return Long.valueOf(x+x); };
        LongFunction<Long> longFunction = (long x) -> { System.out.println("** LONG IN DOUBLE OP 1000000 + 1000000 = " ); return x + x;}; 
        DoubleFunction<Double> doubleFunction = (double x) -> { System.out.println("** DOUBLE IN DOUBLE OP 1000000 + 1000000 = "); return x+x; }; 
        
        System.out.println(intFunction.apply(1000000));
        System.out.println(longFunction.apply(1000000));
        System.out.println(doubleFunction.apply(1000000));

        System.out.println("** FOR MIXED IN AND OUT ARG TYPES FUNCTIONS, TO SPECIFIES OUT AND IN TYPE IS PARAMERTIZED");
        ToDoubleFunction<Integer> tbf  = (x)-> Math.sin(x);
        System.out.println("** ToDoubleFunction<Integer> tbf  = (x)-> Math.sin(x) = sin(intmax) =" + tbf.applyAsDouble(Integer.MAX_VALUE));

        BiFunction<Integer, Integer, Integer> biFnSumOfTwoNum = (a,b) -> { return (a + b);} ;
        System.out.println("** BIFUNCTION A + B = 10 + 20 = " + biFnSumOfTwoNum.apply(10, 20));

        System.out.println("** BIFUNCTION FIX OUTPUT TYPE WITH TO AND KEEP BOTH ARGS PARAMETERIZED");
        ToIntBiFunction<String,String> tibf  = (x,y)-> Integer.parseInt(x) +Integer.parseInt(x);
        ToLongBiFunction<Integer,Long> tlbf  = (x,y)-> x+y;
        ToDoubleBiFunction<Integer,Long> tdbf  = (x,y)-> x+y;
        System.out.println("** ToIntBiFunction<Integer,Long> tibf  = (x,y)-> x+y = 10 +20 =" + tibf.applyAsInt("10", "20"));
        System.out.println("** ToLongBiFunction<Integer,Long> tlbf  = (x,y)-> x+y = 10 +20 =" + tlbf.applyAsLong(10, 20L));
        System.out.println("** ToDoubleBiFunction<Integer,Long> tdbf  = (x,y)-> x+y = 10 +20 =" +tdbf.applyAsDouble(10, 20L));

        System.out.println("** OPERATOR INTERFACES ARE SUBINTERFACES OF FUNCTIONS WHICH TAKE SAME IN OUT PARAMETERIZED TYPE");

        UnaryOperator<String> i  = (x)-> x.toUpperCase();
        System.out.println("**UnaryOperator<String> i  = (x)-> x.toUpperCase() =  upper(abcd) = " + i.apply("abcd"));

        System.out.println("** SPECIAL FUNCTIONAL INTERFACES WITH SAME IN AND OUT TYPE - <INT/LONG/DOUBLE><UNARY/BINARY>OPERATOR>(2inputs), NO PARAMETERIZED TYPE IS NEEDED");
        IntUnaryOperator squareOperator = (int x) -> x*x;
        System.out.println("** IntUnaryOperator int x -> x*x = 2*2 = " + squareOperator.applyAsInt(2));

        BinaryOperator<Integer> adder = (n1, n2) -> n1 + n2;
        System.out.println("** BinaryOperator<Integer> adder = (n1, n2) -> n1 + n2 = (3,4) =  " + adder.apply(3, 4));

        LongBinaryOperator lbo = (x,y) -> x/y;
        System.out.println("** LongBinaryOperator i = (x,y) -> x/y = longmax/longmax = " + lbo.applyAsLong(Long.MAX_VALUE,Long.MAX_VALUE));       

    }

    static <T> T applyFnInParameter(T number, Function<T,T> function) {
            return function.apply(number);
    }

}