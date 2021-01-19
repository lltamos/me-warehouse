package com.me.mesite.database;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UpmsUserDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(UpmsUser record);

    int insertSelective(UpmsUser record);

    UpmsUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UpmsUser record);

    int updateByPrimaryKey(UpmsUser record);
}