package com.sgcc.pms.microservicehomepage.repository;

import com.sgcc.pms.microservicehomepage.bean.HomePageMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomePageRepository extends JpaRepository<HomePageMenu,String> {
    public List<HomePageMenu> getAllByParentMenuIdIsNull();
    public List<HomePageMenu> getAllByParentMenuIdIsNotNull();
}
