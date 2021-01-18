package tfidf.search;

import tfidf.model.DocumentData;

import java.util.*;
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

    private static  Map<String, Double>getInverseDocumentFrequencyMap(List<String> terms , Map<String, DocumentData> documentResult ){
        Map<String, Double> termtoIDF = new HashMap<>();
        for(String term: terms){
            double idf = getInverseDocumentFrequency(term, documentResult);
            termtoIDF.put(term, idf);
        }
        return termtoIDF;
    }

    public static  Map<Double, List<String>> getDocumentSortedByScore(List<String> terms,
                                                                      Map<String, DocumentData> documentResult){
        TreeMap<Double, List<String>> scoreToDocument = new TreeMap<>();
        Map<String, Double> termToInverseDocument = getInverseDocumentFrequencyMap(terms, documentResult);
        for(String document: documentResult.keySet()){
            DocumentData documentData= documentResult.get(document);
            double score = calculateDocumentScore(terms, documentData,termToInverseDocument);
            addDocumentScoreToTreeMap(scoreToDocument,score, document);
        }

        return  scoreToDocument.descendingMap();
    }

    private static void addDocumentScoreToTreeMap(TreeMap<Double, List<String>> scoreToDocument,
                                                  double score, String document) {
         List<String> documentWithCurrentScore  = scoreToDocument.get(score);
         if(documentWithCurrentScore !=null){
             documentWithCurrentScore = new ArrayList<>();
         }
        documentWithCurrentScore.add(document);
         scoreToDocument.put(score, documentWithCurrentScore);
    }

    private static double calculateDocumentScore(List<String> terms, DocumentData documentData, Map<String, Double> termToInverseDocument) {
       double score =0;
       for(String term: terms){
           double termFrequency = documentData.getFrequency(term);
           double inverseTermFrequency = termToInverseDocument.get(term);
           score+= termFrequency * inverseTermFrequency;
       }
        return score;
    }
}
