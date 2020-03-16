package com.sgcc.jxd.microservicelogin.repository;

import com.sgcc.jxd.microservicelogin.bean.RolerRight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolerRightRepository extends JpaRepository<RolerRight,Integer> {

}
