package com.wcreators.storerate.repository.rate;

import com.wcreators.storerate.entity.RateActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RateActionRepository extends JpaRepository<RateActionEntity, Long> {

    List<RateActionEntity> findAllByStrategy(String strategy);
}
