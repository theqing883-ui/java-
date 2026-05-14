package com.heima.entity.POJO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 课程实体类
 * 对应数据库中的course表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("course")
public class Course implements Serializable {
    
    /**
     * 课程ID，自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    
    /**
     * 课程名称
     */
    private String name;
    
    /**
     * 教育程度
     */
    private String edu;
    
    /**
     * 课程类型
     */
    private String type;
    
    /**
     * 课程时长
     */
    private String duration;
    
    /**
     * 课程价格
     */
    private String price;
}