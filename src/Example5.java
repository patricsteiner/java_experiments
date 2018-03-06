import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Example5 {

    public static void main(String[] args) throws InterruptedException {
        Stopwatch sw = new Stopwatch();
        int sum;
        int[] randomNumbers = new int[10000000];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = ThreadLocalRandom.current().nextInt(0, 100);
        }

        sw.start("Random Branch", 1000);
        Arrays.sort(randomNumbers); // vs. without sort: 2766 ms expected
        sum = 0;
        for (int j = 0; j < 50; j++) {
            for (int i = 0; i < 10000000; i++) {
                if (randomNumbers[i] < 50) {
                    sum += randomNumbers[i];
                }
            }
        }
        sw.stop();
        System.out.println(sum);
    }
}
