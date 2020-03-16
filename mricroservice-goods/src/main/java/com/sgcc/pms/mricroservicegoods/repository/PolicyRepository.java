package com.sgcc.pms.mricroservicegoods.repository;

import com.sgcc.pms.mricroservicegoods.bean.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy,Integer> {

        public Policy findAllBySkuId(int skuid);
        public Policy deleteAllBySkuId(int skuid);
}
