package com.vodapally.java11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;

public class Java11Features {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 1. New String methods
        System.out.println("1. New String methods");
        String str = "  Hello, Java 11!  ";

        // strip(): Removes leading and trailing whitespace
        String stripped = str.strip();
        System.out.println("Stripped: '" + stripped + "'"); // Output: 'Hello, Java 11!'

        String test = "   Pushpa2";
        System.out.println(test.stripLeading());// and also we have stripTrailing() for removing trailing spaces

        // isBlank(): Checks if the string is empty or contains only whitespace
        boolean isBlank = str.isBlank();
        System.out.println("Is blank: " + isBlank); // Output: false

        // lines(): Returns a stream of lines
        String multiLineStr = "Line1\nLine2\nLine3";
        multiLineStr.lines().forEach(System.out::println); // Output: Line1, Line2, Line3


        // 2. Local-Variable Syntax for Lambda parameters
        System.out.println("\n2. Local-Variable Syntax for Lambda parameters");
        List<String> list = List.of("Ridge Gourd", "Bitter Gourd", "Tomato");
        list.forEach((var vegList) -> System.out.println(vegList));


        // 3. Optional Enhancements
        System.out.println("\n3. Optional Enhancements");
        Optional<String> optionalString = Optional.of("BJP");
        //isEmpty
        System.out.println(optionalString.isEmpty()); // false

        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.isEmpty()); // true


        // 4. HTTP Client API
        System.out.println("4. HTTP Client API");
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1")).build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        /*output:
        {
          "userId": 1,
          "id": 1,
          "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
          "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
        }

        */


        // 5. Single-File Source Code Execution
        System.out.println("5. Single-File Source Code Execution");
        System.out.println("Java 11 allows you to run a single Java source file without explicitly compiling it.");
        System.out.println("To run: java Java11Features.java");


        // 6. Unicode 10 Support
        // Java 11 added support for Unicode 10, including new characters, scripts, and symbols.


        // 7. New Collection.toArray() method
        // A new default method toArray(IntFunction<T[]>) was added to the Collection interface.
        System.out.println("7. New Collection.toArray() method");
        List<String> vegList = List.of("Ridge Gourd", "Bitter Gourd", "Tomato");
        String[] array = vegList.toArray(String[]::new);
        for (String s : array) {
            System.out.println(s);
        }


        // 8. Nest Based Access Control
        // Which allows classes in the same nest to access each other's private members without synthetic accessors.
        // see below.


        // 9. File methods
        // Added new methods to the Files class such as readString(), writeString(), isSameFile()
        String filePath = "src/main/resources/nameslist.txt";
        Path path = Paths.get(filePath);
        String string = "\nVenkatesh";
        Files.writeString(path, string, StandardOpenOption.APPEND);
        String content = Files.readString(path);
        System.out.println("content in file:\n" + content);


        // 10. Java Flight Recorder (JFR)
        // Java Flight Recorder is a tool for monitoring and profiling java applications.
        // see example: JavaFlightRecorder

    } // main()

    private void outerMethod() {
        System.out.println("Outer Method: Java11Features");
    }

    class Inner {
        public void innerMethod() {
            outerMethod(); // // Accessing private method of outer class
        }
    } // Inner
} // Java11Features
