package tfidf.search;

import tfidf.model.DocumentData;

import java.util.List;
import java.util.Map;
import java.util.function.DoubleConsumer;

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

    public static DocumentData createDocument(List<String> words, List<String> terms){
        DocumentData documentData = new DocumentData();
        for(String term: terms){
            double termFreq = calculateTermFrequency(words, term);
            documentData.putTermFrequency(term, termFreq);
        }
       return  documentData;
    }

    private static double getInverseDocumentFrequency(String term, Map<String, DocumentData > documentResults){
      double nt =0;
      for(String document: documentResults.keySet()){
          DocumentData documentData =  documentResults.get(document);
          double termFrequency = documentData.getFrequency(term);
          if(termFrequency > 0.0){
              nt++;
          }

      }

      return  nt == 0 ? 0: Math.log10(documentResults.size() /nt);
    }

    public static  Map<Double, List<String>> getDocumentSortedByScore(List<String> term,
                                                                      Map<String, DocumentData> documentResult){

    }
}
