package com.example.springnatvkg.mappers;

import com.example.springnatvkg.models.dto.OrderDetailsDTO;
import com.example.springnatvkg.models.entities.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface OrderDetailsMapper extends BaseMapper<OrderDetail, OrderDetailsDTO>{
    OrderDetailsMapper INSTANCE= Mappers.getMapper(OrderDetailsMapper.class);
}
