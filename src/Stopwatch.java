public class Stopwatch {

    private long startedAt;
    private String context;
    private int expectedMs;

    public Stopwatch() {}

    public Stopwatch(String context) {
        this.context = context;
    }

    void start() {
        start(-1);
    }

    void start(int expectedMs) {
        this.expectedMs = expectedMs;
        startedAt = System.nanoTime();
    }

    void stop() {
        long elapsed = System.nanoTime() - startedAt;
        System.out.println((!context.isEmpty() ?  "[" + context + "] " : "")
                + "took " + elapsed / 1000000 + " ms."
                + (expectedMs >= 0 ? " (" + expectedMs + " ms expected)" : ""));
    }

}