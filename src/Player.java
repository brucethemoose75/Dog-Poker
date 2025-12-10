/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bjock1
 */
import java.util.*;

public abstract class Player {
protected String name;
protected ArrayList<Card> holeCards = new ArrayList<>();
protected int money = 100;
protected boolean inHand = true;

public Player(String name) { this.name = name; }

public abstract boolean decideToCall(int cost, boolean isPreFlop, Card[] board);

public void receiveCard(Card c) { holeCards.add(c); }
public void pay(int amount) { money -= amount; }
public void win(int amount) { money += amount; }
public void fold() { inHand = false; }
public boolean isInHand() { return inHand; }
public int getMoney() { return money; }
public String getName() { return name; }
public ArrayList<Card> getHoleCards() { return holeCards; }

public void resetForNewHand(){
        holeCards.clear();
        inHand=true;
    }
}