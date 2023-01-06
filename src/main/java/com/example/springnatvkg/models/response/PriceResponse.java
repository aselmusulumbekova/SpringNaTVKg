package com.example.springnatvkg.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceResponse {
   @JsonProperty("total_price")
   double totalPrice;
   @JsonProperty("total_price_discount")
   double totalPriceDiscount;
   @JsonProperty("channels")
   List<PriceResponseChannel>channelList;

}
