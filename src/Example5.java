public class Example5 {

    public static void main(String[] args) throws InterruptedException {
        Stopwatch sw = new Stopwatch();
        int[][] array = new int[512][512];

        sw.start("2D Array", 2180);
        for (int i = 0; i < 1000; i++) {
            for (int y = 0; y < 512; y++) {
                for (int x = 0; x < 512; x++) {
                    array[x][y]++;
                }
            }
        }
        sw.stop();
        sw.start("2D Array", 166);
        for (int i = 0; i < 1000; i++) {
            for (int x = 0; x < 512; x++) {
                for (int y = 0; y < 512; y++) {
                    array[x][y]++;
                }
            }
        }
        sw.stop();
    }
}
