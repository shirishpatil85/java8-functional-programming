# java8-functional-programming
Java8 Functional Programming Samples

## Lambda Expression
- Lambda expressions are used to define functions (or anonymous class) without creating an object explicitly.
- More light weight as object is not created. E.g
```
Comparator<Integer> comparator = new Comparator<Integer>() {
    @Override
    public int compare(Integer a, Integer b) {
        return a - b;
    }
};

Comparator<Integer> comparator = (a, b) -> a - b;
```
  
## Functional Interface
- Its an interface with exactly one abstract method. 
- It can have static and default methods. 
- Its used to point to lambda expresssion or method references. 

### Types
- Consumer, Function, BiFunction, UnaryOperator, BinaryOperator, Predicate, Supplier. 
```

// Consumer<T> FI : void apply(T o)
Consumer<String> printer = s -> System.out.println("Hello " + s);

// Supplier FI : T get();
Supplier<String> greetingSupplier = () -> "Hello, world!";

// Function<T,R> FI : R apply<T>()
Function<String, Integer> lengthCalc = str -> str.length();

// UnaryOperator<T> FI : special case of function where T and R are same
UnaryOperator<String> toUpper = str -> str.toUpperCase();

// BiFunction<T,U,R>  FI :R apply<T,U>
BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;

// BinaryOperator<T,T> FI : special case of function where 2 input and outut types match 
BinaryOperator<Integer> multiply = (a, b) -> a * b;

// Predicate<T> FI : boolean test<t>
Predicate<String> isEmpty = str -> str.isEmpty();
System.out.println(isEmpty.test(""));     // true
```
### Function chaining
- It has default andThen(function0 callback method for chaining.
```
Function<Integer, Integer> multiplyBy2 = x -> x * 2;
Function<Integer, Integer> add10 = x -> x + 10;
Function<Integer, Integer> combined = multiplyBy2.andThen(add10);

```

## Method reference
- Method references are short way of denoting static or instance methods or constructor(class::new) of a class.
- These methods can be assigned to Functional interfaces just like lambda. 
- Main advantage is that it automatically maps the input and output parameters of FI with that of method signature.
```
// Static or Non static methods or constructors
Supplier<MyClass> supplier = MyClass::new;
MyClass obj = supplier.get();

List<String> names = people.stream().map(Person::getName) // calls p.getName() for each Person
                           .collect(Collectors.toList());
```
## Stream APIs

### Stream creation

- Stream has its own factory method of, builder, concat method. 
- Also Arrays and Collections classes can use stream method to create a stream. 
- Files in nio package has lines method to return stream. 
- paralleSteam() method is used to create  a parallel processing stream or use parallel() to make intermediatory stream parallel capable of parallel processing.
- collect(Collectors.toList()/toSet()/toMap(..) are used for mapping them back to collections and arrays.
  
### Intermediate Operators
- These operators cannot be used without a terminal operator and return a stream. 
- Also cannot be resued once terminal operator is used over it 
- E.g. Filter, map- takes function as input , peek, distinct, skip, limit. 
  
### Terminal Operators
- These are the end of stream operation chain and returns non stream object. 
- Stream become unusable after use of terminal operator over it. 
- E.g. forEach
- E.g. Aggregation - sum, count, max, min, reduce(similar to map but it produces single result,takes bifunction as input).
- E.g. Shortciruciting - findFirst() - order maintained in parallel stream, findAny()

## FAQ coding questions
```
int sumOfSquaresOfOdd = numbers.stream()
                                .filter(n -> n % 2 != 0)
                                .map(n -> n * n)
                                .reduce(0, Integer::sum);

List<Integer> evenNumbers = numbers.stream()
                                  .filter(n -> n % 2 == 0)
                                   .collect(Collectors.toList());


List<Integer> uniqueNumbers = numbers.stream()
                                     .distinct()
                                     .collect(Collectors.toList());


Optional<Integer> min = numbers.stream()
                                .collect(Collectors.minBy(Comparator.naturalOrder()));

double avg = numbers.stream()
                    .collect(Collectors.averagingInt(Integer::intValue));



String reversed = str.chars()
                     .mapToObj(c -> (char) c)
                     .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);  //third arg is for parallel stream ordering


String concatString  =   words.stream()
                                    .map(String::toUpperCase)
                                    .collect(Collectors.joining(", "));


Map<Character, Long> frequencyMap = string1.chars()
                                        .mapToObj(c -> (char) c)
                                        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));


Map<String, Integer> fruitLengthMap = fruits.stream()
                                        .collect(Collectors.toMap(fruit -> fruit, String::length));

Map<Integer, String> nameMap = names.stream()
                                    .collect(Collectors.toMap(
                                              String::length,  // Key: String length
                                              name -> name,    // Value: Name itself
                                              (existing, replacement) -> existing // Conflict resolution: Keep first
                                    ));

```
