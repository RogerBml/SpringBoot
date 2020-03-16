package com.sgcc.jxd.microservicelogin.repository;

import com.sgcc.jxd.microservicelogin.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserinfoRepository extends JpaRepository<UserInfo,Integer> {
    // @Query("select u from t_userinfo u where u.userName =:#{#user.userName} and u.password = :#{#user.password}")
    //UserInfo findByuserNameAndpassword(UserInfo user);
   UserInfo findByUsernameAndPassword(String username,String password);
   UserInfo findByUsername(String username);
}
