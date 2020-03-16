package com.sgcc.pms.microservicehomepage.controller;

import com.sgcc.pms.microservicehomepage.bean.HomePageMenu;
import com.sgcc.pms.microservicehomepage.bean.HomePageMenuUtil;
import com.sgcc.pms.microservicehomepage.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/homepage")
@RefreshScope
public class PageHomeController {

    @Autowired
    private HomePageService homePageService;
    @GetMapping("/menus")
    public List<HomePageMenuUtil> getHomePageMenu(){
        return homePageService.getAllMenu();
    }
    @PostMapping("/menus")
    public boolean saveHomePageMenu(HomePageMenu homePageMenu){
        return homePageService.saveHomePageMenu(homePageMenu);
    }
}
