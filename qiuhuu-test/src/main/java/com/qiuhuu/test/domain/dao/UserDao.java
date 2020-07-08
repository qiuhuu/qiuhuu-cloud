package com.qiuhuu.test.domain.dao;

import com.qiuhuu.test.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User Jpa数据访问
 * @author : qiuhuu
 * @date : 2020-07-06 10-14
 */
public interface UserDao extends JpaRepository<User, Integer> {}
