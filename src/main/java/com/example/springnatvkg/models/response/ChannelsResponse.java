package com.example.springnatvkg.models.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelsResponse {
    Long id;
    String name;
    String photo;
    double price;
    int orderNum;
    private List<DiscountMinDaysResponse> discountMinDaysResponses;

    public ChannelsResponse(Long id, String name, String photo, double price, int orderNum) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.price = price;
        this.orderNum = orderNum;
    }
}
