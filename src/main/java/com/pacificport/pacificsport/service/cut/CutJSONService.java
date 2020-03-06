package com.pacificport.pacificsport.service.cut;

import org.json.simple.JSONObject;

import java.util.HashMap;

public interface CutJSONService {

    public HashMap<String, JSONObject> findAll();

    public JSONObject getCutNumber(String number);
}
