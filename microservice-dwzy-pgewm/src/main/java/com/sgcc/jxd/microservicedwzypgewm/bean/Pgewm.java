package com.sgcc.jxd.microservicedwzypgewm.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "t_pgewm")
public class Pgewm {
    @Id
    private String id;
    private String pgName;
    private String ewmid;
    private String fjmc;
}
