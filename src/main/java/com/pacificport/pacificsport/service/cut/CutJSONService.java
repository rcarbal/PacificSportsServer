package com.pacificport.pacificsport.service.cut;

import org.json.simple.JSONObject;

import java.util.Map;

public interface CutJSONService {

    public Map<String, JSONObject> findAll();

    public JSONObject getCutNumber(String number);
}
