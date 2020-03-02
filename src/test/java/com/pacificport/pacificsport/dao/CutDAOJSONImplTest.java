package com.pacificport.pacificsport.dao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;


class CutDAOJSONImplTest {

    @Autowired
    private ApplicationContext context;


    // ********************************  THIS TEST CURRENTLY FAILS *******************************************
    @Test
    public void getDataFromJsonParseUsingSpringJSONParser() {

        CutDAOJSONImpl impl = new CutDAOJSONImpl();

        String cuts = impl.findAll();
        if (cuts == null){
            Assertions.fail();
        }
        System.out.println("\n\n ==================>");
        System.out.println(cuts);
        Assertions.assertTrue(cuts.length() > 0);
    }
}