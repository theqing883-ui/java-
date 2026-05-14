package com.langchian4j.service;

import com.langchian4j.POJO.Reservation;

public interface IReservationService {
    void insert(Reservation reservation);
    Reservation select(String phone);
}
