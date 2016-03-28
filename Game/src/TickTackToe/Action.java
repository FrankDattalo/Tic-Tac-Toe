package TickTackToe;

/**
 * Created by fjdat on 3/27/2016.
 */
public class Action {
    private Player player;
    private Position position;

    public Action(Player player, Position position) {
        this.player = player;
        this.position = position;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Position getPosition() {
        return this.position;
    }

    public boolean equals(Action other) {
        if(other == null) {
            return false;
        }
        return this.player == other.player && this.position == other.position;
    }
}