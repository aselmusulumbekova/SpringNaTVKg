package com.example.springnatvkg.mappers;

import com.example.springnatvkg.models.dto.ChannelsDTO;
import com.example.springnatvkg.models.entities.Channels;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ChannelsMapper extends BaseMapper<Channels, ChannelsDTO> {
    ChannelsMapper INSTANCE= Mappers.getMapper(ChannelsMapper.class);
}
