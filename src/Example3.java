import java.util.concurrent.CountDownLatch;

public class Example3 {

    private static CountDownLatch countDownLatch;
    private static volatile int[] array = new int[100];
    private static int n = 100_000_000;

    public static void main(String[] args) throws InterruptedException {
        Stopwatch sw = new Stopwatch("Example 3: Non-shared L1/L2 cache");

        countDownLatch = new CountDownLatch(4);
        sw.start(1700);
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            new Thread(() -> { update(finalI); countDownLatch.countDown(); }).start();
        }
        countDownLatch.await();
        sw.stop();

        countDownLatch = new CountDownLatch(4);
        sw.start(550);
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            new Thread(() -> { update(finalI * 16); countDownLatch.countDown(); }).start();
        }
        countDownLatch.await();
        sw.stop();
    }

    private static void update(int index) {
        for (int i = 0; i < n; i++) {
            array[index]++;
        }
    }

}
