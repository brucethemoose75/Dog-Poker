/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bjock1
 */
import java.util.*;

public class Deck {
    private List<Card> cards = new ArrayList<>();
    private int next = 0;

    public Deck() {
        String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        String[] suits = {"♠","♥","♦","♣"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(rank, suit));
            }
        }
    Collections.shuffle(cards);
}

public Card deal() {
return cards.remove(cards.size() - 1);
}

public void burn() {
    if (!cards.isEmpty()) {
        cards.remove(cards.size() - 1);
    }
}
}
