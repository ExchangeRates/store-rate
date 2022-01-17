package com.wcreators.storerate.kafka.listener;

import com.wcreators.storerate.dto.CupRateDTO;
import com.wcreators.storerate.entity.CupRatePointEntity;
import com.wcreators.storerate.mapper.CupRatePointMapper;
import com.wcreators.storerate.model.CupRatePoint;
import com.wcreators.storerate.repository.cup.CupRatePointRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CupRateListener {

    private final CupRatePointRepository repository;
    private final CupRatePointMapper mapper;

    @KafkaListener(topics = "parsed.CUP-EUR-USD", clientIdPrefix = "parsed")
    public void storeParsedCupRate(CupRateDTO dto) {
        log.info("receive parsed cup rate");
        CupRatePoint point = mapper.dtoToModel(dto);
        log.info("Storing parsed cup {}", point);
        CupRatePointEntity entity = mapper.modelToEntity(point);
        repository.save(entity);
    }
}
