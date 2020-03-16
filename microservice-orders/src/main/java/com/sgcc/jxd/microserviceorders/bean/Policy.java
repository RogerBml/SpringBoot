package com.sgcc.jxd.microserviceorders.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy implements Serializable {
    private int id;
    private int skuId;
    private int quanty;
    private Double price;
    private Date beginTime;
    private Date endTime;
}
