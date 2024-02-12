package com.example.demo.serviceTest;

import com.example.demo.repository.FactureRepository;
import com.example.demo.service.FactureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FactureTest {

    @Autowired
    FactureService factureService;

    @Autowired
    FactureRepository factureRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void getFactureByReferenceTest(){
    }

    @Test
    void getAllFactureTest(){
    }

}
