/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bjock1
 */
import java.util.*;

public class HandEvaluator {
public static int evaluate(Player p, Card[] board) {
List<Card> all = new ArrayList<>(p.getHoleCards());
for (Card c : board) if (c != null) all.add(c);

if (isRoyalFlush(all)) return 10;
if (isStraightFlush(all)) return 9;
if (hasFourOfAKind(all)) return 8;
if (isFullHouse(all)) return 7;
if (isFlush(all)) return 6;
if (isStraight(all)) return 5;
if (hasThreeOfAKind(all)) return 4;
if (hasTwoPair(all)) return 3;
if (hasPair(all)) return 2;
return 1;
}

public static String handName(int rank) {
String[] names = {"", "High Card", "Pair", "Two Pair", "Three of a Kind",
"Straight", "Flush", "Full House", "Four of a Kind",
"Straight Flush", "Royal Flush"};
return names[rank];
}

private static int[] counts(List<Card> cards) {
int[] c = new int[15];
for (Card card : cards) c[card.getValue()]++;
return c;
}

private static boolean isFlush(List<Card> cards) {
Map<String, Integer> suits = new HashMap<>();
for (Card c : cards) suits.merge(c.getSuit(), 1, Integer::sum);
return suits.values().stream().anyMatch(v -> v >= 5);
}

private static boolean isStraight(List<Card> cards) {
Set<Integer> vals = new HashSet<>();
for (Card c : cards) {
int v = c.getValue();
vals.add(v);
if (v == 14) vals.add(1);
}
int streak = 0;
for (int i = 1; i <= 14; i++) {
if (vals.contains(i)) streak++;
else streak = 0;
if (streak >= 5) return true;
}
return false;
}

private static boolean isRoyalFlush(List<Card> c) { return isFlush(c) && isStraight(c) && c.stream().anyMatch(card -> card.getValue() == 14); }
private static boolean isStraightFlush(List<Card> c) { return isFlush(c) && isStraight(c); }
private static boolean hasFourOfAKind(List<Card> c) { return Arrays.stream(counts(c)).anyMatch(v -> v == 4); }
private static boolean isFullHouse(List<Card> c) { int[] cnt = counts(c); return Arrays.stream(cnt).anyMatch(v -> v == 3) && Arrays.stream(cnt).anyMatch(v -> v == 2); }
private static boolean hasThreeOfAKind(List<Card> c) { return Arrays.stream(counts(c)).anyMatch(v -> v == 3); }
private static boolean hasTwoPair(List<Card> c) { return Arrays.stream(counts(c)).filter(v -> v == 2).count() == 2; }
private static boolean hasPair(List<Card> c) { return Arrays.stream(counts(c)).anyMatch(v -> v == 2); }
}
