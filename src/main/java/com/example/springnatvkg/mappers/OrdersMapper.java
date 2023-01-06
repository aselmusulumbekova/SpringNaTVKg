package com.example.springnatvkg.mappers;

import com.example.springnatvkg.models.dto.OrdersDTO;
import com.example.springnatvkg.models.entities.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface OrdersMapper extends  BaseMapper<Orders, OrdersDTO> {
   OrdersMapper INSTANCE= Mappers.getMapper(OrdersMapper.class);
}
