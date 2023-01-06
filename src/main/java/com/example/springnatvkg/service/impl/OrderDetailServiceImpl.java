package com.example.springnatvkg.service.impl;
import com.example.springnatvkg.mappers.OrderDetailsMapper;
import com.example.springnatvkg.models.dto.OrderDetailsDTO;
import com.example.springnatvkg.models.dto.OrdersDTO;
import com.example.springnatvkg.models.request.ChannelRequest1;
import com.example.springnatvkg.models.request.OrdersRequest;
import com.example.springnatvkg.models.request.RequestChannelsText;
import com.example.springnatvkg.models.response.PriceResponse;
import com.example.springnatvkg.models.response.PriceResponseChannel;
import com.example.springnatvkg.repositories.OrderDetailRep;
import com.example.springnatvkg.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    DiscountsService discountsService;
    @Autowired
    PricesService pricesService;
    @Autowired
    OrdersService ordersService;
    @Autowired
    ChannelsService channelsService;
    @Autowired
    DaysService daysService;
    @Autowired
    OrderDetailRep rep;
    OrderDetailsMapper mapper= OrderDetailsMapper.INSTANCE;
    @Override
    public OrderDetailsDTO save(OrderDetailsDTO orderDetailsDTO) {
        return mapper.toDto(rep.save(mapper.toEntity(orderDetailsDTO)));
    }

    @Override
    public OrderDetailsDTO findById(Long id) {
        return OrderDetailsMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(()->new RuntimeException("")));
    }

    @Override
    public List<OrderDetailsDTO> findAll() {
        return  OrderDetailsMapper.INSTANCE.toDtos(rep.findAll());
    }

    public PriceResponse getTotalPriceAll(RequestChannelsText request) {
        double price=0;
        double priceDiscount = 0;
        PriceResponse priceResponse = new PriceResponse();
        List<PriceResponseChannel>channelList=new ArrayList<>();
        for (var item: request.getDayChannelRequest1()){
            PriceResponseChannel priceResponseChannel = getTotalPrice(item,request.getText());
            price += priceResponseChannel.getPrice();
            priceDiscount += priceResponseChannel.getDiscountPrice();
            channelList.add(priceResponseChannel);
        }

        priceResponse.setChannelList(channelList);
        priceResponse.setTotalPrice(price);
        priceResponse.setTotalPriceDiscount(priceDiscount);

        return priceResponse;
    }

    @Override
    public PriceResponse save(OrdersRequest ordersRequest) {
        PriceResponse priceResponse=new PriceResponse();
        OrdersDTO ordersDTO= new OrdersDTO();
        ordersDTO.setEmail(ordersRequest.getEmail());
        ordersDTO.setPhone(ordersDTO.getPhone());
        ordersDTO.setText(ordersRequest.getText());
        ordersDTO.setName(ordersRequest.getName());
        ordersDTO.setTotal_price(getTotalPriceAll(new RequestChannelsText(ordersRequest.getText(),ordersRequest.getChannels())).getTotalPriceDiscount());
        ordersDTO = ordersService.save(ordersDTO);

        for (var item : ordersRequest.getChannels()){
            OrderDetailsDTO dto=new OrderDetailsDTO();
            dto.setChannelsId(channelsService.findById(item.getChannelsId()));
            dto.setPrice(getTotalPrice(item,ordersRequest.getText()).getDiscountPrice());
            dto.setOrdersId(ordersDTO);
            dto=save(dto);
            daysService.save(dto,item.getDays());
        }

        return priceResponse;
    }

    private PriceResponseChannel getTotalPrice(ChannelRequest1 request, String text) {
        PriceResponseChannel priceResponseChannel= new PriceResponseChannel();
        int textLan = text.replace(" ","").length();
        double price = pricesService.getActualniiPrice(request.getChannelsId(),request.getDays(),textLan);
        priceResponseChannel.setPrice(price);
        priceResponseChannel.setChannelId(request.getChannelsId());
        priceResponseChannel.setDiscountPrice(price*discountsService.getMinusProsent(request.getChannelsId(),request.getDays().size()));

        return priceResponseChannel;
    }
}
