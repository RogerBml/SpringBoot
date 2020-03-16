package com.sgcc.jxd.microservicelogin.service;

import com.sgcc.jxd.microservicelogin.bean.RolerRight;
import com.sgcc.jxd.microservicelogin.repository.RolerRightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolerRightServiceImpl implements RolerRightService {
    @Autowired
    private RolerRightRepository rolerRightRepository;
    @Override
    public List<RolerRight> listRight() {
        List<RolerRight> rightList = rolerRightRepository.findAll();
        return rightList;
    }
}
