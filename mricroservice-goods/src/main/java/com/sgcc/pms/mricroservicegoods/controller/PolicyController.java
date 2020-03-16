package com.sgcc.pms.mricroservicegoods.controller;

import com.sgcc.pms.mricroservicegoods.bean.Policy;
import com.sgcc.pms.mricroservicegoods.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/policy")
public class PolicyController {
    @Autowired
    private PolicyService policyService;

    @PostMapping("/save")
    public boolean  insertLimitPolicy(Policy policy)
    {
        return policyService.inserLimitPolicy(policy);
    }
    @GetMapping("/{sku_id}")
    public Policy findPolicyBySkuid(@PathVariable("sku_id") int sku_id){
        return policyService.findPolicyBySkuid(sku_id);
    }
    @DeleteMapping("/{sku_id}")
    public boolean removePolicyBySkuid(@PathVariable("sku_id")int sku_id) {
        boolean b = policyService.removePolicyBySkuid(sku_id);
        return b;
    }
    @PutMapping("/update")
    public boolean modifyPolicyBySkuid(Policy policy) {
        boolean b = policyService.modifyPolicyBySkuid(policy);
        return b;
    }
}
