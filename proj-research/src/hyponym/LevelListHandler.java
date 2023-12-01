package hyponym;
import edu.princeton.cs.algs4.In;

import java.util.HashSet;
import java.util.Map;

public class LevelListHandler {
    public LevelList cet4_levelList1; //original word list
    public LevelList cet4_levelList2;
    public LevelList cet4_levelList3;
    public LevelList cet4_levelList4;
    public LevelList cet4_levelList5;
    public LevelList cet4_levelList6;

    public LevelList cet6_levelList1; //original word list
    public LevelList cet6_levelList2;
    public LevelList cet6_levelList3;
    public LevelList cet6_levelList4;
    public LevelList cet6_levelList5;
    public LevelList cet6_levelList6;

    public LevelList HighSchool_levelList1; //original word list
    public LevelList HighSchool_levelList2;
    public LevelList HighSchool_levelList3;
    public LevelList HighSchool_levelList4;
    public LevelList HighSchool_levelList5;
    public LevelList HighSchool_levelList6;
    
    String  CET4_lemmas_horizontal= "./data/wordlist/CET4_lemmas_horizontal.txt";
    String CET4_family_horizontal = "./data/wordlist/CET4_family_horizontal.txt";
    String CET4_origin = "./data/wordlist/CET4_origin.txt";

    String CET6_origin = "./data/wordlist/CET6_origin_2.txt";
    String  CET6_lemmas_horizontal= "./data/wordlist/CET4_lemmas_horizontal.txt";
    String CET6_family_horizontal = "./data/wordlist/CET4_family_horizontal.txt";

    String HighSchool_origin = "./data/wordlist/HighSchool_origin.txt";
    String  HighSchool_lemmas_horizontal= "./data/wordlist/HighSchool_lemmas_horizontal.txt";
    String HighSchool_family_horizontal = "./data/wordlist/HighSchool_family_horizontal.txt";

    public LevelListHandler() {
        AffixLevelHandler affixLevelHandler = new AffixLevelHandler();
        //cet4
//        cet4_levelList1 = new LevelList();
//        initialize_file(cet4_levelList1, CET4_origin);
//
//        cet4_levelList2 = new LevelList();
//        process_file(cet4_levelList2, CET4_lemmas_horizontal);
//        cet4_levelList2.mergeMaps(cet4_levelList1);
//
//        cet4_levelList6 = new LevelList();
//        process_file(cet4_levelList6, CET4_family_horizontal);
//
//        cet4_levelList3 = new LevelList();
//        buildLevel(cet4_levelList3, affixLevelHandler.affixLevel3);
//        cet4_levelList3.mergeMaps(cet4_levelList2);
//
//        cet4_levelList4 = new LevelList();
//        buildLevel(cet4_levelList4, affixLevelHandler.affixLevel4);
//        cet4_levelList4.mergeMaps(cet4_levelList3);
//
//        cet4_levelList5 = new LevelList();
//        buildLevel(cet4_levelList5, affixLevelHandler.affixLevel5);
//        cet4_levelList5.mergeMaps(cet4_levelList4);
//        cet4_levelList6.mergeMaps(cet4_levelList5);
        
//        //cet6
//        cet6_levelList1 = new LevelList();
//        initialize_file(cet6_levelList1, CET6_origin);
//
//        cet6_levelList2 = new LevelList();
//        process_file(cet6_levelList2, CET6_lemmas_horizontal);
//        cet6_levelList2.mergeMaps(cet6_levelList1);
//
//        cet6_levelList6 = new LevelList();
//        process_file(cet6_levelList6, CET6_family_horizontal);
//
//        cet6_levelList3 = new LevelList();
//        buildLevel(cet6_levelList3, affixLevelHandler.affixLevel3);
//        cet6_levelList3.mergeMaps(cet6_levelList2);
//
//        cet6_levelList4 = new LevelList();
//        buildLevel(cet6_levelList4, affixLevelHandler.affixLevel4);
//        cet6_levelList4.mergeMaps(cet6_levelList3);
//
//        cet6_levelList5 = new LevelList();
//        buildLevel(cet6_levelList5, affixLevelHandler.affixLevel5);
//        cet6_levelList5.mergeMaps(cet6_levelList4);
//        cet6_levelList6.mergeMaps(cet6_levelList5);
        
        //HighSchool
        HighSchool_levelList1 = new LevelList();
        initialize_file(HighSchool_levelList1, HighSchool_origin);

        HighSchool_levelList2 = new LevelList();
        process_file(HighSchool_levelList2, HighSchool_lemmas_horizontal);
        HighSchool_levelList2.mergeMaps(HighSchool_levelList1);

        HighSchool_levelList6 = new LevelList();
        process_file(HighSchool_levelList6, HighSchool_family_horizontal);

        HighSchool_levelList3 = new LevelList();
        buildLevel(HighSchool_levelList3, affixLevelHandler.affixLevel3);
        HighSchool_levelList3.mergeMaps(HighSchool_levelList2);

        HighSchool_levelList4 = new LevelList();
        buildLevel(HighSchool_levelList4, affixLevelHandler.affixLevel4);
        HighSchool_levelList4.mergeMaps(HighSchool_levelList3);

        HighSchool_levelList5 = new LevelList();
        buildLevel(HighSchool_levelList5, affixLevelHandler.affixLevel5);
        HighSchool_levelList5.mergeMaps(HighSchool_levelList4);
        HighSchool_levelList6.mergeMaps(HighSchool_levelList5);

    }
    public void initialize_file(LevelList level, String filename) {
        In in = new In(filename);
        while (in.hasNextLine()) {
            String nextLine = in.readLine();
            level.put(nextLine, new HashSet<>());
        }
    }
    public void process_file(LevelList level, String filename) {
        In in = new In(filename);
        while (in.hasNextLine()) {
            String nextLine = in.readLine();
            String[] splitLine = nextLine.split("\s");
            String headword = splitLine[0];
            for (int i = 1; i < splitLine.length; i++) {
//                String member = splitLine[i].toLowerCase();
                String member = splitLine[i];
//                System.out.println("DEBUG: " + member);
                level.addMembers(headword, member);
            }
        }
    }
    //from word family to build level 3-5
    public void buildLevel(LevelList levelList, AffixLevel affixLevel) {
        for (Map.Entry<String, HashSet<String>> entry : HighSchool_levelList6.entrySet()) {
            String headword = entry.getKey();
            HashSet<String> members = entry.getValue();
            for (String member : members) {
                for (String affix: affixLevel.prefixes) {
                    if (member.startsWith(affix)) {
                        levelList.addMembers(headword, member);
                    }
                }
                for (String affix: affixLevel.suffixes) {
                    if (member.endsWith(affix)) {
                        levelList.addMembers(headword, member);
                    }
                }
            }
        }

    }

}
