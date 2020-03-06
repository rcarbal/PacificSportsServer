package com.pacificport.pacificsport.bean.json;

import org.json.simple.JSONObject;

import java.util.HashMap;

public interface JSONProcessor {

    public HashMap getAll();

    public JSONObject getCutNumber(String number);
}
