package com.sgcc.jxd.microservicelogin.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name ="t_roles")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","filedHandler"})
public class Rolers {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String roleName;

    private String roleDesc;

    private String roleStr;

}
