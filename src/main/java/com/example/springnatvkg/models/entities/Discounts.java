package com.example.springnatvkg.models.entities;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Entity
@Table(name="tb_discounts")
public class Discounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "channels_id")
    Channels channelsId;
    double percent;
    Date startDate;
    Date endDate;
    int minDays;



}
