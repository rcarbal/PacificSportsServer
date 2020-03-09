package com.pacificport.pacificsport.bean.json;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

public interface JSONProcessor {

    public Map<String, JSONObject> getAll();

    public JSONObject getCutNumber(String number);

    public Map getCutNumbers(String cut);
}
