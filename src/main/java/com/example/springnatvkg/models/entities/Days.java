package com.example.springnatvkg.models.entities;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Entity
@Table(name="tb_days")
public class Days {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date day;

    @ManyToOne
    @JoinColumn(name = "id_order_details")
    OrderDetail orderDetailId;
}
