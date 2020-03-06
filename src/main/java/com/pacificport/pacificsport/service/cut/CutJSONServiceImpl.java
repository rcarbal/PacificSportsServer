package com.pacificport.pacificsport.service.cut;

import com.pacificport.pacificsport.dao.cut.CutJSONDAO;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CutJSONServiceImpl implements CutJSONService {

    private CutJSONDAO cutDAO;

    @Autowired
    public CutJSONServiceImpl(CutJSONDAO cutDAO) {
        this.cutDAO = cutDAO;
    }

    @Override
    public HashMap<String, JSONObject> findAll() {
        return cutDAO.findAll();
    }

    @Override
    public JSONObject getCutNumber(String number) {
        return cutDAO.getCutNumber(number);
    }
}
