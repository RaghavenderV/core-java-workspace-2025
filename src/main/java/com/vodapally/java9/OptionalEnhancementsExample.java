package com.vodapally.java9;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Optional;

public class OptionalEnhancementsExample {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Hello AI!!");

        // ifPresentOrElse(): Perform action if value is present, else perform another action
        optional.ifPresentOrElse(value-> System.out.println("Value: "+value),
                ()-> System.out.println("value not present"));//Consumer, Runnable


        // or(): Provide an alternative Optional if the current one is empty
        Optional<String> emptyOptional = Optional.empty();
        String s = emptyOptional.or(() -> Optional.of("Default")).get();
        System.out.println(s); // Default

        // The StackWalker API provides a more efficient way to traverse stack traces.
        StackWalker stackWalker = StackWalker.getInstance();
        stackWalker.forEach(frame -> System.out.println(frame.getClassName() + "::" + frame.getMethodName()));



        // java 12 feature
        // allowing switch to be used as an expression that returns a value.
        // It also introduced a new arrow syntax (->) for cleaner and more concise code.
        String day = "MONDAY";
        switch (day){
            case "MONDAY", "FRIDAY", "SUNDAY" -> System.out.println("6 days");
            case "TUESDAY" -> System.out.println("7 days");
            case "THURSDAY", "SATURDAY" -> System.out.println("8 days");
            case "WEDNESDAY" -> System.out.println("9 days");
            default -> System.out.println("Invalid day");
        }



        // Java 12 introduced the CompactNumberFormat class to format numbers in a compact, human-readable form.
        System.out.println("\nCompactNumberFormat");
        NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        System.out.println(fmt.format(1000)); // Output: 1K
        System.out.println(fmt.format(1_000_000)); // Output: 1M
    }
}
