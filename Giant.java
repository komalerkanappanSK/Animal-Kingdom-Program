// Giant class implementation
import java.awt.*;


public class Giant extends Critter {
    private static final String[] STATES = {"fee", "fie", "foe", "fum"};
    private int moveCount;

    public Giant() {
        moveCount = 0;
    }

    /**
     * Returns the color of the giant, which is always gray.
     *
     * @return Color.GRAY
     */
    public Color getColor() {
        return Color.GRAY;
    }

    /**
     * Returns a string representation of the giant, which cycles through the
     * strings "fee", "fie", "foe", and "fum" every 24 steps.
     *
     * @return one of the strings "fee", "fie", "foe", or "fum"
     */
    public String toString() {
        return STATES[(moveCount / 6) % STATES.length];
    }

    /**
     * Returns the action that the giant should take given the information in
     * the CritterInfo object.  If there is another critter in front of me, I
     * should infect it.  If there is empty space in front of me, I should hop.
     * Otherwise, I should turn right.
     *
     * @param info information about the current state of the simulation
     * @return the action that the giant should take
     */
    public Action getMove(CritterInfo info) {
        moveCount++;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }
}