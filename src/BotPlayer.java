/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bjock1
 */
public class BotPlayer extends Player {
public BotPlayer(String name) { super(name); }

@Override
public boolean decideToCall(int cost, boolean preFlop, Card[] board) {
if (!inHand || money < cost) return false;

if (preFlop) {
int strength = holeCards.get(0).getValue() + holeCards.get(1).getValue();
return strength >= 13; // only good hands call preflop
}

int rank = HandEvaluator.evaluate(this, board);
if (rank >= 4) return true; // monster hands
if (rank == 3) return Math.random() < 0.85;
return Math.random() < 0.75;
}
}
