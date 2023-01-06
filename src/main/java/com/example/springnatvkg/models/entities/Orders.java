package com.example.springnatvkg.models.entities;
import com.example.springnatvkg.models.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name="tb_orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String text;
    String name;
    int phone;
    String email;
    double total_price;

    @JsonFormat(pattern = "YYYY.MM.DD")
    Date editDate;
    @JsonFormat(pattern = "YYYY.MM.DD")
    Date addDate;
    OrderStatus status;



}
