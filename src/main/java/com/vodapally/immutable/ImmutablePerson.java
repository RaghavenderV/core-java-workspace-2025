package com.vodapally.immutable;

import lombok.ToString;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@ToString
public final class ImmutablePerson {
    private final String name;
    private final int age;
    private final Date birthDate; // mutable object
    private final List<String> hobbies;

    // constructor initializes all fields
    public ImmutablePerson(String name, int age, Date birthDate, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.birthDate = new Date(birthDate.getTime());
        // create a new list to ensure immutability
        this.hobbies = List.copyOf(hobbies);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<String> getHobbies() {
        // return an unmodifiable view of the list
        return Collections.unmodifiableList(hobbies);
    }

    public static void main(String[] args) {
        Date birthDate = new Date();
        List<String> hobbies = List.of("playing", "coding", "cooking");
        ImmutablePerson person = new ImmutablePerson("Raghavender", 41, birthDate, hobbies);
        //hobbies.add("reading"); //you can not modify immutable object once it is created
        System.out.println("person = " + person);
    }

}
