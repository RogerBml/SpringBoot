package com.sgcc.pms.microservicehomepage.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name ="t_homepagemet")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","filedHandler"})
public class HomePageMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  menuid;
    private String menuName;
    private String parentMenuId;
    private String servicePath;
}
