package com.example.demo.service;

import com.example.demo.model.Response;

import java.time.Duration;
import java.time.Instant;
import java.util.*;


@org.springframework.stereotype.Service
public class Service {

    private HashMap<String, Integer> wordsFrequency = new HashMap<>();
    private List<Integer> paragraphSizes = new ArrayList<>();

    public Response processData(List<String> paragraphs) {

        Instant startTime = Instant.now();
        paragraphs.stream().forEach(paragraph -> {
            processParagraph(paragraph);
        });

        String mostFrequentWord = Collections.max(wordsFrequency.entrySet(), Map.Entry.comparingByValue()).getKey();
        Instant endTime = Instant.now();
        Response response=new Response();
        response.setFreq_word(mostFrequentWord);
        response.setAvg_paragraph_size(paragraphSizes.stream().mapToDouble(d -> d).average().orElse(0.0));
        response.setTotal_processing_time(Duration.between(startTime, endTime).toMillis()/paragraphs.size());
        return response;
    }

    public void processParagraph(String paragraph) {

        String[] words = paragraph.split("\\W+");
        Arrays.stream(words).forEach(word -> {
            if (wordsFrequency.containsKey(word)) {
                wordsFrequency.put(word, wordsFrequency.get(word) + 1);
            } else {
                wordsFrequency.put(word, 1);
            }
        });
        paragraphSizes.add(paragraph.getBytes().length);
    }

}
