package com.codersyndrome.functionalinterfaces;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class SupplierExamples {
    public static void main(String args[]) 
    { 
        System.out.println("** SUPPLIER GET METHOD RETURNS THE PARAMETERIZED OP AND TAKES NO ARG. TYPES OF Suppliers - int/long/double/boolean");
        Supplier<LocalDateTime> dateTimeSupplier = () -> LocalDateTime.now();
        System.out.println("() -> LocalDateTime.now() =  dateTimeSupplier.get() = " + dateTimeSupplier.get());
    }
}