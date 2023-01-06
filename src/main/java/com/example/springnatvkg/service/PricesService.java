package com.example.springnatvkg.service;

import com.example.springnatvkg.models.dto.PricesDTO;
import com.example.springnatvkg.models.request.PriceRequest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PricesService extends BaseService<PricesDTO> {
    int getActualniiPrice(Long channelsId, List<Date> days, int textLan);

    PricesDTO save(PriceRequest request);
}
