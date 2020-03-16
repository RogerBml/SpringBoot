package com.sgcc.jxd.microservicestorage.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name ="tb_stock_storage")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","filedHandler"})
public class Storage {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    private String warehouseId;
    private int skuId;
    private int quanty;
}
