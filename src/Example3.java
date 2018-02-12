import java.util.concurrent.CountDownLatch;

public class Example3 {

    private static CountDownLatch countDownLatch;

    private static volatile int[] array;

    public static void main(String[] args) throws InterruptedException {
        Stopwatch sw = new Stopwatch();
        array = new int[100];
        countDownLatch = new CountDownLatch(4);

        sw.start("Threads", 4300);
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            new Thread(() -> { update(finalI); countDownLatch.countDown(); }).start(); // vs finalI * 16
        }
        countDownLatch.await();
        sw.stop();
    }

    private static void update(int index) {
        for (int i = 0; i < 100000000; i++) {
            array[index]++;
        }
    }
}
