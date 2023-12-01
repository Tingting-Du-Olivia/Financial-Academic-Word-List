package hyponym;

import java.util.Comparator;
import java.util.Map;

import static hyponym.TextbookHandler.calculateDp;
import static hyponym.TextbookHandler.calculateStandardDeviation;

public class WordComparator implements Comparator<String> {
    public final Map<String, Double> frequencyMap;

    public WordComparator(Map<String, Double> frequencyMap) {
        this.frequencyMap = frequencyMap;
    }

    @Override
    public int compare(String word1, String word2) {
        // Compare first by frequency in descending order
        int frequencyComparison = Double.compare(frequencyMap.get(word2), frequencyMap.get(word1));
        if (frequencyComparison != 0) {
            return frequencyComparison;
        }
        // If frequencies are equal, compare by dp value in descending order
        double dpValue1 = calculateDp(frequencyMap.get(word1),
                frequencyMap.values().stream().mapToDouble(Double::doubleValue).average().orElse(0.0),
                calculateStandardDeviation(frequencyMap.values(), frequencyMap.values().stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));
        double dpValue2 = calculateDp(frequencyMap.get(word2),
                frequencyMap.values().stream().mapToDouble(Double::doubleValue).average().orElse(0.0),
                calculateStandardDeviation(frequencyMap.values(), frequencyMap.values().stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));

        return Double.compare(dpValue2, dpValue1);
    }

}