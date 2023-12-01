package hyponym;
import edu.princeton.cs.algs4.In;

import java.util.Set;

public class Reader {
    String filename;
    Set<String> store;

    public Reader(String filename, Set<String> store) {
        this.filename = filename;
        this.store = store;

    }

    public void process() {
        In in = new In(filename);
        while (in.hasNextLine()) {
            String nextLine = in.readLine();
            store.add(nextLine);
        }
    }

}
