package com.example.springnatvkg.repositories;
import com.example.springnatvkg.models.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRep extends JpaRepository<Orders,Long> {
}
