package com.cn.dao;

import com.cn.domain.Member;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IMemberDao {
    @Select("select * from member where id=#{id}")
    public List<Member> findById() throws Exception;
}
