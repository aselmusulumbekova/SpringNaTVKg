package com.example.springnatvkg.repositories;
import com.example.springnatvkg.models.entities.Discounts;
import com.example.springnatvkg.models.response.DiscountMinDaysResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRep extends JpaRepository<Discounts,Long> {

    @Query(value = "select\n" +
            "    d.min_days as minDays,\n" +
            "    d.percent as percent\n" +
            "from tb_discounts d\n" +
            "where d.channels_id=?1\n" +
            "  and d.min_days<=2?n" +
            "  and d.start_date<current_date\n" +
            "  and (d.end_date> current_date or d.end_date is null)\n" +
            "group by  d.id\n" +
            "order by d.min_days"
            ,nativeQuery = true)
    DiscountMinDaysResponse getDistinct(Long channelId, int dayCount);

}
