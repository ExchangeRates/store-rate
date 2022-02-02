package com.wcreators.storerate.repository.rate;

import com.wcreators.storerate.entity.RateActionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface RateActionRepository extends JpaRepository<RateActionEntity, Long> {

    Page<RateActionEntity> findAllByStrategyAndDateAfterAndDateBefore(
            String strategy, Date from, Date to, Pageable pageable);

    int countAllByStrategyAndDateAfterAndDateBefore(
            String strategy, Date from, Date to);
}
