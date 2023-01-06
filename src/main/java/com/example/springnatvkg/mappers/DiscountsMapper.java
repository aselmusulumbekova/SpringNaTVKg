package com.example.springnatvkg.mappers;

import com.example.springnatvkg.models.dto.DiscountsDTO;
import com.example.springnatvkg.models.entities.Discounts;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface DiscountsMapper extends BaseMapper<Discounts, DiscountsDTO>{
    DiscountsMapper INSTANCE= Mappers.getMapper(DiscountsMapper.class);
}
