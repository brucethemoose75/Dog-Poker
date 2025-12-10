/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bjock1
 */
public class HumanPlayer extends Player {
public HumanPlayer(String name) { super(name); }
@Override
public boolean decideToCall(int cost, boolean isPreFlop, Card[] board) {
// We'll replace this with GUI buttons later – for now just always call
return true;
}
}