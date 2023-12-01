package hyponym;
import edu.princeton.cs.algs4.In;
import java.util.TreeMap;

public class CountUnitMap {
    public TreeMap<String, Double> cet4_1;
    String cet4_1_file = "./data/countUnitMap/cet4_1.txt";
    
    public TreeMap<String, Double> cet4_2;
    String cet4_2_file = "./data/countUnitMap/cet4_2.txt";
    public TreeMap<String, Double> cet4_3;
    String cet4_3_file = "./data/countUnitMap/cet4_3.txt";
    public TreeMap<String, Double> cet4_4;
    String cet4_4_file = "./data/countUnitMap/cet4_4.txt";
    public TreeMap<String, Double> cet4_5;
    String cet4_5_file = "./data/countUnitMap/cet4_5.txt";

    public TreeMap<String, Double> cet4_6;
    String cet4_6_file = "./data/countUnitMap/cet4_66.txt";

    public TreeMap<String, Double> cet6_1;
    String cet6_1_file = "./data/countUnitMap/cet6_1.txt";

    public TreeMap<String, Double> cet6_2;
    String cet6_2_file = "./data/countUnitMap/cet6_2.txt";
    public TreeMap<String, Double> cet6_3;
    String cet6_3_file = "./data/countUnitMap/cet6_3.txt";
    public TreeMap<String, Double> cet6_4;
    String cet6_4_file = "./data/countUnitMap/cet6_4.txt";
    public TreeMap<String, Double> cet6_5;
    String cet6_5_file = "./data/countUnitMap/cet6_5.txt";

    public TreeMap<String, Double> cet6_6;
    String cet6_6_file = "./data/countUnitMap/cet6_6.txt";

    public TreeMap<String, Double> HighSchool_1;
    String HighSchool_1_file = "./data/countUnitMap/HighSchool_1.txt";

    public TreeMap<String, Double> HighSchool_2;
    String HighSchool_2_file = "./data/countUnitMap/HighSchool_2.txt";
    public TreeMap<String, Double> HighSchool_3;
    String HighSchool_3_file = "./data/countUnitMap/HighSchool_3.txt";
    public TreeMap<String, Double> HighSchool_4;
    String HighSchool_4_file = "./data/countUnitMap/HighSchool_4.txt";
    public TreeMap<String, Double> HighSchool_5;
    String HighSchool_5_file = "./data/countUnitMap/HighSchool_5.txt";

    public TreeMap<String, Double> HighSchool_6;
    String HighSchool_6_file = "./data/countUnitMap/HighSchool_6.txt";
    public CountUnitMap() {
        
        this.cet4_1 = new TreeMap<>();
        initizalize(cet4_1, cet4_1_file);
        this.cet4_2 = new TreeMap<>();
        initizalize(cet4_2, cet4_2_file);
        this.cet4_3 = new TreeMap<>();
        initizalize(cet4_3, cet4_3_file);
        this.cet4_4 = new TreeMap<>();
        initizalize(cet4_4, cet4_4_file);
        this.cet4_5 = new TreeMap<>();
        initizalize(cet4_5, cet4_5_file);
        this.cet4_6 = new TreeMap<>();
        initizalize(cet4_6, cet4_6_file);

        this.cet6_1 = new TreeMap<>();
        initizalize(cet6_1, cet6_1_file);
        this.cet6_2 = new TreeMap<>();
        initizalize(cet6_2, cet6_2_file);
        this.cet6_3 = new TreeMap<>();
        initizalize(cet6_3, cet6_3_file);
        this.cet6_4 = new TreeMap<>();
        initizalize(cet6_4, cet6_4_file);
        this.cet6_5 = new TreeMap<>();
        initizalize(cet6_5, cet6_5_file);
        this.cet6_6 = new TreeMap<>();
        initizalize(cet6_6, cet6_6_file);

        this.HighSchool_1 = new TreeMap<>();
        initizalize(HighSchool_1, HighSchool_1_file);
        this.HighSchool_2 = new TreeMap<>();
        initizalize(HighSchool_2, HighSchool_2_file);
        this.HighSchool_3 = new TreeMap<>();
        initizalize(HighSchool_3, HighSchool_3_file);
        this.HighSchool_4 = new TreeMap<>();
        initizalize(HighSchool_4, HighSchool_4_file);
        this.HighSchool_5 = new TreeMap<>();
        initizalize(HighSchool_5, HighSchool_5_file);
        this.HighSchool_6 = new TreeMap<>();
        initizalize(HighSchool_6, HighSchool_6_file);
        
    }

    public void initizalize(TreeMap<String, Double> map, String filename) {
        In in = new In(filename);
        while (in.hasNextLine()) {
            String nextLine = in.readLine();
            map.put(nextLine, 0.0);
        }
    }

    public void getSize() {
        printSize(HighSchool_1);
        printSize(HighSchool_2);
        printSize(HighSchool_3);
        printSize(HighSchool_4);
        printSize(HighSchool_5);
        printSize(HighSchool_6);

        printSize(cet4_1);
        printSize(cet4_2);
        printSize(cet4_3);
        printSize(cet4_4);
        printSize(cet4_5);
        printSize(cet4_6);

        printSize(cet6_1);
        printSize(cet6_2);
        printSize(cet6_3);
        printSize(cet6_4);
        printSize(cet6_5);
        printSize(cet6_6);

    }

    private void printSize(TreeMap<String, Double> map) {
//        System.out.println("Size of " + mapName + ": " + map.keySet().size());
        System.out.println(map.keySet().size());
    }



}
