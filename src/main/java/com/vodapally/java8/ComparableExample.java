package com.vodapally.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
class Player implements Comparable<Player> {
    private String name;
    private Integer age;
    private Integer rank;

    @Override
    public int compareTo(Player p) {
        return (this.getName().compareTo(p.getName()));
    }
}

public class ComparableExample {

    public static void main(String[] args) {
        List<Player> footballTeam = new ArrayList<>();
        Player player1 = new Player("John", 59, 36);
        Player player2 = new Player("Roger", 67, 22);
        Player player3 = new Player("Steven", 45, 99);
        Player player4 = new Player("Anitha", 25, 29);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);
        footballTeam.add(player4);

        //approach - 1
        System.out.println("Sorting based on player name:");
        System.out.println("approach - 1");
        Collections.sort(footballTeam);
        footballTeam.stream().forEach(p -> System.out.println(p));

        System.out.println("------------------------------");

        //approach - 2
        System.out.println("approach - 2");
        footballTeam.stream().sorted().forEach(System.out::println);
        System.out.println("------------------------------");
    }


}
