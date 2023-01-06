package com.example.springnatvkg.models.request;

import com.example.springnatvkg.models.entities.Channels;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelRequest1 {
    Long channelsId;

   List<Date> days;


}
