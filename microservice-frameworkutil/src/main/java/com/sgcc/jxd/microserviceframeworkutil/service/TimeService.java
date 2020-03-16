package com.sgcc.jxd.microserviceframeworkutil.service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TimeService {

    public String getTime(){
        SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formate.format(new Date());
    }
}

