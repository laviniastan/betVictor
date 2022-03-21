package com.example.demo.controller;

import com.example.demo.model.Response;
import com.example.demo.config.TopicProducer;
import com.example.demo.service.Service;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

@RestController
@RequestMapping(value = "/betvictor")
public class Controller {

    @Autowired
    private Service service;

    @Autowired
    private TopicProducer topicProducer;


    @GetMapping("/text")
    public ResponseEntity<String> getText(@RequestParam(value = "p") int p,
                                         @RequestParam(value = "l") String l){
        System.out.println(">>Get method");
        Instant startTime=Instant.now();
        try {
            List<String> paragraphList = new ArrayList<>();
            for (int i = 1; i <= p; i++) {
                getLoremIpsum(i, l).stream().forEach(paragraph -> paragraphList.add(paragraph));
            }

            Response response = service.processData(paragraphList);
            Instant endTime = Instant.now();
            Duration totalProcessingTime = Duration.between(startTime, endTime);
            response.setTotal_processing_time(totalProcessingTime.toMillis());
            topicProducer.send(response.getFreq_word());
            return new ResponseEntity<String>(new Gson().toJson(response), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Error", HttpStatus.NOT_FOUND);
        }
    }

   public List<String> getLoremIpsum(int numberOfParagraphs, String length) throws Exception {
        String urlString="https://loripsum.net/api"+"/"+numberOfParagraphs+"/"+length;
        List<String> paragraphList=new ArrayList<>();
        try{
            URL url=new URL(urlString);
            HttpsURLConnection connection=(HttpsURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            InputStream responseStream = connection.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(responseStream));
            String line;
            while ((line = br.readLine()) != null) {
                if(line.length()>0) {
                    paragraphList.add(line.replaceAll("<p>|</p>", ""));
                }
            }
            br.close();
            return  paragraphList;
        }
        catch (Exception ex){
            throw new Exception("Error");
           // System.out.println("Error "+ex);
         //  throw new Exception("error");
        }
        //return  paragraphList;
   }

}
