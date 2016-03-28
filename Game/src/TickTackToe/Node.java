package TickTackToe;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by fjdat on 3/27/2016.
 */
public class Node {
    private Board boardState;
    private int utility;
    private List<Node> children;

    public Node(Node parent, Action previousAction) {
        if(parent != null) {
            this.boardState = new Board(parent.boardState, previousAction);
        } else {
            this.boardState = new Board();
        }
        this.children = new LinkedList<Node>();
    }

    public int build(State previous) {
        if(this.boardState.isTerminalCase()) {
            if(this.boardState.getPreviousMove().getPlayer() == Player.Human) {
                if(this.boardState.isWinningCase()) {
                    this.utility = -1;
                } else {
                    this.utility = 0;
                }
            } else {
                if(this.boardState.isWinningCase()) {
                    this.utility = 1;
                } else {
                    this.utility = 0;
                }
            }
        } else  {
            // Calculate intermediate node values
            if(previous == State.Maximum) { // current = Min
                for (Position openSpot:
                     this.boardState.getOpenPositions()) {
                    this.children.add(new Node(this, new Action(Player.Human, openSpot)));
                }
            } else { // current = Max

            }
        }
        return this.utility;
    }

    public Board getBoardState() {
        return  this.boardState;
    }
}
