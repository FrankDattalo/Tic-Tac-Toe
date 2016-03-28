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

    public Player getPlayer() { return this.player; }
    public Position getPosition() {
        return  this.position;
    }
}