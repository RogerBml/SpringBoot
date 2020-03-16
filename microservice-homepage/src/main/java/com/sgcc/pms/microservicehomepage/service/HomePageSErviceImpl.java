package com.sgcc.pms.microservicehomepage.service;

import com.sgcc.pms.microservicehomepage.ToolsUtil.TreeUtils;
import com.sgcc.pms.microservicehomepage.bean.HomePageMenu;
import com.sgcc.pms.microservicehomepage.bean.HomePageMenuUtil;
import com.sgcc.pms.microservicehomepage.repository.HomePageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
public class HomePageSErviceImpl implements HomePageService {

    @Autowired
    private HomePageRepository homePageRepository;
    @Override
    @Cacheable(value = "homepageCache")
    public List<HomePageMenuUtil> getAllMenu() {
        List<HomePageMenu> Menus = homePageRepository.findAll();
        List<HomePageMenuUtil> nodeList = new ArrayList<>();
        for (HomePageMenu menutil :Menus){
            nodeList.add(new HomePageMenuUtil(menutil.getMenuid(), menutil.getMenuName(), menutil.getParentMenuId(),menutil.getServicePath()));
        }
        List<HomePageMenuUtil> nodeTree = TreeUtils.getTree(nodeList);
        return nodeTree;
    }
    @CacheEvict(value = "homepageCache",allEntries = true)
    @Transactional
    public boolean saveHomePageMenu(HomePageMenu homePageMenu){
        HomePageMenu pageMenu = homePageRepository.save(homePageMenu);
        if(pageMenu !=null){
            return true;
        }else{
            return false;
        }

    }
}
