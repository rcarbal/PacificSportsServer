package com.pacificport.pacificsport.dao.cut;

import org.json.simple.JSONObject;

import java.util.HashMap;

public interface CutJSONDAO {

    public HashMap<String, JSONObject> findAll();

    JSONObject getCutNumber(String number);
}
