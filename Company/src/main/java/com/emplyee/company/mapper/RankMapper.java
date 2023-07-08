package com.emplyee.company.mapper;

import com.emplyee.company.pojo.Ran;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RankMapper {

    //修改薪资
    int updatePrice(Ran rank);

    //查找num
    @Select("select num from ran where duty=#{duty}")
    Integer selectnum(String duty);

    //展示页面
    @Select("select * from ran")
    List<Ran> Find();
}
