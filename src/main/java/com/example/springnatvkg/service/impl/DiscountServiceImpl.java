package com.example.springnatvkg.service.impl;

import com.example.springnatvkg.mappers.DiscountsMapper;
import com.example.springnatvkg.models.dto.DiscountsDTO;
import com.example.springnatvkg.models.response.DiscountMinDaysResponse;
import com.example.springnatvkg.repositories.DiscountRep;
import com.example.springnatvkg.service.DiscountsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountsService {
    final DiscountRep rep;
    DiscountsMapper mapper = DiscountsMapper.INSTANCE;

    public DiscountServiceImpl(DiscountRep rep) {
        this.rep = rep;
    }

    @Override
    public DiscountsDTO save(DiscountsDTO discountsDTO) {
        return mapper.toDto(rep.save(mapper.toEntity(discountsDTO)));
    }

    @Override
    public DiscountsDTO findById(Long id) {
        return DiscountsMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("")));
    }

    @Override
    public List<DiscountsDTO> findAll() {
        return DiscountsMapper.INSTANCE.toDtos(rep.findAll());
    }

    @Override
    public List<DiscountMinDaysResponse> getDiscountResponse(Long channelId) {
        return null;
    }

    @Override
    public double getMinusProsent(Long channelId, int dayCount) {
        DiscountMinDaysResponse actualniiDiscount = rep.getDistinct(channelId, dayCount);

        if (actualniiDiscount.getPercent()!= null ){
        if ( actualniiDiscount.getPercent() == 0)
            return 1;
        return (100 - actualniiDiscount.getPercent()) / 100;

    }return 1;
    }
}
