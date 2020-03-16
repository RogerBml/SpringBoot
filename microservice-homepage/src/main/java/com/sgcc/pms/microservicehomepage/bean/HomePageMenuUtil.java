package com.sgcc.pms.microservicehomepage.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class HomePageMenuUtil implements Serializable {

    private int  menuid;
    private String menuName;
    private String parentMenuId;
    private String servicePath;
    private List<HomePageMenuUtil> children = new ArrayList<>();
    public HomePageMenuUtil(){

    }
    public HomePageMenuUtil(int id,String menuName,String parentMenuId,String servicePath){
        this.menuid = id;
        this.menuName = menuName;
        this.parentMenuId = parentMenuId;
        this.servicePath = servicePath;

    }
}
