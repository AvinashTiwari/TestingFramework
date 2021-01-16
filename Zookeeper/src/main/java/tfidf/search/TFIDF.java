package tfidf.search;

import java.util.List;

public class TFIDF {
    public  static double calculateTermFrequency(List<String> words, String term){
       long count = 0;
       for(String word : words){
           if(term.equalsIgnoreCase(word)){
               count++;
           }
       }
       double termfrequency = (double) count / words.size();
       return  termfrequency;
    }
}
