import java.util.concurrent.CountDownLatch;

public class Example3 {

    private static CountDownLatch cdl;
    private static volatile int[] array;
    private static int n = 100_000_000;

    public static void main(String[] args) throws InterruptedException {
        var sw = new Stopwatch("Example 3: Non-shared L1/L2 cache");

        array = new int[100];
        cdl = new CountDownLatch(4);

        sw.start(3600);
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            new Thread(() -> { update(finalI); cdl.countDown(); }).start();
        }
        cdl.await();
        sw.stop();

        array = new int[100];
        cdl = new CountDownLatch(4);

        sw.start(900);
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            new Thread(() -> { update(finalI * 16); cdl.countDown(); }).start();
        }
        cdl.await();
        sw.stop();
    }

    private static void update(int index) {
        for (int i = 0; i < n; i++) {
            array[index]++;
        }
    }

}
