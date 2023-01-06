package com.example.springnatvkg.mappers;

import com.example.springnatvkg.models.dto.DaysDTO;
import com.example.springnatvkg.models.entities.Days;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DaysMapper extends BaseMapper<Days, DaysDTO>{
    DaysMapper INSTANCE = Mappers.getMapper(DaysMapper.class);

}
