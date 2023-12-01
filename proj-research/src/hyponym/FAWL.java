package hyponym;
import edu.princeton.cs.algs4.In;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class FAWL {
    String file1 = "./data/FAWL/pure_words_freq_2000_dp_6_range_11.txt";
    String file2 = "./data/FAWL/pure_words_freq_800_dp_6_range_9.txt";
    String file3 = "./data/FAWL/pure_words_freq_600_dp_9_range_11.txt";

    TreeSet<String> fawl;
    public FAWL() {
        fawl = new TreeSet<>();
        CountUnitMap countUnitMap = new CountUnitMap();
        readInResult (file1);
        readInResult (file2);
        readInResult (file3);
        deleteResult(countUnitMap.cet6_2);
        deleteResult(countUnitMap.HighSchool_2);
    }
    public void readInResult (String filename) {
        Reader reader = new Reader(filename, fawl);
        reader.process();
    }
    public void deleteResult (TreeMap<String, Double> origin) {
        for (String word : fawl) {
            if (origin.containsKey(word)) {

                }
            }
    }



    public TreeSet<String> getFawl() {
        return fawl;
    }


}
