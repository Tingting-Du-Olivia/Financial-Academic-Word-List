package hyponym;
import java.util.HashSet;
import java.util.Properties;

import edu.princeton.cs.algs4.In;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

public class Lemmatize {
    String  all_books_file = "./data/textbook/all_books.txt";
    public String text ="";

    public HashSet<String> lemmasOfText;

    public Lemmatize() {
        initizalizeText();
        lemmasOfText = new HashSet<>();
    }

    public void initizalizeText() {
        In in = new In(all_books_file);

        while (in.hasNextLine()) {
            String nextLine = in.readLine();
            text += nextLine;
        }
    }

    public void lemmatization() {


        // Set up properties and create a StanfordCoreNLP pipeline
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // Create an Annotation object with the text
        Annotation document = new Annotation(text);

        // Run the pipeline on the text
        pipeline.annotate(document);

        // Iterate over sentences and lemmatize each word
        for (CoreMap sentence : document.get(CoreAnnotations.SentencesAnnotation.class)) {
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                // Get lemma of each word
                String lemma = token.get(CoreAnnotations.LemmaAnnotation.class);
                lemmasOfText.add(lemma);
            }
        }
    }
}
