// NinjaCat class implementation
import java.awt.*;


public class NinjaCat extends Critter {
    /**
     * Returns the color of the NinjaCat, which is magenta.
     * 
     * @return Color.MAGENTA
     */
    public Color getColor() {
        return Color.MAGENTA; // Custom color
    }

    /**
     * Returns a string representation of the NinjaCat, which is "NC".  This
     * allows the user interface to distinguish NinjaCats from other critters.
     * 
     * @return "NC"
     */
    public String toString() {
        return "NC"; // Custom representation
    }

    /**
     * Determines the action that the NinjaCat should take based on the given
     * CritterInfo. If there is a threatening critter in front, it will infect.
     * If the space in front is empty, it will hop forward. If there is a wall
     * on either the left or right, it will turn right. Otherwise, it will turn
     * left.
     * 
     * @param info information about the current state of the simulation
     * @return the action that the NinjaCat should take
     */

    /**
     * Determines the action that the NinjaCat should take based on the given
     * CritterInfo. If there is a threatening critter in front, it will infect.
     * If the space in front is empty, it will hop forward. If there is a wall
     * on either the left or right, it will turn right. Otherwise, it will turn
     * left.
     * 
     * @param info information about the current state of the simulation
     * @return the action that the NinjaCat should take
     */
    public Action getMove(CritterInfo info) {
        if (info.frontThreat()) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else if (info.getLeft() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.RIGHT;
        } else {
            return Action.LEFT;
        }
    }
}