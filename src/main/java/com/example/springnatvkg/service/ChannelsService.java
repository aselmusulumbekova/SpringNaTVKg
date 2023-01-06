package com.example.springnatvkg.service;

import com.example.springnatvkg.models.dto.ChannelsDTO;
import com.example.springnatvkg.models.response.ChannelsResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ChannelsService extends BaseService<ChannelsDTO>{
    ChannelsDTO save(String name, int orderNum, MultipartFile photo);

    List<ChannelsResponse> channelsResponse11();
}
