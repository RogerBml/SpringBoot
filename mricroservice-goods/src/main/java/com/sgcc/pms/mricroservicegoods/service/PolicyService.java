package com.sgcc.pms.mricroservicegoods.service;

import com.sgcc.pms.mricroservicegoods.bean.Policy;

public interface PolicyService {

    public boolean inserLimitPolicy(Policy policy );
    public Policy findPolicyBySkuid(int sku_id);
    public boolean removePolicyBySkuid(int id);
    public boolean modifyPolicyBySkuid(Policy policy);

    }
