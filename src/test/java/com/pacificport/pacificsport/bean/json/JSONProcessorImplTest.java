package com.pacificport.pacificsport.bean.json;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class JSONProcessorImplTest {

    @Test
    public void getCutByNumber(){
        JSONProcessorImpl jsonService = new JSONProcessorImpl();
        String cutNumber = "1210";

        JSONObject jsonObject =jsonService.getCutNumber(cutNumber);

        String  description = (String) jsonObject.get("description");

        Assertions.assertEquals("Adult 22/1 Crew SS", description);

    }

    @Test
    public void getSimilarCuts(){
        JSONProcessorImpl jsonService = new JSONProcessorImpl();

        String getAllCuts = "12";

        Map<String, JSONObject> allTheCuts = jsonService.getCutNumbers(getAllCuts);

        Assertions.assertTrue(allTheCuts.size() > 0);

    }

}