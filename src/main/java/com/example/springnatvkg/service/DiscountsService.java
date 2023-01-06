package com.example.springnatvkg.service;

import com.example.springnatvkg.models.dto.DiscountsDTO;
import com.example.springnatvkg.models.response.DiscountMinDaysResponse;

import java.util.List;

public interface DiscountsService extends BaseService<DiscountsDTO>{
    List<DiscountMinDaysResponse> getDiscountResponse(Long channelId);

    double getMinusProsent(Long channelId, int dayCount);
}
