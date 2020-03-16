package com.sgcc.jxd.microservicestorage.Reposity;

import com.sgcc.jxd.microservicestorage.bean.StorageHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockHistoryReposity extends JpaRepository<StorageHistory,String> {

}
