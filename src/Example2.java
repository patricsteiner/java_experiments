public class Example2 {

    public static void main(String[] args) {
        var sw = new Stopwatch("Example 2: Instruction parallelism");

        double a = 0, b = 0;
        int n = 100_000_000;

        sw.start(400);
        for (int i = 0; i < n; i++) {
            a += .1;
            a += .1;
        }
        sw.stop();
        System.out.println("a = " + a + ", b = " + b);

        a = 0; b = 0;

        sw.start(200);
        for (int i = 0; i < n; i++) {
            a += .1;
            b += .1;
        }
        sw.stop();
        System.out.println("a = " + a + ", b = " + b);
    }

}
