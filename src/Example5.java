import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Example5 {

    public static void main(String[] args) throws InterruptedException {
        var sw = new Stopwatch("Example 5: Branch prediction");

        int n = 30_000;
        int[] randomNumbers = new int[n];

        for (int i = 0; i < n; i++) {
            randomNumbers[i] = ThreadLocalRandom.current().nextInt(0, 100);
        }

        sw.start( 2000);
        Arrays.sort(randomNumbers); // vs. without sort: 5000 ms expected
        long sum = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (randomNumbers[i] < 50) {
                    sum += randomNumbers[i];
                }
            }
        }
        sw.stop();

        System.out.println("sum = " + sum);
    }

}
