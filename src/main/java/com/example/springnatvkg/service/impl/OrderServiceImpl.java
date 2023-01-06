package com.example.springnatvkg.service.impl;
import com.example.springnatvkg.mappers.OrdersMapper;
import com.example.springnatvkg.models.dto.OrdersDTO;
import com.example.springnatvkg.models.request.OrdersRequest;
import com.example.springnatvkg.models.request.RequestChannelsText;
import com.example.springnatvkg.repositories.OrdersRep;
import com.example.springnatvkg.service.OrderDetailService;
import com.example.springnatvkg.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OrderServiceImpl implements OrdersService {

    final OrdersRep ordersRep;
    OrdersMapper mapper=OrdersMapper.INSTANCE;

    public OrderServiceImpl(OrdersRep ordersRep) {

        this.ordersRep = ordersRep;
    }

    @Override
    public OrdersDTO save(OrdersDTO ordersDTO) {
        return mapper.toDto(ordersRep.save(mapper.toEntity(ordersDTO)));
    }

    @Override
    public OrdersDTO findById(Long id) {
        return OrdersMapper.INSTANCE.toDto(ordersRep.findById(id).orElseThrow(()->new RuntimeException("")));
    }

    @Override
    public List<OrdersDTO> findAll() {
        return  OrdersMapper.INSTANCE.toDtos(ordersRep.findAll());
    }

}
