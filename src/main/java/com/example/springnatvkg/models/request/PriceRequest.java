package com.example.springnatvkg.models.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceRequest {
    @JsonProperty("channel_id")
    Long channelId;
    @JsonProperty("start_date")
    @JsonFormat(pattern = "YYYY.MM.DD")
    Date startDate;
    @JsonProperty("end_date")
    @JsonFormat(pattern = "YYYY.MM.DD")
    Date endDate;
    double price;

}
