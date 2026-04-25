package com.heima.entity.POJO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("course_reservation")
@AllArgsConstructor
public class CourseReservation  implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String course;
    private String studentName;
    private String contactInfo;
    private String school;
    private String remark;
}
