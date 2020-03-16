package com.sgcc.jxd.microservicelogin.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name ="t_rolerright")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","filedHandler"})
public class RolerRight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String psName;

    private String frontUrl;

    private String psUrl;

    private String method;

    private String scope;

}
