package com.example.demo;

import com.example.demo.controller.Controller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ControllerTest {

    @Autowired
    Controller controller;

    @Test
    public void apiCall200Test(){
       ResponseEntity<String> response =controller.getText(1,"short");
       assertEquals("200 OK",response.getStatusCode().toString());
    }

    @Test
    public void apiCall404Test(){
        ResponseEntity<String> response =controller.getText(1,"very long text");
       assertEquals("404 NOT_FOUND",response.getStatusCode().toString());
      // assertThrows(Controller.class,IOException.class);
    }
}
