package com.codersyndrome.lambda;

public class FunctionalInterfaceExamples {
    public static void main(String args[]) 
    { 
        System.out.println("** LAMDBA EXPRESSIONS NEED FN INTERFACE TO WORK/INVOKE AS JAVA ALLOWS ONLY METHODS AND NO FNS(METHOD OUTSIDE CLASS)");
        StringConcat s = (str1, str2) -> str1 + str2;
        System.out.println("Result of concat of s1 and s2: "+s.sconcat("Hello ", "World")); 
        HelloGreetings h = () -> { System.out.println("LAMBDA EXPRESSION EXECUTED WITHOUT PARAMS AND OUTPUT -- PRINT/DO SOMETHING");};
        h.sayHello();
    }
}

@FunctionalInterface
interface StringConcat {
    public String sconcat(String a, String b);
}

@FunctionalInterface
interface HelloGreetings {
    public void sayHello();
}