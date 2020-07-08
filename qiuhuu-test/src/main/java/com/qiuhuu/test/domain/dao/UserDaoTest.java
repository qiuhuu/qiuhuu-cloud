package com.qiuhuu.test.domain.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author : qiuhuu
 * @date : 2020-07-06 10-47
 */
@Mapper
public interface UserDaoTest {

    void findById(int id);
}
