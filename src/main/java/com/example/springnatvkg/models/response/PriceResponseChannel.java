package com.example.springnatvkg.models.response;

import com.example.springnatvkg.models.entities.Channels;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@Getter@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceResponseChannel {
    @JsonProperty("channel_id")
    Long channelId;
    double price;
    @JsonProperty("discount_price")
    double discountPrice;
}
