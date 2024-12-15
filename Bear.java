import java.awt.*;


// Bear class implementation
public class Bear extends Critter {
    private boolean polar;
    private boolean slash;

    public Bear(boolean polar) {
        this.polar = polar;
        this.slash = true; // Start with a slash
    }


    /**
     * Returns the color of the bear.
     * 
     * @return Color.WHITE if the bear is polar, otherwise Color.BLACK.
     */
    public Color getColor() {
        return polar ? Color.WHITE : Color.BLACK;
    }

    /**
     * Returns a string representation of the bear, which will be either
     * "/" or "\".  The slash direction will alternate between the two
     * possibilities with each call to this method.
     * 
     * @return either "/" or "\"
     */
    public String toString() {
        if (slash) {
            slash = false;
            return "/";
        } else {
            slash = true;
            return "\\";
        }
    }

    /**
     * Returns the action that the bear should take given the information in
     * the CritterInfo object.  If there is another critter in front of me,
     * I should infect it.  If there is empty space in front of me, I should
     * hop.  Otherwise, I should turn left.
     * 
     * @param info information about the current state of the simulation
     * @return the action that the bear should take
     */
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }
}