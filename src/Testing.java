public class Testing {

    public static void main(String[] args) {
        CombinationLock cl = new CombinationLock("01-02-03", "Your bday");
        System.out.println(cl.unlock());
    }
}
