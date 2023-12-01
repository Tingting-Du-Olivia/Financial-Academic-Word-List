package hyponym;

import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class LevelList extends TreeMap<String, HashSet<String>> {
    public LevelList() {
        super();
    }
    public void addMembers(String headword, String member) {
        if (!this.containsKey(headword)) {
            HashSet<String> set = new HashSet<>();
            set.add(member);
            this.put(headword, set);
        } else {
            HashSet<String> newSet = this.get(headword);
            newSet.add(member);
            this.put(headword, newSet);

        }
    }
    //
    public LevelList copy() {
        TreeMap<String, HashSet<String>> lt = new TreeMap<>(this);
        return (LevelList) lt;
    }
    public void mergeMaps(TreeMap<String, HashSet<String>> map2) {
        for (Map.Entry<String, HashSet<String>> entry : map2.entrySet()) {
            String key = entry.getKey();
            HashSet<String> values = entry.getValue();

            // If the key already exists in map1, merge the sets
            if (this.containsKey(key)) {
                this.get(key).addAll(values);
            } else {
                // If the key is not present in map1, add a new entry
                this.put(key, new HashSet<>(values));
            }
        }
    }
}
