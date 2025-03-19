package com.vodapally.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//https://www.geeksforgeeks.org/stream-flatmap-java-examples/
public class FlatMapExample {

    public static void main(String[] args) {
        // Example-1
        int[] intArray = {1, 2, 3, 4, 5};
        Stream<int[]> streamArray = Stream.of(intArray);
        IntStream intStream = streamArray.flatMapToInt(Arrays::stream);
        intStream.forEach(x -> System.out.print(x + " "));
        System.out.println("\n***********************************"); // 1 2 3 4 5


        // Example-2
        List<String> list = Arrays.asList("Geeks", "GFG", "GeeksforGeeks", "gfg");
        list.stream().flatMap(str -> Stream.of(str.charAt(2))).forEach(s -> System.out.print(s + " ")); //e G e g


        System.out.println("\n***********************************");
        // Example-3 - best one
        // Creating a list of Prime Numbers
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11, 13);

        // Creating a list of Odd Numbers 
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);

        // Creating a list of Even Numbers 
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);

        List<List<Integer>> listOfListOfInts =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);

        System.out.println("The Structure before flattening is : \n" +
                listOfListOfInts);

        // Using flatMap for transformating and flattening. 
        List<Integer> listOfInts = listOfListOfInts.stream().flatMap(intList -> intList.stream()).collect(Collectors.toList());
        System.out.println("\nThe Structure after flattening is : \n" + listOfInts);//[5, 7, 11, 13, 1, 3, 5, 2, 4, 6, 8]


        //Example-4 string array
        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        List<String> collect = Stream.of(array)//Stream<String[]>
                .flatMap(Stream::of) //Stream<String>
                .collect(Collectors.toList());

        collect.forEach(s -> System.out.print(s+" "));  //a b c d e f

        //Example-5
        System.out.println("\n\nTest Contacts List");
        Tester tester1 = new Tester(101,"Ravi",List.of("9247826359"));
        Tester tester2 = new Tester(201,"Lasya",List.of("3265987451"));
        Tester tester3 = new Tester(401,"Mokshith",List.of("5698745632"));

        List<Tester> testerList = new ArrayList<>();
        testerList.add(tester1);
        testerList.add(tester2);
        testerList.add(tester3);

        testerList.stream().flatMap(tester -> tester.contact().stream()).forEach(System.out::println);
    }
}

record Tester(int id, String name, List<String> contact){

}