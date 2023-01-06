package com.example.springnatvkg.models.dto;

import com.example.springnatvkg.models.enums.OrderStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


/**
 * A DTO for the {@link com.example.springnatvkg.models.entities.Orders} entity
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class OrdersDTO implements Serializable {
      Long id;
      String text;
      String name;
      int phone;
      String email;
      double total_price;
      Date editDate;
      Date addDate;
      OrderStatus status;
}