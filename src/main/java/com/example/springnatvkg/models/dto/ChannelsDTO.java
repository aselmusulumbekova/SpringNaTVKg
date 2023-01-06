package com.example.springnatvkg.models.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.springnatvkg.models.entities.Channels} entity
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@RequiredArgsConstructor
public class ChannelsDTO implements Serializable {
     Long id;
     String name;
     Boolean active;
     int orderNum;
     String photo;
}