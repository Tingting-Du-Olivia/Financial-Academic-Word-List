package main;
import hyponym.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        FAWL fawl = new FAWL();
        String outputFilePath = "./data/FAWL/final_fawl2.txt";
        TreeSet<String> treeSet = fawl.getFawl();
        writeTreeSetToFile(treeSet, outputFilePath);
        System.out.println("Contents of the TreeSet have been written to: " + outputFilePath);


//        Lemmatize lemmatize = new Lemmatize();
//        lemmatize.lemmatization();
//        System.out.println(lemmatize.lemmasOfText);

//        TextbookHandler textbookHandler = new TextbookHandler();
//
////        System.out.println(textbookHandler.wordRangeRatioMap);
////        for (Map.Entry<String, Integer> entry: textbookHandler.wordRangeRatioMap.entrySet()) {
////            if (entry.getValue() > 8) {
////                System.out.println(entry);
////            }
////        }
//        //get level list size
////        CountUnitMap cum = new CountUnitMap();
////        cum.getSize(); //print out all
//
////
////
////        //get book size
////        TextbookHandler textbookHandler = new TextbookHandler();
//////        System.out.println(textbookHandler.books.length);
////
////        double sizes[] = {
////                textbookHandler.computeGroupSize(0, 9),
////                textbookHandler.computeGroupSize(10, 19),
////                textbookHandler.computeGroupSize(20, 22),
////                textbookHandler.computeGroupSize(23, 31),
////                textbookHandler.computeGroupSize(32, 32),
////                textbookHandler.computeGroupSize(33, 40),
////                textbookHandler.computeGroupSize(41, 48),
////                textbookHandler.computeGroupSize(49, 57),
////                textbookHandler.computeGroupSize(58, 63),
////                textbookHandler.computeGroupSize(64, 68),
////                textbookHandler.computeGroupSize(69, 77),
////                textbookHandler.computeGroupSize(78, 79),
////                textbookHandler.computeGroupSize(80, 84),
////                textbookHandler.computeGroupSize(85, 87),
////                textbookHandler.computeGroupSize(88, 91),
////                textbookHandler.computeGroupSize(92, 93),
////                textbookHandler.computeGroupSize(94, 97),
////                textbookHandler.computeGroupSize(98, 100),
////                textbookHandler.computeGroupSize(101, 105) //19
////        };
////
////        for (int i = 0; i < 19; i++) {
////            System.out.println(sizes[i]);
////        }
////        double s = textbookHandler.computeSingleBookSize(1);
////        System.out.println(s);
//
//
//        WordNet wordNet = new WordNet();
//        double frequencyThreshold = 500; // Adjust this threshold as needed
//        int maxWords = 2000; // Adjust the maximum number of words as needed
//        int rangeRatio = 7;
//        double dpValue = 0.5; // Adjust this dpValue as needed
//
//        TreeMap<String, Map<String, Double>> selectedWords = textbookHandler.selectWords(frequencyThreshold, maxWords, rangeRatio, dpValue);
//
//        // Write selected words to a text file
//        String outputFilePath = "./data/FAWL/pure_words_freq_500_dp_5_range_7.txt";
//        writeSelectedWordsToFile(selectedWords, outputFilePath);
//        System.out.println("Selected words written to: " + outputFilePath);

//        List<String> FAWL = new ArrayList<>();
//        FAWL = wordNet.textbookHandler.selectWords(1000, 2000, 0.7);
//        System.out.println(FAWL);

//        WordNet wordNet_lemma = new WordNet(listFilename_lemma, textbookFilename);
//
//        System.out.println("HighSchool_1: " + wordNet.cover_HighSchool_1_allBooks);
//        System.out.println("HighSchool_2: " + wordNet.cover_HighSchool_2_allBooks);
//        System.out.println("HighSchool_3: " + wordNet.cover_HighSchool_3_allBooks);
//        System.out.println("HighSchool_4: " + wordNet.cover_HighSchool_4_allBooks);
//        System.out.println("HighSchool_5: " + wordNet.cover_HighSchool_5_allBooks);
//        System.out.println("HighSchool_6: " + wordNet.cover_HighSchool_6_allBooks);
//
//
//        System.out.println(wordNet.textbook.entrySet());

//        System.out.println(wordNet_origin.levelListHandler.levelList3.entrySet());
//        System.out.println(wordNet_origin.levelListHandler.levelList3.entrySet());

        /* DEBUG
        for (Map.Entry<String, Double> entry : wordNet_lemma.cet4.entrySet()) {
            String key = entry.getKey();
            if (!wordNet_origin.cet4.containsKey(key)) {
//                System.out.println("DEBUG: " + key + ": origin: " + wordNet_origin.cet4.get(key)
//                        + " lemma: " + wordNet_lemma.cet4.get(key) + "\n");
                System.out.println("DEBUG: " + key + " lemma: " + wordNet_lemma.cet4.get(key) + "\n");
            }
        }

         */

        /*
        //write out levelList
        LevelList dataMap = new LevelList();
        dataMap = wordNet.levelListHandler.HighSchool_levelList6;
        String filePath = "./data/HighSchool_levelList6.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, HashSet<String>> entry : dataMap.entrySet()) {
                writer.write(entry.getKey());
                for (String member : entry.getValue()) {
                    writer.write(" " + member);
                }
                writer.newLine(); // Add a newline after each line
            }
            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

         */
    }

//    public static void writeSelectedWordsToFile(Map<String, Map<String, Double>> selectedWords, String filePath) {
//        try (FileWriter fileWriter = new FileWriter(filePath);
//             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
//
//            for (Map.Entry<String, Map<String, Double>> entry : selectedWords.entrySet()) {
////                bufferedWriter.write(entry.getKey() + ": " + entry.getValue());
//                bufferedWriter.write(entry.getKey());
//                bufferedWriter.newLine();
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }



    public static void writeTreeSetToFile(TreeSet<String> treeSet, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Iterate through the TreeSet and write each element to the file
            for (String element : treeSet) {
                writer.write(element);
                writer.newLine(); // Add a newline after each element
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
