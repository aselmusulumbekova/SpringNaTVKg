package com.example.springnatvkg.service.impl;

import com.example.springnatvkg.mappers.ChannelsMapper;
import com.example.springnatvkg.microservices.FileServiceFeign;
import com.example.springnatvkg.models.dto.ChannelsDTO;
import com.example.springnatvkg.models.response.ChannelsResponse;
import com.example.springnatvkg.repositories.ChannelsRep;
import com.example.springnatvkg.service.ChannelsService;
import com.example.springnatvkg.service.DiscountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ChannelsServiceImpl implements ChannelsService {

    private final ChannelsRep channelsRep;
    private final DiscountsService discountsService;

    private final FileServiceFeign fileServiceFeign;
    ChannelsMapper mapper=ChannelsMapper.INSTANCE;

    @Autowired
    public ChannelsServiceImpl(ChannelsRep channelsRep, DiscountsService discountsService, FileServiceFeign fileServiceFeign) {
        this.channelsRep = channelsRep;
        this.discountsService = discountsService;
        this.fileServiceFeign = fileServiceFeign;
    }

    @Override
    public ChannelsDTO save(String name, int orderNum, MultipartFile photo) {
        ChannelsDTO dto = new ChannelsDTO();
        dto.setName(name);
        dto.setOrderNum(orderNum);
        dto.setPhoto(fileServiceFeign.fileUpload(photo).getDownloadUri());
        ChannelsDTO dtoSave = save(dto);
        return dtoSave;
    }

    @Override
    public ChannelsDTO save(ChannelsDTO channelsDTO) {
        return mapper.toDto(channelsRep.save(mapper.toEntity(channelsDTO)));
    }

    @Override
    public ChannelsDTO findById(Long id) {
        return ChannelsMapper.INSTANCE.toDto(channelsRep.findById(id).orElseThrow(()->new RuntimeException(("accountNotFound"))));
    }

    @Override
    public List<ChannelsDTO> findAll() {
        return ChannelsMapper.INSTANCE.toDtos(channelsRep.findAll());

    }

    @Override
    public List<ChannelsResponse> channelsResponse11() {
        List<ChannelsResponse> list = channelsRep.channelResponse(2,3);


        for (ChannelsResponse item : list) {
            ChannelsResponse channelsResponse = new ChannelsResponse();
            channelsResponse.setDiscountMinDaysResponses(discountsService.getDiscountResponse(item.getId()));
            list.add(channelsResponse);

        }
////        return channelsRep.channels1();
        return null;
    }
}
