
public class PenafielLamp {
    /*
    Lamp class:
Attributes
boolean fixed:to know if the lamp is fixed or not
int position: to know where the user is in the task. The player only has 10 moves each try.
int chances: to know how many more chances the user has left to conclude the task. Only 5 chances. When chances are at 0, they lose the game. You lose a chance when you make one wrong move.
String currentAppearance: to know how the lamp looks at the current time
    
Methods
void look(): the player sees a lamp
void examine(): shows the lamps current stature. If it's broken it will show how broken it is. If it's fixed it will show itself fixed. currentAppearance will be used to show the lamp's appearance after any changes have been done to it.
void plugLamp():To tell player what the safe code is
boolean playerMove(String move): The player has options to move left or right.  When the boolean is true the game is over. When it is false the game isn't over. 

    
    */

    public static final String CYAN = "\u001B[36m";
    public static final String BLACK = "\u001B[30m";

    //S1)instance vars
    private boolean fixed;
    private int position;
    private int chances;
    private String currentAppearance;

    //S2)constructor
    public PenafielLamp() {
        fixed = false;
        position = 0;//broken position
        chances = 5;
        currentAppearance = "   ___   " + CYAN + "|" + BLACK
                + "___\n  /    \\\n /            \\\n ----- -----\n      |           \n      |      \n     ===   ";
    }

    //S3) toString
    public String toString() {
        String output;
        output = "fixed : " + fixed + "\nposition : " + position + "\nchances : " + chances
                + "\ncurrentAppearance :\n" + currentAppearance;
        return output;
    }

    //S4) 4 accessors
    public boolean getFixed() {
        return fixed;
    }

    public int getposition() {
        return position;
    }

    public int getChances() {
        return chances;
    }

    public String getcurrentAppearance() {
        return currentAppearance;
    }

    //S5 Interesting methods
    public void look() {
        System.out.println("-A lamp.");
    }

    public void examine() {
        if (fixed == false && chances > 0) {
            System.out.println("The lamp looks like:\n" + currentAppearance
                    + "\nYou can try to fix it by commanding \"fix lamp\".");
        } else if (fixed == false && chances == 0) {
            System.out.println("A lamp you failed to fix.\n"
                    + currentAppearance);//useless but I put it there just for testing
        } else {
            System.out.println(
                    "The lamp you fixed looks like the following:\n" + currentAppearance);
        }
    }

