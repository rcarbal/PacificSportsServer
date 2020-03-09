package com.pacificport.pacificsport.dao.cut;
import com.pacificport.pacificsport.bean.json.JSONProcessor;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class CutDAOJSONImpl implements CutJSONDAO {

    @Autowired
    JSONProcessor jsonProcessor;

    public CutDAOJSONImpl() {
    }

    @Override
    public Map<String, JSONObject> findAll() {
      return jsonProcessor.getAll();
    }

    @Override
    public JSONObject getCutNumber(String number) {
        return jsonProcessor.getCutNumber(number);
    }

    @Override
    public Map getCutNumbers(String cut) {
        return jsonProcessor.getCutNumbers(cut);
    }

}
