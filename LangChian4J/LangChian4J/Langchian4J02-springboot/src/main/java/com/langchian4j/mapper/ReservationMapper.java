package com.langchian4j.mapper;

import com.langchian4j.POJO.Reservation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ReservationMapper {

    //添加
    @Insert("insert into reservation(name, gender,phone,communication_time,province,estimated_score)" +
            " values (#{name},#{gender},#{phone},#{communicationTime},#{province},#{estimatedScore})")
    void insert(Reservation reservation);

    //查询
    @Select("select * from reservation where phone = #{phone}")
    Reservation select(String phone);

}
