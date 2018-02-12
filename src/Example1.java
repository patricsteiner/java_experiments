public class Example1 {

    public static void main(String[] args) {
        Stopwatch sw = new Stopwatch();
        int[] array = new int[64 * 1024 * 1024];

        sw.start(80);
        for (int i = 0; i < array.length; i++) {
            array[i] *= 3;
        }
        sw.stop();
        sw.start(78);
        for (int i = 0; i < array.length; i += 16) {
            array[i] *= 3;
        }
        sw.stop();

    }

}
