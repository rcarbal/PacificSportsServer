package com.pacificport.pacificsport.json;

import com.pacificport.pacificsport.bean.json.JSONProcessorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

class JSONProcessorImplTest {



    @Test
    void returnJSONStringOfAllTheCuts() {
        JSONProcessorImpl jsonProcessor = new JSONProcessorImpl();

        //read all the data from JSON file
        String allTheJsonInTheFile = jsonProcessor.getAll();

        System.out.println("\n\n========>>>>>");
        System.out.println(allTheJsonInTheFile);

        Assertions.assertTrue(allTheJsonInTheFile.length() > 3);
    }

}