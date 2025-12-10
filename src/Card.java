/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bjock1
 */
public class Card {
private final String rank;
private final String suit;

public Card(String rank, String suit) {
this.rank = rank;
this.suit = suit;
}

// THIS IS THE ONLY METHOD THAT MATTERED
public int getValue() {
return switch (rank) {
case "A" -> 14;
case "K" -> 13;
case "Q" -> 12;
case "J" -> 11;
case "10" -> 10;
default -> Integer.parseInt(rank); // 2–9
};
}

public String getRank() { return rank; }
public String getSuit() { return suit; }

@Override
public String toString() {
return rank + suit.charAt(0); // e.g. "JH", "8D", "AC"
}
}
