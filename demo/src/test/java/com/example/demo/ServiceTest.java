package com.example.demo;

import com.example.demo.model.Response;
import com.example.demo.service.Service;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    Service service;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    /* method that tests processing method in service */
    @Test
    public void processParagraphTest(){
        List<String> parahraphList=new ArrayList<>();
        parahraphList.add("Etenim si delectamur, cum scribimus, quis est tam invidus, qui ab eo nos abducat? Ergo adhuc, quantum equidem intellego, causa non videtur fuisse mutandi nominis. Quem Tiberina descensio festo illo die tanto gaudio affecit, quanto L. Utilitatis causa amicitia est quaesita. Sed vobis voluptatum perceptarum recordatio vitam beatam facit, et quidem corpore perceptarum. Itaque et manendi in vita et migrandi ratio omnis iis rebus, quas supra dixi, metienda. Quodsi ipsam honestatem undique pertectam atque absolutam. Aliter enim nosmet ipsos nosse non possumus. Quis non odit sordidos, vanos, leves, futtiles?");
        parahraphList.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. An haec ab eo non dicuntur? Mene ergo et Triarium dignos existimas, apud quos turpiter loquare? Pauca mutat vel plura sane; Negat esse eam, inquit, propter se expetendam. Nec vero sum nescius esse utilitatem in historia, non modo voluptatem. Duo Reges: constructio interrete. O magnam vim ingenii causamque iustam, cur nova existeret disciplina! Perge porro.");
        Response response= service.processData(parahraphList);
       assertNotNull(response);
    }
}
