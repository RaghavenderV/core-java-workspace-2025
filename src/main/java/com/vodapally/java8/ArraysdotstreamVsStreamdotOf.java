package com.vodapally.java8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// https://www.geeksforgeeks.org/difference-between-stream-of-and-arrays-stream-method-in-java/?ref=asr1
public class ArraysdotstreamVsStreamdotOf {
    public static void main(String[] args) {
        int[] arr = {15,6,9,7,4};
        // Stream.of() needs flattening whereas Arrays.stream() does not
        IntStream intStream = Arrays.stream(arr);
        intStream.forEach(i -> System.out.print(i+" "));
        System.out.println();

        Stream<int[]> stream = Stream.of(arr);
        // flattening is required
        IntStream intStream1 = stream.flatMapToInt(Arrays::stream);
        intStream1.forEach(i -> System.out.print(i+" "));

        // Stream.of() is generic whereas Arrays.stream is not: Arrays.stream() method only works for
        // primitive arrays of int[], long[], and double[] type, and returns IntStream, LongStream and
        // DoubleStream respectively. For other primitive types, Arrays.stream() won’t work.

        char charArray[] = { '1', '2', '3', '4', '5' };
        Stream<char[]> charStream = Stream.of(charArray);

    }
}
