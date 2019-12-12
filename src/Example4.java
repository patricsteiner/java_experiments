public class Example4 {

    public static void main(String[] args) throws InterruptedException {
        var sw = new Stopwatch("Example 4: Locality and order of access");

        int n = 1024;
        int[][] array = new int[n][n];

        sw.start(200);
        for (int i = 0; i < n; i++) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    array[y][x]++;
                }
            }
        }
        sw.stop();

        array = new int[n][n];

        sw.start(2500);
        for (int i = 0; i < n; i++) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    array[x][y]++;
                }
            }
        }
        sw.stop();
    }

}
