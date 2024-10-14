public class PenafielRubberDuck {
    /*
        Attributes
boolean sliced: to know if the duck has been cut yet in order to access the key
boolean containsKey: to know if the key is still in the duck or not. False=player has key         True=duck has the key
        Methods
void look(): the player sees a rubberDuck
void examine(): Describes the duck in detail
void shakeDuck(): Describes the sounds of a metal object~maybe the key~
void sliceDuck(boolean userBlade): Takes care of slicing the duck in half to access a key. Sliced is no longer false. If the user doesn’t have a blade they are unable to cut the duck.
boolean takeKey(): Takes care of obtaining the key
    */

    //S1- declaring instace vars
    private boolean sliced;
    private boolean containsKey;

    //S2- constructor
    public PenafielRubberDuck() {
        sliced = false;
        containsKey = true;
    }

    //S3 toString Method
    public String toString() {
        String output;
        output = "sliced: " + sliced + "\ncontainsKey: " + containsKey;
        return output;
    }

    //S4-Accessors
    public boolean getSliced() {
        return sliced;
    }

    public boolean getContainKey() {
        return containsKey;
    }

    //S5 Interesting methods
    public void look() {
        System.out.println("-A rubber duck.");
    }

    public void examine() {
        if (sliced && containsKey) {
            System.out.println("A sliced duck containing a key.");
        } else if (sliced && containsKey == false) {
            System.out.println("A sliced duck containing nothing.");
        } else {
            System.out.println("A perfectly intact(unharmed) rubber duck.");
        }
    }

    public void shake() {
        int rand = (int) (Math.random() * 3 + 1);

        if (rand == 1) {
            System.out.println(
                    "You shake the rubber duck and hear a peculiar metal like rattle within it.");
        } else if (rand == 2) {
            System.out.println(
                    "You shake the duck and hear a key like jingle. Maybe somethings inside...");
        } else {
            System.out.println("You shake the rubber duck. Hmmm...sounds like a key.");
        }
    }

    public void sliceDuck(boolean userBlade) {
        if (userBlade && sliced == false) {
            System.out.println("You carefully cut the rubber duck.");
            sliced = true;
        } else if (userBlade && sliced == true) {
            System.out.println("You already sliced the duck you sadist! >:(");
        } else {
            System.out.println("How do you expect to slice this duck? With your finger nails?");
        }
    }

    public boolean takeKey() {
        boolean output;

        if (sliced && containsKey) {
            System.out.println("You take the key and open the miniature mouse door.");
            containsKey = false;
            output = true;
        } else if (sliced && containsKey == false) {
            System.out.println("You already took the key.");
            output = true;
        } else {
            System.out.println("What key can you possibly be talking about??");
            output = false;
        }

        return output;
    }
}