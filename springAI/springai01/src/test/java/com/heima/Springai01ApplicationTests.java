package com.heima;

import com.heima.entity.POJO.Course;
import com.heima.entity.POJO.School;
import com.heima.entity.query.CourseQuery;
import com.heima.tool.CourseTool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Springai01ApplicationTests {
    @Autowired
    private CourseTool courseTool;

    @Test
    public void CourseToolTest() {
        CourseQuery query = new CourseQuery();
        query.setType("编程");
        query.setEdu(4);
        CourseQuery.Sort sort = new CourseQuery.Sort();
        sort.setAsc(true);
        sort.setField("price");
        ArrayList<CourseQuery.Sort> list = new ArrayList<>();
        list.add(sort);
        query.setSorts(list);
        List<Course> courses = courseTool.queryCourse(query);
        System.out.println(courses);
    }

    @Test
    public void CourseToolTest2() {
        List<School> schools = courseTool.querySchool();
    }

    @Test
    public void CourseToolTest3() {
        String s = courseTool.generateCourseReservation("鸿蒙应用开发", "李华",
                "123456", "杭州校区", "要好老师，幽默的");
        System.out.println(s);
    }

}
