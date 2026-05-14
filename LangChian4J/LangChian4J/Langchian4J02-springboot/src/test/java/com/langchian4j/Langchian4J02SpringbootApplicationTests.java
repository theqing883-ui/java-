package com.langchian4j;

import com.langchian4j.POJO.Reservation;
import com.langchian4j.service.IReservationService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
class Langchian4J02SpringbootApplicationTests {

    @Resource
    IReservationService reservationService;
    @Test
    public void serviceTest(){
        Reservation reservation = new Reservation();
        reservation.setId(1L);
        reservation.setName("july");
        reservation.setPhone("11408");
        reservation.setGender("女");
        reservation.setCommunicationTime(LocalDateTime.now());
        reservation.setProvince("安徽");
        reservation.setEstimatedScore(501);
        reservationService.insert(reservation);
    }
    @Test
    public void serviceSelectTest(){
        String phone = "11408";
        Reservation reservation = reservationService.select(phone);
        log.info("查询结果：{}",reservation);
    }
}
