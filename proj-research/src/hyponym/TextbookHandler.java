package hyponym;
import de.erichseifert.vectorgraphics2d.intermediate.commands.Group;
import edu.princeton.cs.algs4.In;



import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public class TextbookHandler {
    String  all_books_file = "./data/textbook/all_books.txt";
    public String[] bookFiles = {
            "./data/textbook/1_1.txt", "./data/textbook/1_2.txt", "./data/textbook/1_3.txt",
            "./data/textbook/1_4.txt", "./data/textbook/1_5.txt", "./data/textbook/1_6.txt",
            "./data/textbook/1_7.txt", "./data/textbook/1_8.txt", "./data/textbook/1_9.txt",
            "./data/textbook/1_10.txt",
            "./data/textbook/2_1.txt", "./data/textbook/2_2.txt", "./data/textbook/2_3.txt",
            "./data/textbook/2_4.txt", "./data/textbook/2_5.txt", "./data/textbook/2_6.txt",
            "./data/textbook/2_7.txt", "./data/textbook/2_8.txt", "./data/textbook/2_9.txt",
            "./data/textbook/2_10.txt",
            "./data/textbook/3_1.txt", "./data/textbook/3_2.txt", "./data/textbook/3_3.txt",
            "./data/textbook/4_1.txt", "./data/textbook/4_2.txt", "./data/textbook/4_3.txt",
            "./data/textbook/4_4.txt", "./data/textbook/4_5.txt", "./data/textbook/4_6.txt",
            "./data/textbook/4_7.txt", "./data/textbook/4_8.txt",
            "./data/textbook/5_1.txt",
            "./data/textbook/6_1.txt", "./data/textbook/6_2.txt", "./data/textbook/6_3.txt",
            "./data/textbook/6_4.txt", "./data/textbook/6_5.txt", "./data/textbook/6_6.txt",
            "./data/textbook/6_7.txt", "./data/textbook/6_8.txt",
            "./data/textbook/7_1.txt", "./data/textbook/7_2.txt", "./data/textbook/7_3.txt",
            "./data/textbook/7_4.txt", "./data/textbook/7_5.txt", "./data/textbook/7_6.txt",
            "./data/textbook/7_7.txt", "./data/textbook/7_8.txt",
            "./data/textbook/8_1.txt", "./data/textbook/8_2.txt", "./data/textbook/8_3.txt",
            "./data/textbook/8_4.txt", "./data/textbook/8_5.txt", "./data/textbook/8_6.txt",
            "./data/textbook/8_7.txt", "./data/textbook/8_8.txt", "./data/textbook/8_9.txt",
            "./data/textbook/9_1.txt", "./data/textbook/9_2.txt", "./data/textbook/9_3.txt",
            "./data/textbook/9_4.txt", "./data/textbook/9_5.txt", "./data/textbook/9_6.txt",
            "./data/textbook/10_1.txt", "./data/textbook/10_2.txt", "./data/textbook/10_3.txt",
            "./data/textbook/10_4.txt", "./data/textbook/10_5.txt",
            "./data/textbook/11_1.txt", "./data/textbook/11_2.txt", "./data/textbook/11_3.txt",
            "./data/textbook/11_4.txt", "./data/textbook/11_5.txt", "./data/textbook/11_6.txt",
            "./data/textbook/11_7.txt", "./data/textbook/11_8.txt", "./data/textbook/11_9.txt",
            "./data/textbook/12_1.txt", "./data/textbook/12_2.txt",
            "./data/textbook/13_1.txt", "./data/textbook/13_2.txt", "./data/textbook/13_3.txt",
            "./data/textbook/13_4.txt", "./data/textbook/13_5.txt",
            "./data/textbook/14_1.txt", "./data/textbook/14_2.txt", "./data/textbook/14_3.txt",
            "./data/textbook/15_1.txt", "./data/textbook/15_2.txt", "./data/textbook/15_3.txt",
            "./data/textbook/15_4.txt",
            "./data/textbook/16_1.txt", "./data/textbook/16_2.txt",
            "./data/textbook/17_1.txt", "./data/textbook/17_2.txt", "./data/textbook/17_3.txt",
            "./data/textbook/17_4.txt",
            "./data/textbook/18_1.txt", "./data/textbook/18_2.txt", "./data/textbook/18_3.txt",
            "./data/textbook/19_1.txt", "./data/textbook/19_2.txt", "./data/textbook/19_3.txt",
            "./data/textbook/19_4.txt", "./data/textbook/19_5.txt", "./data/textbook/19_6.txt"
    };


    public TreeMap<String, Double>[] books;
    public TreeMap<String, Double>[] subjects; //merge books of same subject, total 19 subjects
    public HashSet<Integer>[] group;
    public Map<String, HashSet<Integer>> wordRangeMap;
    public HashMap<String, Integer> wordRangeRatioMap;
    TreeMap<String, Double> allBooks;
    Set<String> stopWordSet;

    public TextbookHandler() {
//        allBooks = new TreeMap<>();
//        readInBook(allBooks, all_books_file);
        books = new TreeMap[bookFiles.length];
        for (int i = 0; i < bookFiles.length; i++) {
            books[i] = new TreeMap<>();
            readInBook(books[i], bookFiles[i]);
        }
        setGroup();
        setSubjects();
        computeRangeAcrossSubjects();
        setWordRangeRatioMap();
        createStopWordsHashSet();
    }

    public void setGroup() {
        group = new HashSet[19];
        for (int i = 0; i < 19; i++) {
            group[i] = new HashSet<>();
        }
        HashSet<Integer> set0 = new HashSet<>();
        Integer[] set00 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //corporate finace
        set0.addAll(Arrays.asList(set00));
        group[0] = set0;

        HashSet<Integer> set1 = new HashSet<>(); //international finance
        Integer[] set01 = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        set1.addAll(Arrays.asList(set01));
        group[1] = set1;

        HashSet<Integer> set2 = new HashSet<>(); //international finance
        Integer[] set02 = {20, 21, 22};
        set2.addAll(Arrays.asList(set02));
        group[2] = set2;

        HashSet<Integer> set3 = new HashSet<>(); 
        Integer[] set03 = {23, 24, 25, 26, 27, 28, 29, 30};
        set2.addAll(Arrays.asList(set03));
        group[3] = set3;

        HashSet<Integer> set4 = new HashSet<>(); 
        Integer[] set04 = {31};
        set4.addAll(Arrays.asList(set04));
        group[4] = set4;

        HashSet<Integer> set5 = new HashSet<>();
        Integer[] set05 = {32, 33, 34, 35, 36, 37, 38, 39};
        set5.addAll(Arrays.asList(set05));
        group[5] = set5;

        HashSet<Integer> set6 = new HashSet<>();
        Integer[] set06 = {40, 41, 42, 43, 44, 45, 46, 47};
        set6.addAll(Arrays.asList(set06));
        group[6] = set6;

        HashSet<Integer> set7 = new HashSet<>();
        Integer[] set07 = {48, 49, 50, 51, 52, 53, 54, 55, 56};
        set7.addAll(Arrays.asList(set07));
        group[7] = set7;
        
        HashSet<Integer> set8 = new HashSet<>();
        Integer[] set08 = {57, 58, 59, 60, 61, 62};
        set8.addAll(Arrays.asList(set08));
        group[8] = set8;

        HashSet<Integer> set9 = new HashSet<>();
        Integer[] set09 = {63, 64, 65, 66, 67};
        set9.addAll(Arrays.asList(set09));
        group[9] = set9;

        HashSet<Integer> set10 = new HashSet<>();
        Integer[] set010 = {68, 69, 70, 71, 72, 73, 74, 75, 76};
        set10.addAll(Arrays.asList(set010));
        group[10] = set10;

        HashSet<Integer> set11 = new HashSet<>();
        Integer[] set011 = {77, 78};
        set11.addAll(Arrays.asList(set011));
        group[11] = set11;

        HashSet<Integer> set12 = new HashSet<>();
        Integer[] set012 = {79, 80, 81, 82, 83};
        set12.addAll(Arrays.asList(set012));
        group[12] = set12;


        HashSet<Integer> set13 = new HashSet<>();
        Integer[] set013 = {84, 85, 86};
        set13.addAll(Arrays.asList(set013));
        group[13] = set13;

        HashSet<Integer> set14 = new HashSet<>();
        Integer[] set014 = {87, 88, 89, 90};
        set14.addAll(Arrays.asList(set014));
        group[14] = set14;

        HashSet<Integer> set15 = new HashSet<>();
        Integer[] set015 = {91, 92};
        set15.addAll(Arrays.asList(set015));
        group[15] = set15;

        HashSet<Integer> set16 = new HashSet<>();
        Integer[] set016 = {93, 94, 95, 96};
        set16.addAll(Arrays.asList(set016));
        group[16] = set16;

        HashSet<Integer> set17 = new HashSet<>();
        Integer[] set017 = {97, 98, 99};
        set17.addAll(Arrays.asList(set017));
        group[17] = set17;

        HashSet<Integer> set18 = new HashSet<>();
        Integer[] set018 = {100, 101, 102, 103, 104, 105};
        set18.addAll(Arrays.asList(set018));
        group[18] = set18;
    }


    public void readInBook (TreeMap<String, Double> textbook, String filename) {
        In in = new In(filename);
        while (in.hasNextLine()) {
            String nextLine = in.readLine();
            String[] splitLine = nextLine.split("\s");
            for (String element : splitLine) {
                element = element.toLowerCase(); //change to lowercase!
                if (!textbook.containsKey(element)) {
                    textbook.put(element, 1.0);
                } else {
                    double curVal = textbook.get(element);
                    double newVal = curVal + 1;
                    textbook.put(element, newVal);
                }
            }
        }
    }
    
    public void setSubjects() {
        subjects = new TreeMap[19];
        for (int i = 0; i < 19; i++) {
            subjects[i] = new TreeMap<>();
            Iterator<Integer> iter = group[i].stream().iterator();
            while (iter.hasNext()) {
                mergeCntMaps(subjects[i], books[iter.next()]);
            }
        }
    }

    public void setWordRangeRatioMap() {
        wordRangeRatioMap = new HashMap<>();
        for (Map.Entry<String, HashSet<Integer>> entry : wordRangeMap.entrySet()) {
            String word = entry.getKey();
            HashSet<Integer> range = entry.getValue();
            wordRangeRatioMap.put(word, range.size());
        }
    }

    public void mergeCntMaps(TreeMap<String, Double> map1, TreeMap<String, Double> map2) {
        for (Map.Entry<String, Double> entry : map2.entrySet()) {
            String key = entry.getKey();
            Double cnt = entry.getValue();
            // If the key already exists in map1, merge the sets
            if (map1.containsKey(key)) {
                map1.put(key, map1.get(key) + cnt);
            } else {
                // If the key is not present in map1, add a new entry
                map1.put(key, cnt);
            }
        }
    }
    public double computeGroupSize(int startIndex, int endIndex) {
        double size = 0.0;
        for (int i = startIndex; i <= endIndex; i++) {
            size += computeSingleBookSize(i);
        }
        return size;
    }

    public double computeSingleBookSize(int index) {
        double size = books[index].values().stream().mapToDouble(Double::doubleValue).sum();
        return size;
    }

    //不就是allbook freq
    public Map<String, Double> computeWordFrequencyAcrossBooks() {
        Map<String, Double> wordFrequencyMap = new HashMap<>();
        for (TreeMap<String, Double> book : books) {
            for (String word : book.keySet()) {
                double frequency = wordFrequencyMap.getOrDefault(word, 0.0);
                frequency += book.get(word);
                wordFrequencyMap.put(word, frequency);
            }
        }
        return wordFrequencyMap;
    }

    public void computeRangeAcrossSubjects() {
        
        wordRangeMap = new HashMap<>();
        for (int i = 0; i < 19; i++) {
            for (String word : subjects[i].keySet()) {
                if (wordRangeMap.containsKey(word)) {
                    wordRangeMap.get(word).add(i);
                } else {
                    HashSet<Integer> set = new HashSet<>();
                    set.add(i);
                    wordRangeMap.put(word, set);
                }
            }
        }

    }
    public TreeMap<String, Map<String, Double>> selectWords(double frequencyThreshold, int maxWords, int rangeRatioThreshold, double dpValue) {
        Map<String, Double> wordFrequencyMap = computeWordFrequencyAcrossBooks();

        TreeMap<String, Map<String, Double>> selectedWords = new TreeMap<>(new WordComparator(wordFrequencyMap));

        // Calculate the mean frequency
        double meanFrequency = wordFrequencyMap.values().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

        // Calculate the standard deviation of frequency
        double frequencyStdDev = calculateStandardDeviation(wordFrequencyMap.values(), meanFrequency);

        for (String word : wordFrequencyMap.keySet()) {
            double frequency = wordFrequencyMap.get(word);
            int rangeRatio = wordRangeRatioMap.get(word);
            if (!stopWordSet.contains(word)) {
                if (frequency >= frequencyThreshold && rangeRatio >= rangeRatioThreshold) {
                    double dp = calculateDp(wordFrequencyMap.get(word), meanFrequency, frequencyStdDev);
                    if (dp >= dpValue) {
                        Map<String, Double> properties = new HashMap<>();
                        properties.put("Frequency", frequency);
                        properties.put("DpValue", dp);
                        selectedWords.put(word, properties);
                    }
                }
            }

        }
        return selectedWords;
    }

    public void createStopWordsHashSet() {
        // List of common stop words
        String[] stopWordsArray = {
                "a", "about", "above", "after", "again", "against", "all", "am", "an", "and", "any",
                "are", "aren't", "as", "at", "be", "because", "been", "before", "being", "below",
                "between", "both", "but", "by", "can't", "cannot", "could", "couldn't", "did", "didn't",
                "do", "does", "doesn't", "doing", "don't", "down", "during", "each", "few", "for",
                "from", "further", "had", "hadn't", "has", "hasn't", "have", "haven't", "having", "he",
                "he'd", "he'll", "he's", "her", "here", "here's", "hers", "herself", "him", "himself",
                "his", "how", "how's", "i", "i'd", "i'll", "i'm", "i've", "if", "in", "into", "is",
                "isn't", "it", "it's", "its", "itself", "let's", "me", "more", "most", "mustn't", "my",
                "myself", "no", "nor", "not", "of", "off", "on", "once", "only", "or", "other", "ought",
                "our", "ours", "ourselves", "out", "over", "own", "same", "shan't", "she", "she'd", "she'll",
                "she's", "should", "shouldn't", "so", "some", "such", "than", "that", "that's", "the", "their",
                "theirs", "them", "themselves", "then", "there", "there's", "these", "they", "they'd", "they'll",
                "they're", "they've", "this", "those", "through", "to", "too", "under", "until", "up", "very",
                "was", "wasn't", "we", "we'd", "we'll", "we're", "we've", "were", "weren't", "what", "what's",
                "when", "when's", "where", "where's", "which", "while", "who", "who's", "whom", "why", "why's",
                "with", "won't", "would", "wouldn't", "you", "you'd", "you'll", "you're", "you've", "your",
                "yours", "yourself", "yourselves"
        };

        // Convert the array to a HashSet
        stopWordSet = new HashSet<>(Arrays.asList(stopWordsArray));

    }

    public static double calculateDp(double frequency, double meanFrequency, double stdDev) {
        // Calculate the dp value based on the standard deviation
        if (stdDev == 0) {
            // Avoid division by zero
            return 1.0;
        }
        return Math.abs(frequency - meanFrequency) / stdDev;
    }

    public static double calculateStandardDeviation(Iterable<Double> values, double mean) {
        // Calculate the standard deviation of a collection of values
        int count = 0;
        double sumSquaredDiff = 0.0;
        for (double value : values) {
            sumSquaredDiff += Math.pow(value - mean, 2);
            count++;
        }

        if (count <= 1) {
            // Avoid division by zero or negative count
            return 0.0;
        }

        return Math.sqrt(sumSquaredDiff / (count - 1));
    }




}
