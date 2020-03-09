package com.pacificport.pacificsport.dao.cut;

import org.json.simple.JSONObject;

import java.util.Map;

public interface CutJSONDAO {

    public Map<String, JSONObject> findAll();

    JSONObject getCutNumber(String number);

    Map getCutNumbers(String cut);
}
