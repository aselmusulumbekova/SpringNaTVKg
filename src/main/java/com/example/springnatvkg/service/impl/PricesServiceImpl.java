package com.example.springnatvkg.service.impl;
import com.example.springnatvkg.mappers.PricesMapper;
import com.example.springnatvkg.models.dto.PricesDTO;
import com.example.springnatvkg.models.request.PriceRequest;
import com.example.springnatvkg.repositories.PricesRep;
import com.example.springnatvkg.service.ChannelsService;
import com.example.springnatvkg.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class PricesServiceImpl implements PricesService {
    @Autowired
    ChannelsService channelsService;
    @Autowired
    PricesRep pricesRep;
    PricesMapper mapper=PricesMapper.INSTANCE;
    @Override
    public PricesDTO save(PricesDTO pricesDTO) {
        return mapper.toDto(pricesRep.save(mapper.toEntity(pricesDTO)));
    }

    @Override
    public PricesDTO findById(Long id) {
        return PricesMapper.INSTANCE.toDto(pricesRep.findById(id).orElseThrow(()->new RuntimeException("")));
    }

    @Override
    public List<PricesDTO> findAll() {
        return  PricesMapper.INSTANCE.toDtos(pricesRep.findAll());
    }


    @Override
    public int getActualniiPrice(Long channelsId, List<Date> days, int textLan) {

        return pricesRep.findPrice(channelsId)*days.size()*textLan;
    }

    @Override
    public PricesDTO save(PriceRequest request) {
        PricesDTO pricesDTO = new PricesDTO();
        pricesDTO.setPrice(request.getPrice());
        pricesDTO.setEndDate(request.getEndDate());
        pricesDTO.setStartDate(request.getStartDate());
        pricesDTO.setChannelsId(channelsService.findById(request.getChannelId()));
        return save(pricesDTO);
    }
}
