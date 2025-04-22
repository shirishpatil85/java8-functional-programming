# java8-functional-programming
Java8 Functional Programming Samples

## 1. Lambda Expression
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
  
## 2.Functional Interface
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

## 3. Method reference
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

## 4. Stream APIs

- Stream creation can be done for Array, Collection and NIO Files using stream method
- Intermediate Operators cannot be used without a terminal operator and return a stream. 
- Terminal Operators are the end of stream operation chain and returns non stream object. 
- paralleSteam() method is used to create  a parallel processing stream or use parallel() to make intermediatory stream parallel capable of parallel processing.

## Operator examples
```
/* Intermediate Operators */

// 1. map and filter

List<String> upper = names.stream()
                          .filter(n -> n.length() > 3)
                          .map(String::toUpperCase)
                          .collect(Collectors.toList());

// 2. distinct / sort / skip(n) / limit(n)

List<Integer> numbers = Arrays.asList(5, 1, 2, 2, 3, 4, 4, 6);
List<Integer> result = numbers.stream()
                              .distinct()
                              .sorted()
                              .skip(2)
                              .limit(3)
                              .collect(Collectors.toList());

System.out.println(result);  // Output: [3, 4, 5]

// 3. peek for debug

/* Terminal Operators */


// 1.  Aggregation - sum, count, max, min, reduce(similar to map but it produces single result,takes bifunction as input).

    Optional<Integer> min = nums.stream().min(Integer::compareTo);
    
    int total = nums.stream().mapToInt(Integer::intValue).sum();
    int totalAge = people.stream().mapToInt(p -> p.age).sum();  // sum of ages of all people
    int sumUsingReduce = nums.stream().reduce(0, (a, b) -> a + b);

// 2. foreach

// 3. collect(Collectors.toList()/toSet()/toMap/groupingBy(..) are used for mapping them back to collections and arrays.

    long count = names.stream().collect(Collectors.counting());
    String result = names.stream().collect(Collectors.joining(", "));
    IntSummaryStatistics stats = ages.stream().collect(Collectors.summarizingInt(age -> age));
    
    List<String> collected = names.stream().collect(Collectors.toList());
    Set<Integer> unique = nums.stream().collect(Collectors.toSet());
    Map<Integer, String> idToName = people.stream()
        .collect(Collectors.toMap(
            person -> person.id,
            person -> person.name
        ));

    Map<String, List<Person>> byCity = people.stream().collect(Collectors.groupingBy(p -> p.city));   // key based groups
    
    Map<String, List<String>> namesByCity = people.stream().collect(Collectors.
                                .groupingBy(p -> p.city, Collectors.mapping(p ->p.name,Collectors.toList())));  // key and transformed value

// 4. Shortciruciting - findFirst() - order maintained in parallel stream, findAny() and anyMatch/allMatch/noneMatch
    List<String> names = List.of("Alice", "Bob", "Charlie");
    Optional<String> any = names.stream().findAny();
    any.ifPresent(System.out::println);  // Output could be Alice, Bob, or Charlie (esp. i

    boolean anyOdd = numbers.stream().anyMatch(n -> n % 2 != 0);
    boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);
    boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);

```
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
