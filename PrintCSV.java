package OOPHomework4;

import java.util.Collection;
import java.util.TreeSet;

public class PrintCSV {
    static void print(Collection<Task> task) {
        TreeSet<Task> ts = new TreeSet<>(task);
        for (Task el : ts) {
            System.out.println(el);
        }
        return;
    }
}