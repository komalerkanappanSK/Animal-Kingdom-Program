// WhiteTiger class implementation
import java.awt.*;


public class WhiteTiger extends Tiger {
    private boolean hasInfected;

    public WhiteTiger() {
        hasInfected = false;
    }

    /**
     * Returns the color of the White Tiger, which is white.
     * 
     * @return Color.WHITE
     */
    public Color getColor() {
        return Color.WHITE;
    }

    /**
     * Returns a string representation of the White Tiger.  If the tiger has
     * infected another critter, this method returns "TGR".  Otherwise, it
     * returns "tgr".  This allows the user interface to distinguish
     * between infected and uninfected tigers.
     * 
     * @return "TGR" if the tiger has infected another critter, "tgr" otherwise.
     */
    public String toString() {
        return hasInfected ? "TGR" : "tgr";
    }

    /**
     * Returns the action that the White Tiger should take given the information in
     * the CritterInfo object.  If there is another critter in front of me, I should
     * infect it.  Otherwise, I should do what a normal tiger would do.
     * 
     * @param info information about the current state of the simulation
     * @return the action that the White Tiger should take
     */
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            hasInfected = true;
            return Action.INFECT;
        }
        return super.getMove(info);
    }
}