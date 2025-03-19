package com.vodapally.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalUsageDemo {

    public static void main(String[] args) {
        Customer customer1 = new Customer(101, "Raghu", null, Arrays.asList("9247826359", "8123731397"));
        Customer customer2 = new Customer(102, "Vihaan", "vihaan@gmail.com", Arrays.asList("365874122", "9856775"));

        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);//Optional.empty

        // Optional<String> emailOptional = Optional.of(customer1.getEmail());
        // System.out.println(emailOptional); //throws NullPointerException

        Optional<String> emailOptinal2 = Optional.ofNullable(customer1.getEmail());
        System.out.println(emailOptinal2);// returns Optional.empty

        Optional<String> emailOptinal3 = Optional.ofNullable(customer2.getEmail());
        System.out.println(emailOptinal3);//Optional[vihaan@gmail.com]
        String email = emailOptinal3.get();
        System.out.println(email);//vihaan@gmail.com


        // create Optional customer object
        Optional<Customer> optionalCustomer1 = Optional.of(customer1);
        System.out.println(optionalCustomer1);//Optional[Customer [id=101, name=Raghu, email=null, phoneNumbers=[9247826359, 8123731397]]]

        //get customer name from optional
        System.out.println(optionalCustomer1.get().getName());//Raghu


        //orElse usage
        //https://www.geeksforgeeks.org/optional-orelse-method-in-java-with-examples/?ref=lbp

        String myEmail1 = "raghu3055@yahoo.co.in";
        String myEmail2 = null;
        Optional<String> myEmailOptional = Optional.ofNullable(myEmail1);
        System.out.println(myEmailOptional.orElse("default@gmail.com"));//raghu3055@yahoo.co.in

        //if value is null
        Optional<String> myEmailOptional2 = Optional.ofNullable(myEmail2);
        System.out.println(myEmailOptional2.orElse("default@gmail.com"));//default@gmail.com

        //orElseGet() -> public T orElseGet(Supplier<T> supplier)
        System.out.println(myEmailOptional2.orElseGet(() -> "NO Email")); //NO Email

        //orElseThrow
        myEmailOptional2.orElseThrow(() -> new RuntimeException("No email found!!"));

    }

}

@Setter
@Getter
@Data
@AllArgsConstructor
class Customer {
    private int id;
    private String name;
    private String email;
    private List<String> phoneNumbers;

}
