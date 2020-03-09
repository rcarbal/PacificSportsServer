package com.pacificport.pacificsport.bean.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Component
public class JSONProcessorImpl implements JSONProcessor{

    private static final String PATH = "src/main/resources/json/pacificsport.json";
    private static TreeMap<String, JSONObject> cuts = new TreeMap<>();

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
    public Map<String, JSONObject> getAll() {

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

    @Override
    public Map<String, JSONObject> getCutNumbers(String cut) {

        return getByPrefix(cuts, cut);
    }

    private static SortedMap<String, JSONObject> getByPrefix(
            TreeMap<String, JSONObject> myMap,
            String prefix ) {
        return myMap.subMap( prefix, prefix + Character.MAX_VALUE );
    }
}
