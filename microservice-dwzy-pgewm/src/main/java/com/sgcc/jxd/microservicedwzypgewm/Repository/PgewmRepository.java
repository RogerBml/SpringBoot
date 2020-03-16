package com.sgcc.jxd.microservicedwzypgewm.Repository;

import com.sgcc.jxd.microservicedwzypgewm.bean.Pgewm;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PgewmRepository extends ReactiveMongoRepository<Pgewm,String> {
}
