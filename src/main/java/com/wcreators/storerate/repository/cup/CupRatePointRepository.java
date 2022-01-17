package com.wcreators.storerate.repository.cup;

import com.wcreators.storerate.entity.CupRatePointEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface CupRatePointRepository extends JpaRepository<CupRatePointEntity, Long> {

    CupRatePointEntity getCupRatePointEntityByStartBeforeAndEndAfter(Date start, Date end);
}
