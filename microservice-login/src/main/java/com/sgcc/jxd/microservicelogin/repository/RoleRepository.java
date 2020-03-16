package com.sgcc.jxd.microservicelogin.repository;

import com.sgcc.jxd.microservicelogin.bean.Rolers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Rolers,Integer> {
}
