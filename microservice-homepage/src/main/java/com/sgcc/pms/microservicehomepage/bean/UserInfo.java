package com.sgcc.pms.microservicehomepage.bean;

import lombok.Data;

@Data
public class UserInfo {
    private Integer userid;

    private String username;

    private String password;

    private String dtbase;
}
