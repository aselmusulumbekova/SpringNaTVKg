package com.example.springnatvkg.repositories;
import com.example.springnatvkg.models.entities.Days;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaysRep extends JpaRepository<Days,Long> {


}
