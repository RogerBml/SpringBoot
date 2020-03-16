package com.sgcc.jxd.microservicelogin.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity(name ="t_userinfo")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","filedHandler"})
public class UserInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    private String username;

    private String password;

    private String dtbase;

    private String tel;

    private String email;

    private String role;

    private  String status;
}
