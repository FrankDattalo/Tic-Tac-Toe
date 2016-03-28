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
        if (parent != null) {
            this.boardState = new Board(parent.boardState, previousAction);
        } else {
            this.boardState = new Board();
        }
        this.children = new LinkedList<Node>();
        this.utility = 0;
    }

    public int build(State previous) {
        if (this.boardState.isTerminalCase()) {
            if (this.boardState.getPreviousMove().getPlayer() == Player.Human) {
                if (this.boardState.isWinningCase()) {
                    this.utility = -1;
                } else {
                    this.utility = 0;
                }
            } else {
                if (this.boardState.isWinningCase()) {
                    this.utility = 1;
                } else {
                    this.utility = 0;
                }
            }
        } else {
            // Calculate intermediate node values
            if (previous == State.Maximum) { // current = Min
                for (Position openSpot :
                        this.boardState.getOpenPositions()) {
                    Node n = new Node(this, new Action(Player.Human, openSpot));
                    this.children.add(n);
                    if (n.build(State.Minimum) < 0) {
                        this.utility--;
                    }
                }
            } else { // current = Max
                for (Position openSpot :
                        this.boardState.getOpenPositions()) {
                    Node n = new Node(this, new Action(Player.Computer, openSpot));
                    this.children.add(n);
                    if (n.build(State.Maximum) > 0) {
                        this.utility++;
                    }
                }
            }
        }
        return this.utility;
    }

    public Node getChildWithHighestUtility() {
        if (this.children.size() == 0) {
            return null;
        }
        int largestValue = Integer.MIN_VALUE;
        int largestIndex = 0;

        for (int i = 0; i < this.children.size(); i++) {
            if (largestValue < this.children.get(i).utility) {
                largestValue = this.children.get(i).utility;
                largestIndex = i;
            }
        }

        return this.children.get(largestIndex);
    }

    public Node getChildWithAction(Action action) {
        if(this.children.size() == 0) {
            return null;
        }
        for(Node child :
                this.children) {
            if(child.getBoardState().getPreviousMove().equals(action)) {
                return child;
            }
        }
        return null;
    }

    public Board getBoardState() {
        return this.boardState;
    }
}
