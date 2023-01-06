package com.example.springnatvkg.models.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


/**
 * A DTO for the {@link com.example.springnatvkg.models.entities.Prices} entity
 */
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class PricesDTO implements Serializable {
      Long id;
      ChannelsDTO channelsId;
      Date startDate;
      Date endDate;
      double price;
}