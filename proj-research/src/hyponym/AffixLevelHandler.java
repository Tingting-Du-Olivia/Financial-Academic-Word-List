package hyponym;

public class AffixLevelHandler {

    public AffixLevel affixLevel3;
    public AffixLevel affixLevel4;
    public AffixLevel affixLevel5;
    public AffixLevelHandler() {
        this.affixLevel3 = setAffixLevel(affixLevel3, level3prefixes, level3suffixes);
        this.affixLevel4 = setAffixLevel(affixLevel4, level4prefixes, level4suffixes);
        this.affixLevel5 = setAffixLevel(affixLevel5, level5prefixes, level5suffixes);
    }
    public String[] level3prefixes = {};
    public String[] level3suffixes = {"able", "er", "ish", "less", "ly", "ness", "th", "y", "non", "un"};
    public String[] level4prefixes = {"in"};
    public String[] level4suffixes = {"al", "ation", "ess", "ful", "ism", "ist", "ity", "ize", "ment", "ous"};
    public String[] level5prefixes = {"anti", "ante", "arch", "bi", "circum", "counter", "en", "ex", "fore", "hyper", "inter", "mid", "mis", "neo", "post", "pro", "semi", "sub", "un"};
    public String[] level5suffixes = {"age", "al", "ally", "an", "ance", "ant", "ary", "atory", "dom", "eer", "en", "en", "ence", "ent", "ery", "ese", "esque", "ette", "hood", "i", "ian",
            "ite", "let", "ling", "ly", "most", "ory", "ship", "ward", "ways", "wise"};
    public AffixLevel setAffixLevel(AffixLevel affixLevel, String[] prefixes, String[] suffixes  ) {
        affixLevel = new AffixLevel(prefixes, suffixes);
        return affixLevel;
    }

}
