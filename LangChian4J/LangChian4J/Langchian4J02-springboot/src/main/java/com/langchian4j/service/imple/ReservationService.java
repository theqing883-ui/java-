package com.langchian4j.service.imple;

import com.langchian4j.POJO.Reservation;
import com.langchian4j.mapper.ReservationMapper;
import com.langchian4j.service.IReservationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ReservationService implements IReservationService {
    @Resource
    ReservationMapper reservationMapper;
    @Override
    public void insert(Reservation reservation) {
        reservationMapper.insert(reservation);
    }

    @Override
    public Reservation select(String phone) {
        return reservationMapper.select(phone);
    }
}
