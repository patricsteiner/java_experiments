public class Example2 {

    private static volatile int[] array;

    public static void main(String[] args) {
        Stopwatch sw = new Stopwatch();
        array = new int[2];

        sw.start("Increment", 500);
        for (int i = 0; i < 100000000; i++) {
            array[0]++;
            array[0]++;
        }
        sw.stop();
        sw.start("Increment", 257);
        for (int i = 0; i < 100000000; i++) {
            array[0]++;
            array[1]++;
        }
        sw.stop();

    }

}
