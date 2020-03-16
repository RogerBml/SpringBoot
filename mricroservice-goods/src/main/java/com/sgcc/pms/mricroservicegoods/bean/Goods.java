package com.sgcc.pms.mricroservicegoods.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity(name ="tb_sku")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","filedHandler"})
public class Goods implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sku_id;

    private String title ;

    private String iamges;

    private int stock;

    private Double price;

    private String indexes;

    private String own_spec;


}
