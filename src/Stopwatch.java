public class Stopwatch {

    private long startedAt;
    private String context;
    private int expectedMs;

    void start() {
        start("", -1);
    }

    void start(String context) {
        start(context, -1);
    }

    void start(int expectedMs) {
        start("", expectedMs);
    }

    void start(String context, int expectedMs) {
        this.context = context;
        this.expectedMs = expectedMs;
        startedAt = System.nanoTime();
    }

    void stop() {
        long elapsed = System.nanoTime() - startedAt;
        System.out.println(context + " took " + elapsed / 1000000 + " ms." + (expectedMs >= 0 ? " (" + expectedMs + " ms expected)" : ""));
    }

}