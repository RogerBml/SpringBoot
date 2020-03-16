package com.sgcc.pms.mricroservicegoods.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name ="tb_limit_policy")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","filedHandler"})
public class Policy implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int skuId;
    private int quanty;
    private Double price;
    private Date beginTime;
    private Date endTime;
}
