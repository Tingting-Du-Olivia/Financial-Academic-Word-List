package hyponym; 
import edu.princeton.cs.algs4.In;
import java.io.*;

import java.util.*;
/* to parse the file like NgramMap do fileparser

 */
public class WordNet {


    public LevelListHandler levelListHandler;
    public TextbookHandler textbookHandler;
    public CountUnitMap countUnitMap;
    public Coverage coverage;
    //coverage
    public double cover_4_1_allBooks;
    public double cover_4_2_allBooks;
    public double cover_4_3_allBooks;
    public double cover_4_4_allBooks;
    public double cover_4_5_allBooks;
    public double cover_4_6_allBooks;

    public double cover_6_1_allBooks;
    public double cover_6_2_allBooks;
    public double cover_6_3_allBooks;
    public double cover_6_4_allBooks;
    public double cover_6_5_allBooks;
    public double cover_6_6_allBooks;

    public double cover_HighSchool_1_allBooks;
    public double cover_HighSchool_2_allBooks;
    public double cover_HighSchool_3_allBooks;
    public double cover_HighSchool_4_allBooks;
    public double cover_HighSchool_5_allBooks;
    public double cover_HighSchool_6_allBooks;
    public WordNet() {

//        levelListHandler = new LevelListHandler();
        textbookHandler = new TextbookHandler();
//        countUnitMap = new CountUnitMap();
//        coverage = new Coverage();

        /*
        //cet4
        cover_4_1_allBooks = getCoverage(countUnitMap.cet4_1, textbookHandler.allBooks);
        cover_4_2_allBooks = getCoverage(countUnitMap.cet4_2, textbookHandler.allBooks);
        cover_4_3_allBooks = getCoverage(countUnitMap.cet4_3, textbookHandler.allBooks);
        cover_4_4_allBooks = getCoverage(countUnitMap.cet4_4, textbookHandler.allBooks);
        cover_4_5_allBooks = getCoverage(countUnitMap.cet4_5, textbookHandler.allBooks);
        cover_4_6_allBooks = getCoverage(countUnitMap.cet4_6, textbookHandler.allBooks);
        */

        //cet6
//        cover_6_1_allBooks = getCoverage(countUnitMap.cet6_1, textbookHandler.allBooks);
//        cover_6_2_allBooks = getCoverage(countUnitMap.cet6_2, textbookHandler.allBooks);
//        cover_6_3_allBooks = getCoverage(countUnitMap.cet6_3, textbookHandler.allBooks);
//        cover_6_4_allBooks = getCoverage(countUnitMap.cet6_4, textbookHandler.allBooks);
//        cover_6_5_allBooks = getCoverage(countUnitMap.cet6_5, textbookHandler.allBooks);
//        cover_6_6_allBooks = getCoverage(countUnitMap.cet6_6, textbookHandler.allBooks);
        //highschool
//        cover_HighSchool_1_allBooks = getCoverage(countUnitMap.HighSchool_1, textbookHandler.allBooks);
//        cover_HighSchool_2_allBooks = getCoverage(countUnitMap.HighSchool_2, textbookHandler.allBooks);
//        cover_HighSchool_3_allBooks = getCoverage(countUnitMap.HighSchool_3, textbookHandler.allBooks);
//        cover_HighSchool_4_allBooks = getCoverage(countUnitMap.HighSchool_4, textbookHandler.allBooks);
//        cover_HighSchool_5_allBooks = getCoverage(countUnitMap.HighSchool_5, textbookHandler.allBooks);
//        cover_HighSchool_6_allBooks = getCoverage(countUnitMap.HighSchool_6, textbookHandler.allBooks);


    }
    public double getCoverage(TreeMap<String, Double> referenceList, TreeMap<String, Double> targetCorpus) {
        return coverage.computeCoverage(referenceList, targetCorpus);
    }


    public void storeWordNet() {
        //??
    }



}
