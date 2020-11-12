package com.codersyndrome.methodreference;

import java.util.function.Supplier;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.List;
import java.util.Arrays;

public class MethodReferenceExamples {
    public int number;
    public MethodReferenceExamples(int i) {
        number = i;
    }  
    public static void main(String[] args) { 
        BiFunction<Integer, Integer, Integer> function1 = Integer::sum; 
        System.out.println("** METHOD REFERENCE DOES AUTO MAPPING OF INPUT ARGS AND OP TYPE");
        System.out.println("** STATIC METHOD REFERENCE - BiFunction<Integer, Integer, Integer> function1 = Integer::sum ; \n function1.apply(3,4) =  " +function1.apply(2, 3));

        String str1 = new String("hello");
        Supplier<Integer> supplier1  = str1::length; 
        System.out.println("** INSTANCE BOUND METHOD REFERENCE USED FOR SUPPLIER supplier1 = str1::length = " + supplier1.get());
        
        MethodReferenceExamples methodReferenceExamplesObj1 = new MethodReferenceExamples(10);
        Function<MethodReferenceExamples,Integer> function2  = MethodReferenceExamples::intNonStaticMethod;
        System.out.println("** INSTANCE UNBOUND METHOD REFERENCE DECLARATION USING METHOD WITH CLASS INSTEAD OF OBJ \n Function<MethodReferenceExamples,Integer> function2  = MethodReferenceExamples::intNonStaticMethod; \n function2.apply(methodReferenceExamplesObj1) = " + function2.apply(methodReferenceExamplesObj1));

        Supplier<String> supplier3  = String::new;
        System.out.println("** CONSTRUCTOR METHOD REFERENCE USED FOR SUPPLIER Supplier<String> supplier3  = String::new; \n supplier3.get() = "+supplier3.get().getClass());

        Function<String[],List<String>> asList = Arrays::<String>asList;    
        System.out.println("** GENERIC METHOD REFERENCE EG Function<String[],List<String>> asList = Arrays::<String>asList; \n asList.apply(new String[]{\"a\",\"b\",\"c\"}) = " + asList.apply(new String[]{"a","b","c"}));

    }

    public Integer intNonStaticMethod(){
        return this.number;
    }

}