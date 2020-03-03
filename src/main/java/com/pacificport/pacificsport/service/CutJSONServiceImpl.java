package com.pacificport.pacificsport.service;

import com.pacificport.pacificsport.dao.cut.CutJSONDAO;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CutJSONServiceImpl implements CutJSONService {

    private CutJSONDAO cutDAO;

    @Autowired
    public CutJSONServiceImpl(CutJSONDAO cutDAO) {
        this.cutDAO = cutDAO;
    }

    @Override
    public JSONObject findAll() {
        return cutDAO.findAll();
    }
}