    public boolean playerMove(String move) {
        //all positions
        //pos 0 is the lamp fully broken
        String pos1 = "   ___  " + CYAN + "|" + BLACK
                + "___\n  /     \\\n /             \\\n ----- -----\n      |           \n      |      \n     ===   ";//left
        String pos2 = "   ___ " + CYAN + "|" + BLACK
                + "___\n  /     \\\n /             \\\n ----- -----\n      |           \n      |      \n     ===   ";//left
        String pos3 = "   ______\n  /" + CYAN + "|" + BLACK
                + "   \\\n /             \\\n ----- -----\n      |           \n      |      \n     ===   ";//left
        String pos4 = "   ______\n  /" + CYAN + " |" + BLACK
                + "   \\\n /             \\\n ----- -----\n      |           \n      |      \n     ===   ";//right
        String pos5 = "   ______\n  /      \\\n /" + CYAN + "       |" + BLACK
                + "    \\\n ----- -----\n      |           \n      |      \n     ===   ";//right
        String pos6 = "   ______\n  /      \\\n /" + CYAN + "      |" + BLACK
                + "    \\\n ----- -----\n      |           \n      |      \n     ===   ";//left
        String pos7 = "   ______\n  /      \\\n /" + CYAN + "     |" + BLACK
                + "    \\\n ----- -----\n      |           \n      |      \n     ===   ";//left
        String pos8 = "   ______\n  /      \\\n /" + CYAN + "    |" + BLACK
                + "    \\\n ----- -----\n      |           \n      |      \n     ===   ";//left
        String pos9 = "   ______\n  /      \\\n /        \\\n -----" + CYAN + " |" + BLACK
                + "-----\n      |           \n      |      \n     ===   ";//left
        //String pos10 = "   ___\\___\n  /   /   \\\n /    \\    \\\n -----/-----\n      |           \n      |      \n     ===   ";//left ~cancelled~ just return fixed lamp

        boolean output = false;//game is not over

        if (position == 0 && chances != 0) {
            if (move.equals("left")) {
                currentAppearance = pos1;
                position++;
                System.out.println("Nice!");
                System.out.println(currentAppearance);
            } else {
                chances--;
                System.out.println("Wrong move. You have " + chances + " chances left.");
                if (chances == 0) {
                    output = true;
                }
            }
        } else if (position == 1 && chances != 0) {
            if (move.equals("left")) {
                currentAppearance = pos2;
                position++;
                System.out.println("Great!");
                System.out.println(currentAppearance);
            } else {
                chances--;
                System.out.println("Wrong move. You have " + chances + " chances left.");
                if (chances == 0) {
                    output = true;
                }
            }
        } else if (position == 2 && chances != 0) {
            if (move.equals("left")) {
                currentAppearance = pos3;
                position++;
                System.out.println("Magnificent!");
                System.out.println(currentAppearance);
            } else {
                chances--;
                System.out.println("Wrong move. You have " + chances + " chances left.");
                if (chances == 0) {
                    output = true;
                }
            }
        } else if (position == 3 && chances != 0) {
            if (move.equals("right")) {
                currentAppearance = pos4;
                position++;
                System.out.println("Noice dude!");
                System.out.println(currentAppearance);
            } else {
                chances--;
                System.out.println("Wrong move. You have " + chances + " chances left.");
                if (chances == 0) {
                    output = true;
                }
            }
        } else if (position == 4 && chances != 0) {
            if (move.equals("right")) {
                currentAppearance = pos5;
                position++;
                System.out.println("Well done.");
                System.out.println(currentAppearance);
            } else {
                chances--;
                System.out.println("Wrong move. You have " + chances + " chances left.");
                if (chances == 0) {
                    output = true;
                }
            }
        } else if (position == 5 && chances != 0) {
            if (move.equals("left")) {
                currentAppearance = pos6;
                position++;
                System.out.println("Good!");
                System.out.println(currentAppearance);
            } else {
                chances--;
                System.out.println("Wrong move. You have " + chances + " chances left.");
                if (chances == 0) {
                    output = true;
                }
            }
        } else if (position == 6 && chances != 0) {
            if (move.equals("left")) {
                currentAppearance = pos7;
                position++;
                System.out.println("Nice!");
                System.out.println(currentAppearance);
            } else {
                chances--;
                System.out.println("Wrong move. You have " + chances + " chances left.");
                if (chances == 0) {
                    output = true;
                }
            }
        } else if (position == 7 && chances != 0) {
            if (move.equals("left")) {
                currentAppearance = pos8;
                position++;
                System.out.println("Great!");
                System.out.println(currentAppearance);
            } else {
                chances--;
                System.out.println("Wrong move. You have " + chances + " chances left.");
                if (chances == 0) {
                    output = true;
                }
            }
        } else if (position == 8 && chances != 0) {
            if (move.equals("left")) {
                currentAppearance = pos9;
                position++;
                System.out.println("Perfect!");
                System.out.println(currentAppearance);
            } else {
                chances--;
                System.out.println("Wrong move. You have " + chances + " chances left.");
                if (chances == 0) {
                    output = true;
                }
            }
        } else if (position == 9 && chances != 0) {
            if (move.equals("left")) {
                position++;
                fixed = true;
                currentAppearance = "   ______\n  /      \\\n /        \\\n ----------\n      |           \n      |      \n     ===   ";
                System.out.println(currentAppearance
                        + "\nGREAT JOB, you fixed it! You're one step closer to escaping.\nNow \"plug\" the lamp in the outlet.");
            } else {
                chances--;
                output = false;
                System.out.println("Wrong move. You have " + chances + " chances left.");
                if (chances == 0) {
                    output = true;
                }
            }
        } else if (fixed == true) {
            System.out.println("You already fixed it silly!");
            output = false;
        } else {
            System.out.println("Sorry mate, GAME OVER you couldn't fix it.");//the person lost.
            output = true;
        }

        return output;
    }

    public void plugLamp() {
        if (fixed == true) {
            System.out.println(
                    "*You plug in the lamp.*\n\nThe code to the safe is the time you STARTED the game in military time. Format: ##:##\n\n*You unplug the lamp.*");
        } else {
            System.out.println("You can't plug in the broken lamp. You'll spark a fire!");
        }
    }


}