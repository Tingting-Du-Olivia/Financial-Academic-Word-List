package hyponym;

import java.util.Map;
import java.util.TreeMap;

public class Coverage {

    public double computeCoverage(TreeMap<String, Double> referenceList, TreeMap<String, Double> targetCorpus) {
        updateList(referenceList, targetCorpus);
        double cnt1 = computeAllCnts(referenceList);
        double cnt2 = computeAllCnts(targetCorpus);
//        System.out.println("DUBUG cnt1:" + cnt1);
//        System.out.println("DUBUG cnt2:" + cnt2);
        double coverage = cnt1 / cnt2;
//        System.out.println("DUBUG cover:" + coverage);
        return coverage;
    }
    
    public double computeAllCnts(TreeMap<String, Double> map) {
        double sum = map.values().stream().mapToDouble(Double::doubleValue).sum();
        return sum;
    }

    public void updateList(TreeMap<String, Double> referenceList, TreeMap<String, Double> targetCorpus) {
        for (Map.Entry<String, Double> entry : targetCorpus.entrySet()) {
            String key = entry.getKey();
            double curVal = entry.getValue();
            if (referenceList.containsKey(key)) {
                referenceList.put(key, curVal);
            }
        }
    }


    public void incrementTreeMap(TreeMap<String, Double> map, String key, double curVal) {
        double newVal = curVal + 1;
        map.put(key, newVal);
    }

    
}
