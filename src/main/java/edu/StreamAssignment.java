package edu;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAssignment {
    public static void main(String[] args) {

        // 1. 문자열 List Filter 예제
        List<String> names1 = Arrays.asList("Alice", "Bob", "Charlie", "David");
        names1.stream()
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);

        // 2. Integer List 다루기
        List<Integer> integerList = Arrays.asList(1, 2, 3, 1, 2, 3, 4, 5, 7, 7, 8, 9, 10, 10);
        List<Integer> filteredInts = integerList.stream()
                .distinct()
                .filter(num -> num % 3 != 0)
                .collect(Collectors.toList());
        System.out.println(filteredInts);

        // 3. String List 다루기
        List<String> names2 = Arrays.asList("Tom", "Jerry", "Spike", "Tyke", "Alice", "Bob", "Tommy", "Trump");
        names2.stream()
                .filter(name -> name.length() > 3)
                .map(String::toUpperCase)
                .sorted()
                .forEach(name -> System.out.print(name + " "));
        System.out.println();

        // 4. 주요 연산 (map, filter, reduce)
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sumOfSquares = numbers.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> num * num)
                .reduce(0, Integer::sum);
        System.out.println("Sum of squares of even numbers: " + sumOfSquares);

        List<String> names3 = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        String result = names3.stream()
                .filter(name -> name.length() >= 4)
                .map(String::toUpperCase)
                .reduce("", (prev, next) -> prev.concat(next + " "));
        System.out.println(result);
    }
}
