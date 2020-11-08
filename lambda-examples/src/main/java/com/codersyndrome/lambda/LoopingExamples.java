package com.codersyndrome.lambda;

import java.util.*;

public class LoopingExamples
{
    public static void main( String[] args )
    {

        List<String> fruitsListOrSet = Arrays.asList("apple", "banana", "lemon", "orange");
        HashMap<String, Integer> hm =  new HashMap<String, Integer>();   
        hm.put("four", 4); 
        hm.put("first", 1); 
        hm.put("second", 2);        
        
        System.out.println("** FOREACH LAMBDA CODE INSTEAD OF FOR LOOP: fruitsListOrSet.forEach(s -> System.out.print(s))");
        fruitsListOrSet.forEach(s -> {System.out.println(s); });        
         
        System.out.println("** FOREACH LAMBDA CODE INSTEAD OF FOR LOOP ON ENTRYSET :hm.forEach((k, v) -> System.out.print(k + \" : \" + (v)))");
        hm.forEach((k, v) -> System.out.println(k + " : " + (v)));

        System.out.println("** FOREACH USES CONSUMER FUNCTIONAL INTERFACE FROM  UTIL.FUNCTION TO ACCEPT LAMBDA");
    }
}