package com.sgcc.jxd.microserviceorders.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_order")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "filedHandler"})
public class Order implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    private String orderId;
    private double actualFee;
    private double postFee;
    private int paymentType;
    private int userId;
    private int status;
    private Date createTime;
    private int skuId;
    private int num;
}
