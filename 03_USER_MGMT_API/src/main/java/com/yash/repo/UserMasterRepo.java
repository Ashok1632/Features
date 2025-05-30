package com.yash.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.entity.UserMaster;
@Repository
public interface UserMasterRepo extends JpaRepository<UserMaster, Integer> {
public UserMaster findByEmailAndPassword(String email,String pwd);
public UserMaster findByEmail(String email);

}
