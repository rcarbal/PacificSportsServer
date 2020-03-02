package com.pacificport.pacificsport.dao;
import com.pacificport.pacificsport.bean.json.JSONProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class CutDAOJSONImpl implements CutJSONDAO {

    @Autowired
    JSONProcessor jsonProcessor;

    public CutDAOJSONImpl() {
    }

    @Override
    public String findAll() {
      return jsonProcessor.getAll();
    }
}
