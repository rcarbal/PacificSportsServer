package com.pacificport.pacificsport.bean.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

@Component
public class JSONProcessorImpl implements JSONProcessor{

    private final String PATH = "src/main/resources/json/pacificsport.json";
    private HashMap<String, JSONObject> cuts = new HashMap<>();


    @PostConstruct
    private void init(){
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = null;

        try (FileReader reader = new FileReader(PATH)) {
            jsonArray = (JSONArray) jsonParser.parse(reader);

            for (Object ob : jsonArray){
                JSONObject jsonObject = (JSONObject) ob;
                String number = ((Long) jsonObject.get("number")).toString();
                cuts.put(number, jsonObject);
            }


            System.out.println(">>>>>>>>>>>>>>>>>>>>================ CUT DATA Parsed");
        } catch (IOException | ParseException e) {
            e.printStackTrace();

        }

    }

    @Override
    public HashMap<String, JSONObject> getAll() {

        if (cuts == null){
            return null;
        }
        return cuts;
    }

    @Override
    public JSONObject getCutNumber(String number) {

        JSONObject cutReturned = cuts.get(number);
        return cutReturned;
    }
}
