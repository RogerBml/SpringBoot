package com.sgcc.pms.microservicehomepage.service;

import com.sgcc.pms.microservicehomepage.bean.HomePageMenu;
import com.sgcc.pms.microservicehomepage.bean.HomePageMenuUtil;

import java.util.List;

public interface HomePageService {
    List<HomePageMenuUtil> getAllMenu();
    boolean saveHomePageMenu(HomePageMenu homePageMenu);
}
