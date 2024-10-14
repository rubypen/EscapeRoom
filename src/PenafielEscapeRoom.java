import java.util.Scanner;

public class PenafielEscapeRoom {
    /* User friendly because:
      ~Equivalent commands~
      -grab and take
      -grab, take and drink can be used as verbs when potion is the noun
      -duck and rubber duck
      -cut and slice
      -for user to understand their position on the lamp it is colored in cyan
    */

    //Colors - I kept them as public because that is how it was displayed in the Youtube video
    public static final String CYAN = "\u001B[36m";
    public static final String BLACK = "\u001B[30m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";

    //S1-INSTANCE VARS
    private boolean hasBlade, hasKey, fixedLamp, tookPotion;

    private PenafielBox Box;
    private PenafielRubberDuck Duck;
    private PenafielLamp Lamp;
    private PenafielSafe Safe;

    private boolean gameOver;

    //S2-CONSTRUCTORS
    public PenafielEscapeRoom() {
        //assigning all attributes
        Box = new PenafielBox();
        Duck = new PenafielRubberDuck();
        Lamp = new PenafielLamp();
        Safe = new PenafielSafe();

        hasBlade = false;
        hasKey = false;
        fixedLamp = false;
        tookPotion = false;

        gameOver = false;
    }

    //S5-INTERESTING METHODS
    //1) lookAround()
    //2) play()

    public void lookAround() {
        System.out.println("In this confined metal room there is...");
        Box.look();
        Duck.look();
        Lamp.look();
        Safe.look();
    }

