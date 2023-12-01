package hyponym;

import java.util.HashMap;
import java.util.Map;

public class FreqRatio {
    HashMap<String, Double> bnc;
    HashMap<String, Double> freqRatioMap;
    HashMap<String, Double> allBooksCntMap;
    double sizeOfBnc;
    public FreqRatio(HashMap<String, Double> allBooksCntMap) {
        bnc = new HashMap<>();
        freqRatioMap = new HashMap<>();
        this.allBooksCntMap = allBooksCntMap;
        setBnc();
        sizeOfBnc = getBncSize();
        setFreqRatioMap();
    }

    public void setBnc() {

        return;
    }

    public double getBncSize() {
        double size = bnc.values().stream().mapToDouble(Double::doubleValue).sum();
        return size;
    }

    public void setFreqRatioMap() {
        double sizeOfAllBooks = allBooksCntMap.values().stream().mapToDouble(Double::doubleValue).sum();
        for (Map.Entry<String, Double> entry: allBooksCntMap.entrySet()) {
            double normal_freqInAllBooks = entry.getValue() / sizeOfAllBooks;
            double normal_freqInBnc = bnc.get(entry.getKey()) / sizeOfAllBooks;
            freqRatioMap.put(entry.getKey(), normal_freqInAllBooks / normal_freqInBnc);
        }
    }

}
