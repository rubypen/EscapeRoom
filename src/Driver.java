public class Driver {

    public static void main(String[] args) {

        //declaring and instantiating a PenafielEscapeRoom and starting the game
        PenafielEscapeRoom PER = new PenafielEscapeRoom();
        PER.play();
    }
}

class DriverBuild {

    public static void main(String[] args) {
        /*testing the box class
          testing all possible outcomes using one box object
        */

        //declaring a box object
        System.out.println("==============================================================\n~BOX~");
        PenafielBox b1 = new PenafielBox();
        System.out.println(b1);

        //testing the accessors: should be the same as what prints when printing box
        System.out.println(b1.getOpen());
        System.out.println(b1.getContainsBlade() + "\n");

        //testing the look and examine methods
        b1.look();
        b1.examine();

        //Testing takeBlade to test if it is false which it should be
        boolean tb1 = b1.takeBlade();
        System.out.println("Take blade1 = " + tb1 + "\n");

        //Opening box twice to test if outputs are functioning correctly
        b1.open();
        b1.open();

        //printing/examining my box to observe if correct changes were made
        System.out.println(b1);
        b1.examine();

        //testing the accessors:
        System.out.println(b1.getOpen());
        System.out.println(b1.getContainsBlade() + "\n");

        //Trying to take blade from box now that it is open
        boolean tb2 = b1.takeBlade();
        System.out.println("Take blade2 = " + tb2);

        //testing the accessors:
        System.out.println(b1.getOpen());
        System.out.println(b1.getContainsBlade() + "\n");

        //printing and examining my box to observe if the correct changes were made
        System.out.println(b1);
        b1.examine();

        //Testing takeBlade again. Should be true.
        boolean tb3 = b1.takeBlade();
        System.out.println("Take blade3 = " + tb3 + "\n");

        //testing close method to test the designated outputs
        b1.close();
        b1.close();
        System.out.println("\n" + b1);

        //testing the accessors:
        System.out.println(b1.getOpen());
        System.out.println(b1.getContainsBlade());

        //======================================================================
        System.out.println(
                "================================================================\n~RUBBERDUCK~");

        //Declaring a Rubber duck object
        PenafielRubberDuck quack = new PenafielRubberDuck();
        System.out.println(quack);

        //testing the look method then examine method
        quack.look();
        quack.examine();

        //testing the shake method
        quack.shake();
        quack.shake();
        System.out.println("");

        //testing the slice duck method and takeKey()
        boolean haveB = b1.getContainsBlade();
        if (haveB
                == false)//if containsBlade is false, haveB needs to become true because the box no longer has the blade
        {
            haveB = true;
        } else {
            haveB = false;
        }

        boolean take1 = quack.takeKey();
        System.out.println("take1 = " + take1);
        quack.sliceDuck(false);
        quack.sliceDuck(haveB);
        quack.sliceDuck(haveB);
        quack.examine();
        System.out.println("");

        //testing the takeKey method
        boolean take2 = quack.takeKey();
        System.out.println("take2 = " + take2);
        boolean take3 = quack.takeKey();
        System.out.println("take3 = " + take3);
        quack.examine();

        //===================================================================================================
        System.out.println(
                "=================================================================================\n~LAMP~");

        //Declaring a Lamp object l1--------------
        PenafielLamp l1 = new PenafielLamp();
        System.out.println(l1 + "\n");

        l1.examine();
        System.out.println("");

        boolean move1 = l1.playerMove("left");
        System.out.println("gameover = " + move1);
        l1.examine();

        boolean mbad = l1.playerMove("right");
        System.out.println("gameover = " + mbad);
        l1.examine();

        boolean move2 = l1.playerMove("left");
        System.out.println("gameover = " + move2);
        l1.examine();

        boolean move3 = l1.playerMove("left");
        System.out.println("gameover = " + move3);
        l1.examine();

        boolean move4 = l1.playerMove("right");
        System.out.println("gameover = " + move4);
        l1.examine();

        boolean move5 = l1.playerMove("right");
        System.out.println("gameover = " + move5);
        l1.examine();

        boolean move6 = l1.playerMove("left");
        System.out.println("gameover = " + move6);
        l1.examine();

        boolean move7 = l1.playerMove("left");
        System.out.println("gameover = " + move7);
        l1.examine();

        boolean move8 = l1.playerMove("left");
        System.out.println("gameover = " + move8);
        l1.examine();

        boolean move9 = l1.playerMove("left");
        System.out.println("gameover = " + move9);
        l1.examine();

        boolean move10 = l1.playerMove("left");
        System.out.println("gameover = " + move10);
        l1.examine();

        boolean move11 = l1.playerMove("left");
        System.out.println(l1 + "\n------------------------");

        //---------------------------------------
        //Declaring Lamp object l2 and testing if chances decrease
        PenafielLamp l2 = new PenafielLamp();

        l2.examine();

        boolean m1 = l2.playerMove("right");
        System.out.println("gameover = " + m1);
        l2.examine();

        boolean m2 = l2.playerMove("right");
        System.out.println("gameover = " + m2);
        l2.examine();

        boolean mgood = l2.playerMove("left");
        System.out.println("gameover = " + mgood);
        l2.examine();

        boolean m3 = l2.playerMove("right");
        System.out.println("gameover = " + m3);
        l2.examine();

        boolean m4 = l2.playerMove("right");
        System.out.println("gameover = " + m4);
        l2.examine();

        boolean m5 = l2.playerMove("right");
        System.out.println("gameover = " + m5);
        l2.examine();

        boolean m6 = l2.playerMove("right");
        System.out.println("gameover = " + m6);
        l2.examine();

        System.out.println(l2);

        //======================================================================
        System.out.println("=========================================================\n~SAFE~");

        //Declaring a Safe object
        PenafielSafe s1 = new PenafielSafe();
        s1.tellTime();
        System.out.println(s1);
        s1.examine();

        //trying to take potion without opening
        boolean tookP1 = s1.takePotion();
        System.out.println("tookP1 = " + tookP1 + "\n");

        //shaking safe
        boolean shk1 = s1.shake();
        System.out.println("gameover = " + shk1);
        s1.examine();
        System.out.println(s1 + "\n");

        //testing openSafe without unlocking it
        s1.open();
        s1.examine();
        System.out.println(s1 + "\n");

        //unlocking safe x2
        s1.unlock();
        boolean shk2 = s1.shake();
        System.out.println("gameover = " + shk2);
        s1.unlock();
        s1.examine();
        System.out.println(s1 + "\n");

        //shaking safe again
        boolean shk3 = s1.shake();
        System.out.println("gameover = " + shk3);
        s1.examine();
        System.out.println(s1 + "\n");

        //opening safe x2
        s1.open();
        s1.open();
        boolean shk4 = s1.shake();
        System.out.println("gameover = " + shk4);
        s1.examine();
        System.out.println(s1 + "\n");

        //taking potion
        boolean tookP2 = s1.takePotion();
        System.out.println("tookP2 = " + tookP2 + "\n");
        boolean tookP3 = s1.takePotion();
        System.out.println("tookP3 = " + tookP3);
        System.out.println("\n" + s1 + "\n");

        boolean shk5 = s1.shake();
        System.out.println("gameover = " + shk5);
        s1.examine();
        System.out.println(s1 + "\n");

        //Declaring a Safe object #2
        PenafielSafe s2 = new PenafielSafe();

        //shaking until gameover
        boolean sh1 = s2.shake();
        System.out.println("gameover = " + sh1);

        boolean sh2 = s2.shake();
        System.out.println("gameover = " + sh2);

        boolean sh3 = s2.shake();
        System.out.println("gameover = " + sh3);
    }
}
