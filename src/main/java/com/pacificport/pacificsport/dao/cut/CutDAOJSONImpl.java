package com.pacificport.pacificsport.dao.cut;
import com.pacificport.pacificsport.bean.json.JSONProcessor;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Component
public class CutDAOJSONImpl implements CutJSONDAO {

    @Autowired
    JSONProcessor jsonProcessor;

    public CutDAOJSONImpl() {
    }

    @Override
    public JSONObject findAll() {
      return jsonProcessor.getAll();
    }
}
