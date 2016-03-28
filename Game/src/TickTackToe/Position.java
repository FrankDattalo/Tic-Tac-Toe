package TickTackToe;

/**
 * Created by fjdat on 3/27/2016.
 */
public enum Position {
    Zero, One, Two, Three, Four, Five, Six, Seven, Eight;


    public static Position getPosition(int p) {
        switch (p) {
            case 0:
                return Position.Zero;
            case 1:
                return Position.One;
            case 2:
                return Position.Two;
            case 3:
                return Position.Three;
            case 4:
                return Position.Four;
            case 5:
                return Position.Five;
            case 6:
                return Position.Six;
            case 7:
                return Position.Seven;
            default:
                return Position.Eight;
        }
    }
};
