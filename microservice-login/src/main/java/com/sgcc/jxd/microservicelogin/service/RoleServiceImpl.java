package com.sgcc.jxd.microservicelogin.service;

import com.sgcc.jxd.microservicelogin.bean.Rolers;
import com.sgcc.jxd.microservicelogin.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Rolers> listRolers() {

        return roleRepository.findAll();
    }
}
