package com.example.springnatvkg.service;

import com.example.springnatvkg.models.dto.DaysDTO;
import com.example.springnatvkg.models.dto.OrderDetailsDTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface DaysService extends BaseService<DaysDTO>{
    void save(OrderDetailsDTO dto, List<Date> days);
}
