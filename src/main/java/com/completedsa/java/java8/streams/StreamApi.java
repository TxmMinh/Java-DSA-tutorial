package com.completedsa.java.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {

    public static void main(String[] args) {
        // Mặc định các lớp kế thừa của Collection đều có hàm .stream()
        Collection<String> collection = Arrays.asList("hello", "world", "heaven");
        Stream<String> streamOfCollection = collection.stream();

        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        Stream<String> parallelStream = list.parallelStream();

        // forEach
        list.stream().forEach(System.out::println);

        // map
        Arrays.asList(3, 5, 7)
                .stream()
                .map(i -> "number-"+i)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // filter
        Stream.of(2, 3, 5, 7)
                .filter(i -> i % 2 != 0)
                .map(i -> "number-"+i)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // limit
        IntStream.range(1, 1000).boxed() // Tạo ra Stream có dữ liệu từ 1->999
                .filter(i -> i % 2 != 0)
                .map(i -> "number-" + i)
                .map(String::toUpperCase)
                .limit(10)
                .forEach(System.out::println);

        // sorted
        IntStream.range(1, 1000).boxed()
                .filter(i -> i % 2 != 0)
                .map(i -> "number-" + i)
                .map(String::toUpperCase)
                .limit(10)
                .sorted()
                .forEach(System.out::println);

        // collect
        List<String> result = IntStream.range(1, 1000).boxed()
                .filter(i -> i % 2 != 0)
                .map(i -> "loda-" + i)
                .map(String::toUpperCase)
                .limit(10)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList()); // .toList()


    }
}
