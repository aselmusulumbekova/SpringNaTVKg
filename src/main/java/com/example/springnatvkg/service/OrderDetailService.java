package com.example.springnatvkg.service;


import com.example.springnatvkg.models.dto.OrderDetailsDTO;
import com.example.springnatvkg.models.request.OrdersRequest;
import com.example.springnatvkg.models.request.RequestChannelsText;
import com.example.springnatvkg.models.response.PriceResponse;

public interface OrderDetailService extends BaseService<OrderDetailsDTO> {
    PriceResponse getTotalPriceAll(RequestChannelsText request);

    PriceResponse save(OrdersRequest ordersRequest);
}
