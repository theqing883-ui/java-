package com.heima.entity.POJO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * 课程预约实体类
 * 对应数据库中的course_reservation表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("course_reservation")
@AllArgsConstructor
public class CourseReservation  implements Serializable {
    
    /**
     * 预约ID，自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    
    /**
     * 课程名称
     */
    private String course;
    
    /**
     * 学生姓名
     */
    private String studentName;
    
    /**
     * 联系信息
     */
    private String contactInfo;
    
    /**
     * 学校/校区
     */
    private String school;
    
    /**
     * 备注信息
     */
    private String remark;
}