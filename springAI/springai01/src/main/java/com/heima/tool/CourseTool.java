package com.heima.tool;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.heima.entity.POJO.Course;
import com.heima.entity.POJO.CourseReservation;
import com.heima.entity.POJO.School;
import com.heima.entity.query.CourseQuery;
import com.heima.service.ICourseService;
import com.heima.service.ICourseReservationService;
import com.heima.service.ISchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CourseTool {
    private final ICourseService courseService;
    private final ISchoolService schoolService;
    private final ICourseReservationService reservationService;

    @Tool
    public List<Course> queryCourse(@ToolParam(required = false, description = "课程查询条件") CourseQuery query) {
        // 1. 从 service 获取查询链包装器
        QueryChainWrapper<Course> wrapper = courseService.query();

        // 2. 添加查询条件（动态非空判断）
        wrapper
                .eq(query.getType() != null, "type", query.getType())
                .le(query.getEdu() != null, "edu", query.getEdu());

        // 3. 添加排序条件（支持多个排序字段）
        if (query.getSorts() != null) {
            for (CourseQuery.Sort sort : query.getSorts()) {
                wrapper.orderBy(true, sort.getAsc(), sort.getField());
            }
        }

        // 4. 执行查询并返回结果列表
        return wrapper.list();
    }

    @Tool(description = "查询所有校区")
    public List<School> querySchool() {
        return schoolService.list();
    }

    @Tool(description = "生成课程预约单,并返回生成的预约单号")
    public String generateCourseReservation(
            @ToolParam(description = "课程名称") String courseName,
            @ToolParam(description = "学生名字") String studentName,
            @ToolParam(description = "学生电话") String contactInfo,
            @ToolParam(description = "预约的校区") String school,
            @ToolParam(description = "备注") String remark) {
        CourseReservation reservation = new CourseReservation(null, courseName, studentName, contactInfo, school, remark);
        reservationService.save(reservation);
        return String.valueOf(reservation.getId());
    }

}
