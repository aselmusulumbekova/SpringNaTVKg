package com.example.springnatvkg.models.entities;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Entity
@Table(name="tb_channels")
public class Channels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "active")
    Boolean active;
    @Column(name = "order_num")
    int orderNum;
    @Column(name = "photo")
    String photo;


    @PrePersist
    protected void  onCreate(){
        active=true;
    }


}
