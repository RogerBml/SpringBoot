package com.sgcc.jxd.microservicestorage.Reposity;

import com.sgcc.jxd.microservicestorage.bean.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockReposity extends JpaRepository<Storage,String> {
/*    @Query(value = "from tb_stock_storage where sku_id = ?1",nativeQuery = true)
    public Storage findBysku_id(int sku_id);*/
    public Storage findAllBySkuId(int sku_id);
    @Query(value = "insert into  tb_stock_storage values(uuid(),0,?1,?2)",nativeQuery = true)
    public Storage saveReposity(int sku_id,int quanty);
}
