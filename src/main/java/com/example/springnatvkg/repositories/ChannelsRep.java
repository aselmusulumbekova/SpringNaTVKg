package com.example.springnatvkg.repositories;

import com.example.springnatvkg.models.entities.Channels;
import com.example.springnatvkg.models.response.ChannelsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChannelsRep extends JpaRepository<Channels,Long> {

    @Query(value = "select c.name, c.photo, c.id,p.price from tb_channels c \n" +
            "inner join tb_prices p on p.channels_id=c.id order by c.order_num\n" +
            "limit ?1 offset ?2",nativeQuery = true)
    List<ChannelsResponse> channelResponse(int limit,int offset);

//    @Query(value = "select new com.example.springnatvkg.models.response.ChannelsResponse(" +
//            "ch.id," +1234
//            "ch.name," +
//            "ch.photo," +
//            "p.price," +
//            "ch.orderNum) from Channels ch join ch.price p ")
//    List<ChannelsResponse> channels1();
}
