package com.pacificport.pacificsport.bean.json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

@Component
public class JSONProcessorImpl implements JSONProcessor{

    private final String PATH = "src/main/resources/json/pacificsport.json";

    @Override
    public String getAll() {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;

        try (FileReader reader = new FileReader(PATH)) {
            jsonObject = (JSONObject) jsonParser.parse(reader);


            System.out.println();
        } catch (IOException | ParseException e) {
            e.printStackTrace();

        }

        if (jsonObject == null){
            return null;
        }
        return jsonObject.toJSONString();
    }
}
