package com.example.springnatvkg.repositories;
import com.example.springnatvkg.models.entities.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface PricesRep extends JpaRepository<Prices,Long> {
    @Query(value = """
select p.price from tb_prices p where p.channels_id=?1 and p.start_date<=now()
                            and (p.end_date>now() or p.end_date is null)
order by p.start_date desc limit 1
   
""",nativeQuery = true)
    int findPrice(Long channelId);

}
