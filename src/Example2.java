public class Example2 {

    private static volatile int[] array;

    public static void main(String[] args) {
        Stopwatch sw = new Stopwatch("Example 2: Instruction parallelism");

        int n = 100_000_000;
        array = new int[2];

        sw.start(440);
        for (int i = 0; i < n; i++) {
            array[0]++;
            array[0]++;
        }
        sw.stop();

        sw.start(220);
        for (int i = 0; i < n; i++) {
            array[0]++;
            array[1]++;
        }
        sw.stop();
    }

}
