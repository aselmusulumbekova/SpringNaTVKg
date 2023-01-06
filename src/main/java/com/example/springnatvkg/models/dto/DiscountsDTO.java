package com.example.springnatvkg.models.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


/**
 * A DTO for the {@link com.example.springnatvkg.models.entities.Discounts} entity
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class DiscountsDTO implements Serializable {
      Long id;
      ChannelsDTO channelsId;
      double percent;
      Date startDate;
      Date endDate;
      int minDays;
}