public class Example1 {

    public static void main(String[] args) {
        var sw = new Stopwatch("Example 1: Cache lines");

        int n = 500_000_000;
        int[] array = new int[n];

        sw.start(200);
        for (int i = 0; i < n; i++) {
            array[i]++;
        }
        sw.stop();

        array = new int[n];

        sw.start(200);
        for (int i = 0; i < n; i+=16) {
            array[i]++;
        }
        sw.stop();
    }

}
