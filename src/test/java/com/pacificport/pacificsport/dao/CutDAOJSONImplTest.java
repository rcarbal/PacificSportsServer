package com.pacificport.pacificsport.dao;
import com.pacificport.pacificsport.dao.cut.CutDAOJSONImpl;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CutDAOJSONImplTest {


    // ********************************  THIS TEST CURRENTLY FAILS *******************************************
    @Test
    public void getDataFromJsonParseUsingSpringJSONParser() {

        CutDAOJSONImpl impl = new CutDAOJSONImpl();

        JSONObject cuts = impl.findAll();
        if (cuts == null){
            Assertions.fail();
        }
        System.out.println("\n\n ==================>");
        System.out.println(cuts);
        Assertions.assertTrue(cuts.size() > 0);
    }
}