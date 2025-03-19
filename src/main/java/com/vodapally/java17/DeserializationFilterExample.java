package com.vodapally.java17;

import java.io.*;

public class DeserializationFilterExample {
    public static void main(String[] args) {
        try {
            // Create a ByteArrayOutputStream to simulate serialized data
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);

            // Serialize a simple object
            String str = "Java 17 feature. Context-specific deserialization.";
            //Integer i = 143; // test with this Integer object; It gets Rejected.
            out.writeObject(str);

            // Create a filter that allows only String classes to be deserialized
            ObjectInputFilter filter = filterInfo -> {
                Class<?> clazz = filterInfo.serialClass();
                if (clazz != null && clazz == String.class) {
                    return ObjectInputFilter.Status.ALLOWED;
                }
                return ObjectInputFilter.Status.REJECTED;
            };

            // Create an ObjectInputStream and apply the filter
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(byteOut.toByteArray()));
            in.setObjectInputFilter(filter);

            // Deserialize the object
            Object object = in.readObject();
            System.out.println("Deserialized object: " + object);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
/*
Context-Specific Deserialization Filters are to ensure the safe deserialization of objects.
They help prevent security vulnerabilities that can arise from deserializing untrusted data.
 */
