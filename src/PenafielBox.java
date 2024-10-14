/**
 * This class represents a Box
 */
public class PenafielBox implements BoxInterface {

    // S1 - Instance variables
    private boolean openFlag; // true if the box is open, false if closed
    private boolean containsBlade; // true if the blade is still in the box, false otherwise

    // S2 - Constructor(s)
    public PenafielBox() {
        openFlag = false;
        containsBlade = true;

    }

    // S3 - toString method
    public String toString() {
        return "openFlag: " + openFlag + "\ncontainsBlade: " + containsBlade;
    }

    // S4 - Accessors
    public boolean getOpen() {
        return openFlag;
    }

    public boolean getContainsBlade() {
        return containsBlade;
    }

    // S5 - Interesting Method(s)

    @Override
    public void look() {
        System.out.println("-A box.");
    }

    @Override
    public void examine() {
        if (!openFlag) {
            System.out.println("A box that is closed.");
        } else if (containsBlade)//Open + box has blade means user doesn't have the blade yet
        {
            System.out.println("An open box containing a blade.");
        } else {
            System.out.println("An open box containing nothing.");
        }
    }

    @Override
    public void open() {
        if (openFlag) {
            System.out.println("You already opened the box.");
        } else {
            System.out.println("You open the box.");
            openFlag = true;
        }

    }

    @Override
    public void close() {
        if (openFlag) {
            System.out.println("You close the box ever so gracefully.");
            openFlag = false;
        } else {
            System.out.println(
                    "You realize you're an idiot for trying to close a box that is already closed.");
        }
    }

    @Override
    public boolean takeBlade() {
        boolean output;

        if (openFlag && containsBlade) {
            System.out.println("You take the blade from the box.");
            containsBlade = false;
            output = true;
        } else if (openFlag && !containsBlade) {
            System.out.println("...You already took the blade.");
            output = true;
        } else {
            System.out.println("What blade?");
            output = false;
        }

        return output;
    }


}

interface BoxInterface {

    /**
     * Outputs a message indicating that the user sees a box.
     */
    void look();

    /**
     * Outputs the current state of the box. If the Box is open, it specifies whether it contains a
     * blade.
     */
    void examine();

    /**
     * Opens box and displays a narration describing this action
     */
    void open();

    /**
     * Closes box and displays a narration describing this action
     */
    void close();

    /**
     * Attempts to take the blade from the box
     *
     * @return true if the box contains the blade and is open, false otherwise
     */
    boolean takeBlade();
}