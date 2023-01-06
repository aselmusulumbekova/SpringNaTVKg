package com.example.springnatvkg.mappers;
import com.example.springnatvkg.models.dto.PricesDTO;
import com.example.springnatvkg.models.entities.Prices;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface PricesMapper extends BaseMapper<Prices, PricesDTO>{
   PricesMapper INSTANCE= Mappers.getMapper(PricesMapper.class);


}
