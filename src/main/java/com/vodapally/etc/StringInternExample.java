package com.vodapally.etc;

public class StringInternExample {
    public static void main(String[] args) {
        String str1 = "Hello"; // Automatically interned
        String str2 = "Hello"; // Automatically interned

        System.out.println(str1 == str2); // true

        String str3 = new String("Hello"); // Not automatically interned
        String str4 = str3.intern(); // Manually interned

        System.out.println(str1 == str4); // true
        System.out.println(str1 == str3); // false

    }
}
/*
What is String Interning?
String interning involves storing unique strings in a shared pool, known as the
String Constant Pool (SCP) in Java. This approach ensures that any identical strings in a
program refer to the same memory location,
reducing memory duplication and improving efficiency in string comparisons

How Does String Interning Work in Java?
Automatic Interning: In Java, string literals (e.g., "Hello") are automatically interned and stored in the SCP. This means that multiple variables assigned the same string literal will reference the same object in memory.
Manual Interning: When strings are created using the new keyword (e.g., new String("Hello")), they are stored in the heap and not automatically interned. However, you can manually intern such strings using the intern() method, which checks if
the string exists in the SCP and returns a reference to it if found, or adds it if not.
Benefits: Interning strings allows for faster string comparisons using the == operator, as it checks for reference equality rather than content equality. It also reduces memory usage by avoiding duplicate string objects
 */
