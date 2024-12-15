// Tiger class implementation
import java.awt.*;
import java.util.Random;


public class Tiger extends Critter {
    private static final Color[] COLORS = {Color.RED, Color.GREEN, Color.BLUE};
    private Color color;
    private int moveCount;

    public Tiger() {
        pickRandomColor();
        moveCount = 0;
    }

    /**
     * Pick a random color from the COLORS array.  This is used to
     * select a random color for the Tiger the first time it is
     * displayed and each time it moves a multiple of 3 steps.
     */
    private void pickRandomColor() {
        color = COLORS[new Random().nextInt(COLORS.length)];
    }

    /**
     * Returns the color of the tiger.  The color will be one of the values
     * in the COLORS array, and will change each time the tiger moves a
     * multiple of 3 steps.  This is done by calling pickRandomColor() each
     * time the move count is a multiple of 3.
     * 
     * @return the color of the tiger
     */
    public Color getColor() {
        if (moveCount % 3 == 0) {
            pickRandomColor();
        }
        moveCount++;
        return color;
    }

    public String toString() {
        return "TGR";
    }

    /**
     * Returns the action that the tiger should take given the information in
     * the CritterInfo object.  If there is another critter in front of me,
     * I should infect it.  If there is empty space in front of me, I should
     * hop.  If there is a wall or another critter to my right, I should turn
     * left.  Otherwise, I should turn right.
     * 
     * @param info information about the current state of the simulation
     * @return the action that the tiger should take
     */
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }
}
