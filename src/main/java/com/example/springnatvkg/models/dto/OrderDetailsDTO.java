package com.example.springnatvkg.models.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.springnatvkg.models.entities.OrderDetail} entity
 */
@Data
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailsDTO implements Serializable {
      Long id;
      ChannelsDTO channelsId;
      OrdersDTO ordersId;
      double price;
}