    public void play() {
        //user Input
        String nextLine;

        //first Word
        String verb;

        //the Noun
        String noun;

        //the Space
        int spacePos;

        //ScannerObject
        Scanner inScanner = new Scanner(System.in);

        //======================================================================
        //STARTING THE GAME
        System.out.print("Start time : ");
        Safe.tellTime();
        System.out.println(
                "--------------------------------------------------------------------------------------");
        System.out.println("~WELCOME TO THE PENAFIEL ESCAPE ROOM~");
        System.out.println(
                "--------------------------------------------------------------------------------------");
        System.out.println(
                "You seem to have been kidnapped and confined to a large metal room with a locked door\nbig enough for a mouse...The last thing you remember is something yellow hitting you\nin the head and knocking you out. Quick, try to escape!");
        System.out.println(
                "--------------------------------------------------------------------------------------");
        System.out.println(
                "You can only enter 1 or 2 word commands.\nType \"HELP\" if you would like to know what commands you can give.");
        this.lookAround();

        //Beginning the loop
        while (!gameOver) {
            //In case the user already completed all tasks
            if (hasBlade == true && hasKey == true && fixedLamp == true && tookPotion == true) {
                System.out.println(
                        "--------------------------------------------------------------------------------------");
                System.out.println(
                        "You have fulfilled all your tasks, type \"escape\" if you would like to leave.");
            }

            //prompting user for input
            System.out.println(
                    "======================================================================================");
            System.out.print("Please enter a command: ");

            //users command
            nextLine = inScanner.nextLine();

            //position of the space
            spacePos = nextLine.indexOf(" ");

            //determining if theres a space or not
            if (spacePos == -1)//there is no space, one word command
            {
                //examples of input: quit, look, help
                verb = nextLine;
                noun = "";//this means
            } else {
                //2 word command
                //examples: examine dog, annoy fido, steal bone
                verb = nextLine.substring(0, spacePos);
                noun = nextLine.substring(spacePos + 1);
            }

            //--------------------Taking care of commands-----------------------
            if (verb.equalsIgnoreCase("quit")) {
                System.out.print("End time : ");
                Safe.tellTime();
                System.out.println(
                        "--------------------------------------------------------------------------------------");
                System.out.println("Bye thanks for playing :).");
                gameOver = true;
            } else if (verb.equalsIgnoreCase("help")) {
                System.out.println(
                        "Commands that may be used: quit, examine, look, shake, unlock, open, close, slice,\ntake, plug, tell time.");
            } else if (verb.equalsIgnoreCase("look")) {
                this.lookAround();
            } else if (verb.equalsIgnoreCase("examine")) {
                //nested chain
                if (noun.equalsIgnoreCase("box")) {
                    Box.examine();
                } else if (noun.equalsIgnoreCase("duck") || noun.equalsIgnoreCase("rubber duck")) {
                    Duck.examine();
                } else if (noun.equalsIgnoreCase("lamp")) {
                    Lamp.examine();
                } else if (noun.equalsIgnoreCase("safe")) {
                    Safe.examine();
                } else {
                    System.out.println("Sorry, you can not examine " + noun + ".");
                }
            } else if (verb.equalsIgnoreCase("fix") && noun.equalsIgnoreCase("lamp")) {
                System.out.println(
                        "--------------------------------------------------------------------------------------");
                System.out.println(
                        "~~~~~~~~~~~~~~~~~~~~~~~You are located where the" + (CYAN + "\"|\"")
                                + BLACK + "is~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                if (Lamp.getFixed() == true) {
                    fixedLamp = true;
                    Lamp.playerMove("move");//if player tries to fix when its fixed
                }

                while (!nextLine.equalsIgnoreCase("quit") && Lamp.getFixed() != true) {
                    if (!(Lamp.getChances() <= 0)) {
                        //asking which way player wants to move
                        System.out.println(
                                "--------------------------------------------------------------------------------------");
                        System.out.print("Would you like to move \"left\" or \"right\"? : ");
                        nextLine = inScanner.nextLine();//getting the users input

                        if (nextLine.equalsIgnoreCase("left")) {
                            Lamp.playerMove("left");
                        } else if (nextLine.equalsIgnoreCase("right")) {
                            Lamp.playerMove("right");
                        } else if (nextLine.equalsIgnoreCase("quit")) {
                            System.out.println("If you say so.");
                        } else {
                            System.out.println(
                                    "Sorry, you can't move to the " + nextLine + " direction.");
                        }

                        if (Lamp.getChances() <= 0) {
                            System.out.println(
                                    "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                            System.out.println(RED
                                    + "GAME OVER: You were required to fix the lamp to get closer to escaping, You failed :,(");
                            gameOver = true;
                        }
                    }
                }
                fixedLamp = true;
            } else if (verb.equalsIgnoreCase("plug")) {
                if (noun.equalsIgnoreCase("lamp")) {
                    Lamp.plugLamp();
                } else {
                    System.out.println("Sorry, you can not plug that.");
                }
            } else if (verb.equalsIgnoreCase("tell") && noun.equalsIgnoreCase(
                    "time"))//troll if person doesn't pay attention to instructions from plugged lamp
            {
                System.out.print("It is ");
                Safe.tellTime();
            } else if (verb.equalsIgnoreCase("open")) {
                if (noun.equalsIgnoreCase("box")) {
                    Box.open();
                } else if (noun.equalsIgnoreCase("safe")) {
                    Safe.open();
                } else {
                    System.out.println("Apologies, you can not open " + noun);
                }
            } else if (verb.equalsIgnoreCase("close") && noun.equalsIgnoreCase("box")) {
                Box.close();
            } else if (verb.equalsIgnoreCase("take") || verb.equalsIgnoreCase("drink")
                    || verb.equalsIgnoreCase("grab")) {
                if (noun.equalsIgnoreCase("blade") && !verb.equalsIgnoreCase("drink")) {
                    if (Box.takeBlade()) {
                        hasBlade = true;
                    }
                } else if (noun.equalsIgnoreCase("key") && !verb.equalsIgnoreCase("drink")) {
                    if (Duck.takeKey()) {
                        hasKey = true;
                    }
                } else if (noun.equalsIgnoreCase("potion")) {
                    if (Safe.takePotion()) {
                        tookPotion = true;
                    }
                } else {
                    if (verb.equalsIgnoreCase("drink")) {
                        System.out.println("Sorry you can't drink that.");
                    } else {
                        System.out.println("You can not take that.");
                    }
                }
            } else if (verb.equalsIgnoreCase("shake")) {
                if (noun.equalsIgnoreCase("duck") || noun.equalsIgnoreCase("rubber duck")) {
                    Duck.shake();
                } else if (noun.equalsIgnoreCase("safe")) {
                    if (Safe.shake()) {
                        gameOver = true;
                    }
                } else {
                    System.out.println("You can't shake the " + noun);
                }
            } else if (verb.equalsIgnoreCase("cut") || verb.equalsIgnoreCase("slice")) {
                if (noun.equalsIgnoreCase("duck") || noun.equalsIgnoreCase("rubber duck")) {
                    Duck.sliceDuck(hasBlade);
                } else {
                    System.out.println("You can't slice that.");
                }
            } else if (verb.equalsIgnoreCase("unlock")) {
                if (noun.equalsIgnoreCase("safe") || noun.equalsIgnoreCase("lock")) {
                    Safe.unlock();
                } else {
                    System.out.println("You can't unlock that.");
                }
            } else if (verb.equalsIgnoreCase(
                    "escape"))//Thought it would be good to ask the person if they wanted to escape or maybe look around
            {
                if (hasBlade == true && hasKey == true && fixedLamp == true && tookPotion == true) {
                    System.out.print("End time : ");
                    Safe.tellTime();
                    System.out.println(
                            "--------------------------------------------------------------------------------------");

                    int rand = (int) (Math.random() * 3 + 1);

                    if (rand == 1) {
                        System.out.println(
                                "YAY YOU ESCAPED! Wait...you're still tiny.\n*you get squished like a bug by a huge duck and die to your injuries*"
                                        + "\n                   _        _        _\n"
                                        + "                __(.)<   __(.)>   __(.)=\n"
                                        + "           /\\___\\___)_/\\_\\___)_/\\_\\___)_/\\_ "
                                        + "\nWelp that's unfortunate. \nX_X");
                    } else if (rand == 2) {
                        System.out.println(
                                "YUPEEE, YOU ESCAPED! YOU BREATHE IN THE SWEET FRESH AIR YOU'VE BEEN MISSING."
                                        + "              _\n" + RED +
                                        "                  _(_)_                          wWWWw   _\n"
                                        + RED +
                                        "      @@@@       (_)@(_)   vVVVv     _     @@@@  (___) _(_)_\n"
                                        + RED +
                                        "     @@()@@ wWWWw  (_)\\    (___)   _(_)_  @@()@@   Y  (_)@(_)\n"
                                        + RED +
                                        "      @@@@  (___)     `|/    Y    (_)@(_)  @@@@   \\|/   (_)\\\n"
                                        + GREEN +
                                        "       /      Y       \\|    \\|/    /(_)    \\|      |/      |\n"
                                        + GREEN +
                                        "    \\ |     \\ |/       | / \\ | /  \\|/       |/    \\|      \\|/\n"
                                        + GREEN
                                        + " \\\\|//   \\\\|///  \\\\\\|//\\\\\\|/// \\|///  \\\\\\|//  \\\\|//  \\\\\\|// \n"
                                        +
                                        GREEN
                                        + "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"
                                        + "\nThank for playing :D."); //ascii art I didn't make I thought it would make the ending cool
                    } else//found ascii duck art and edited it (from textart.io website)
                    {
                        System.out.println(
                                "WOOHOO, YOU ESCAPED! You magically return to your previous size and mosey along with\nyour day."
                                        + "\n\n                   \\       /            _\\/_\n" +
                                        "                     .-'-.              //o\\  _\\/_\n"
                                        + "  _  ___  __  _ --_ /     \\ _--_ __  __ _ | __/o\\\\ _\n"
                                        + "=-=-_=-=-_=-=_=-_= -=======- = =-=_=-=_,-'|\"'\"\"-|-,_ \n"
                                        +
                                        " =- _=-=-_=- _=-= _--=====- _=-=_-_,-\"          |\n"
                                        + "   =- =- =-= =- = -  -===- -= - .\"\n"
                                        + "\nThanks for playing!");
                    }

                    gameOver = true;
                } else if (hasBlade == true && hasKey == true && fixedLamp == true
                        && tookPotion == false) {
                    System.out.println(
                            "You can't leave yet, you have to shrink somehow to fit through the door.");
                } else if (hasBlade == true && hasKey == true && fixedLamp == false
                        && tookPotion == true) {
                    System.out.println("You can't leave yet, you have to fix the lamp.");
                } else if (hasBlade == true && hasKey == false && fixedLamp == true
                        && tookPotion == true || (hasBlade == false && fixedLamp == true
                        && tookPotion == true)) {
                    System.out.println("You can't leave yet, you need a key to open the door.");
                } else {
                    System.out.println("You can't leave yet, you still have some tasks to do.");
                }


            } else {
                System.out.println("INVALID COMMAND.");
            }

        }
    }


}
