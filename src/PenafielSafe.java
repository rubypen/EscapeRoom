import java.util.Date;

public class PenafielSafe {

    public static final String RED = "\u001B[31m";
    /* 
    Attributes
boolean locked: to know if the safe is locked or not
boolean hasPotion: to know if potion is still in the safe or not
boolean open: to know if the safe was opened 
CombinationLock combinationLock;
int shakeCount;

Methods
void look(): “You see a safe”;
void examine(): Depicts whether or not the safe is locked or open and if the potion is in the safe
void unlock(): Unlocks the safe if correct code is written.Unlimited chances to try and unlock safe.
void open():  The safe will open if the safe was unlocked. 
boolean shake(): A narration will appear and warn the user that the safe contains something fragile. If it is shaken 3x the user hears glass shatter and the game ends. True-game over False- Game not over
boolean takePotion(): This handles taking the potion from the safe. If locked is false and open is true the user takes potion and drinks potion. True-they took potion.
void tellTime()//to trick user if they didn't the instructions properly.
	
    */
    //S1)Instance Variables
    private boolean locked;
    private boolean hasPotion;//True-safe has potion False-player has potion
    private boolean open;
    private CombinationLock THElock;
    private int shakeCount;

    //S2)Constructor 
    public PenafielSafe() {
        Date today = new Date();
        int HourN = today.getHours();
        int minN = today.getMinutes();
        String code = HourN + ":" + minN;
        int C = code.indexOf(":");
        String beforeC = code.substring(0, C);
        String afterC = code.substring(C + 1);
        if (beforeC.length() != 2 && afterC.length() != 2) {
            code = "0" + beforeC + ":" + "0" + afterC;
        } else if (beforeC.length() != 2) {
            code = "0" + beforeC + ":" + afterC;
        } else if (afterC.length() != 2) {
            code = beforeC + ":0" + afterC;
        }

        open = false;
        locked = true;
        hasPotion = true;
        THElock = new CombinationLock(code);
        shakeCount = 0;
    }

    //S3)toString
    public String toString() {
        String output;

        output = "open: " + open + "\nlocked: " + locked + "\nhasPotion: " + hasPotion
                + "\nshakeCount: " + shakeCount;

        return output;
    }

    //S4)4 accessors
    public boolean getOpen() {
        return open;
    }

    public boolean getLocked() {
        return locked;
    }

    public boolean getHasPotion() {
        return hasPotion;
    }

    public CombinationLock getTHElock() {
        return THElock;
    }

    public int getShakeCount() {
        return shakeCount;
    }

    //S5 interesting methods
    public void look() {
        System.out.println("-A safe.");
    }

    public void examine() {
        if (locked == false && open && hasPotion)//open and contains potion
        {
            System.out.println("An open safe containing a shrinking potion");
        } else if (locked == false && open && hasPotion == false)//open with no potion
        {
            System.out.println("An open safe containing nothing.");
        } else if (locked == false && open == false) {
            System.out.println("A closed, but unlocked safe.");
        } else {
            System.out.println("A locked safe.");
        }
    }

    public boolean shake()//return false if game is not over. true if game is over
    {
        boolean output;

        if (hasPotion == false) {
            System.out.println(
                    "You shake the empty safe.");//no increase in shakeCount because the potion isn't at risk of breaking.
            output = false;
        } else if (open == true || locked == false) {
            System.out.println(
                    "YOU CAN'T DO THAT.");//no shakeCount increase because I don't allow the safe to be shaken when open.
            output = false;
        } else if (shakeCount == 0) {
            System.out.println(
                    "You shake the safe and hear something glasslike inside. You might want to be careful.");
            shakeCount++;
            output = false;
        } else if (shakeCount == 1) {
            System.out.println("You shake the safe. You might not want to keep shaking it.");
            shakeCount++;
            output = false;
        } else if (shakeCount == 2) {
            System.out.println(
                    "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println(RED
                    + "GAME OVER: You hear glass shatter. YOU BROKE YOUR ONLY CHANCE TO ESCAPE!");
            shakeCount++;
            output = true;//K.O ENDGAME
        } else {
            System.out.println("Good game :/");//useless, just for testing.
            output = true;
        }

        return output;
    }

    public void unlock() {
        boolean success = THElock.unlock();
        if (success == true && locked) {
            System.out.println("You unlocked the safe :).");
            locked = false;
        } else if (locked == false) {
            System.out.println("You already unlocked the safe.");
        } else {
            System.out.println("You entered the wrong password. The safe is still locked.");
        }
    }

    public void open() {

        if (THElock.isUnlocked() && open == false) {
            System.out.println(
                    "You open the safe and see a shrinking potion within. Maybe it can help you fit through\nthe miniature door.");
            open = true;
        } else if (THElock.isUnlocked() && open) {
            System.out.println("You already opened the safe.");
        } else {
            System.out.println("Try unlocking the safe first, wise guy.");
        }
    }

    public boolean takePotion() {
        boolean output;

        if (open && hasPotion) {
            System.out.println(
                    "You take the potion out of the safe and drink it. You, along with everything in the\nroom except for the door shrink and are now small enough to go through the miniature door."); //The game will end if they take potion before opening miniature door.
            hasPotion = false;
            output = true;
        } else if (open && hasPotion == false) {
            System.out.println("You already took the potion.");
            output = true;
        } else {
            System.out.println("What potion??");
            output = false;
        }

        return output;
    }

    public void tellTime() {
        Date today = new Date();
        int HourN = today.getHours();
        int minN = today.getMinutes();
        String Fcode = HourN + ":" + minN;
        int C = Fcode.indexOf(":");
        String beforeC = Fcode.substring(0, C);
        String afterC = Fcode.substring(C + 1);
        if (beforeC.length() != 2 && afterC.length() != 2) {
            Fcode = "0" + beforeC + ":" + "0" + afterC;
        } else if (beforeC.length() != 2) {
            Fcode = "0" + beforeC + ":" + afterC;
        } else if (afterC.length() != 2) {
            Fcode = beforeC + ":0" + afterC;
        }
        System.out.println(Fcode);
    }


}