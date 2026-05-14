package com.heima.tool;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.heima.entity.POJO.Course;
import com.heima.entity.POJO.CourseReservation;
import com.heima.entity.POJO.School;
import com.heima.entity.query.CourseQuery;
import com.heima.service.ICourseReservationService;
import com.heima.service.ICourseService;
import com.heima.service.ISchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 课程工具类
 * 提供课程查询、校区查询和课程预约生成功能
 */
@RequiredArgsConstructor
@Component
public class CourseTool {
    
    /**
     * 课程服务
     * 用于处理课程相关的业务逻辑
     */
    private final ICourseService courseService;
    
    /**
     * 学校服务
     * 用于处理学校相关的业务逻辑
     */
    private final ISchoolService schoolService;
    
    /**
     * 课程预约服务
     * 用于处理课程预约相关的业务逻辑
     */
    private final ICourseReservationService reservationService;

    /**
     * 查询课程
     * @param query 课程查询条件
     * @return 课程列表
     */
    @Tool
    public List<Course> queryCourse(@ToolParam(required = false, description = "课程查询条件") CourseQuery query) {
        // 1. 从 service 获取查询链包装器
        QueryChainWrapper<Course> wrapper = courseService.query();

        // 2. 添加查询条件（动态非空判断）
        wrapper
                .eq(query.getType() != null, "type", query.getType()) // 课程类型
                .le(query.getEdu() != null, "edu", query.getEdu()); // 教育程度

        // 3. 添加排序条件（支持多个排序字段）
        if (query.getSorts() != null) {
            for (CourseQuery.Sort sort : query.getSorts()) {
                wrapper.orderBy(true, sort.getAsc(), sort.getField());
            }
        }

        // 4. 执行查询并返回结果列表
        return wrapper.list();
    }

    /**
     * 查询所有校区
     * @return 校区列表
     */
    @Tool(description = "查询所有校区")
    public List<School> querySchool() {
        return schoolService.list();
    }

    /**
     * 生成课程预约单
     * @param courseName 课程名称
     * @param studentName 学生名字
     * @param contactInfo 学生电话
     * @param school 预约的校区
     * @param remark 备注
     * @return 生成的预约单号
     */
    @Tool(description = "生成课程预约单,并返回生成的预约单号")
    public String generateCourseReservation(
            @ToolParam(description = "课程名称") String courseName,
            @ToolParam(description = "学生名字") String studentName,
            @ToolParam(description = "学生电话") String contactInfo,
            @ToolParam(description = "预约的校区") String school,
            @ToolParam(description = "备注") String remark) {
        // 创建课程预约对象
        CourseReservation reservation = new CourseReservation(null, courseName, studentName, contactInfo, school, remark);
        // 保存预约信息
        reservationService.save(reservation);
        // 返回预约单号
        return String.valueOf(reservation.getId());
    }

}