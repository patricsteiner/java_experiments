import java.util.LinkedList;
import java.util.List;

public class Example6 {

    public static void main(String[] args) throws InterruptedException {
        Stopwatch sw = new Stopwatch();

        sw.start("arrayListVsLinkedList");
        List<Integer> list = new LinkedList<>(); // vs. new ArrayList
        for (int i = 0; i < 500000; i++) {
            list.add(i);
        }
        for (int i = 0; i < 500000; i++) {
            list.remove(list.size() - 1);
        }
        sw.stop();
    }
}