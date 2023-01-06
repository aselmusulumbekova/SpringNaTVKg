package com.example.springnatvkg.service.impl;
import com.example.springnatvkg.mappers.DaysMapper;
import com.example.springnatvkg.models.dto.DaysDTO;
import com.example.springnatvkg.models.dto.OrderDetailsDTO;
import com.example.springnatvkg.repositories.DaysRep;
import com.example.springnatvkg.service.DaysService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DaysServiceImpl implements DaysService {
    private final DaysRep rep;
    DaysMapper mapper=DaysMapper.INSTANCE;

    public DaysServiceImpl(DaysRep rep) {
        this.rep = rep;
    }

    @Override
    public DaysDTO save(DaysDTO daysDTO) {
        return mapper.toDto(rep.save(mapper.toEntity(daysDTO)));
    }

    @Override
    public DaysDTO findById(Long id) {
        return DaysMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(()->new RuntimeException("")));
    }

    @Override
    public List<DaysDTO> findAll() {
        return  DaysMapper.INSTANCE.toDtos(rep.findAll());
    }

    public void save(OrderDetailsDTO dto, List<Date> days) {
        for (var day: days){
            DaysDTO daysDTO=new DaysDTO();
            daysDTO.setOrderDetailId(dto);
            daysDTO.setDay(day);
            this.save(daysDTO);
        }
    }
}
