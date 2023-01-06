package com.example.springnatvkg.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelsRequest {
    String name;
    Boolean active;
    @JsonProperty("order_num")
    int orderNum;
    String photo;
}
