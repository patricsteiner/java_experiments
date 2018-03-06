public class Example1 {

    public static void main(String[] args) {
        Stopwatch sw = new Stopwatch("Example 1: Cache lines");

        int n = 100_000_000;
        int[] array = new int[n];

        sw.start(50);
        for (int i = 0; i < n; i++) {
            array[i]++;
        }
        sw.stop();

        sw.start(48);
        for (int i = 0; i < n; i++) {
            array[i]++;
        }
        sw.stop();
    }

}
