package hyponym;

import java.util.HashSet;
import java.util.Arrays;

public class AffixLevel {

    public HashSet<String> prefixes;
    public HashSet<String> suffixes;
    public AffixLevel(String[] prefixToAdd, String[] suffixToAdd) {
        prefixes = new HashSet<>();
        suffixes = new HashSet<>();
        setPrefixes(prefixToAdd);
        setSuffixes(suffixToAdd);
    }
    public void setPrefixes(String[] prefixToAdd) {
        if (prefixToAdd != null) {
            this.prefixes.addAll(Arrays.asList(prefixToAdd));
        }
    }
    public void setSuffixes(String[] suffixToAdd) {
        this.suffixes.addAll(Arrays.asList(suffixToAdd));
    }


}
