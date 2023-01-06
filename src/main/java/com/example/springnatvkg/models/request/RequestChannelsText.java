package com.example.springnatvkg.models.request;
import com.example.springnatvkg.models.request.ChannelRequest1;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@AllArgsConstructor
public class RequestChannelsText {
    String text;
    @JsonProperty("channels")
  List<ChannelRequest1>dayChannelRequest1;

}
