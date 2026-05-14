package com.langchian4j.tools;

import com.langchian4j.POJO.Reservation;
import com.langchian4j.service.IReservationService;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReservationTool {
    @Resource
    IReservationService reservationService;

    // 添加考生
    @Tool("预约考生自愿填报服务")
    public void addReservation(
            @P("考生姓名") String name,
            @P("考生性别") String gender,
            @P("考生电话") String phone,
            @P("预约时间,格式：yyy-MM-dd'T'HH:mm") String communicationTime,
            @P("考生省份") String province,
            @P("考生预估分数") Integer estimatedScore
    ) {
        Reservation reservation = new Reservation(null, name, gender, phone,
                LocalDateTime.parse(communicationTime), province, estimatedScore);
        reservationService.insert(reservation);
    }

    // 查询考生
    @Tool("查询考试信息")
    public Reservation selectReservation(@P("考生电话") String phone) {
        return reservationService.select(phone);
    }
}
