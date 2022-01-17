package com.wcreators.storerate.kafka.listener;

import com.wcreators.storerate.dto.NoRateActionDTO;
import com.wcreators.storerate.entity.NoRateActionEntity;
import com.wcreators.storerate.mapper.NoRateActionMapper;
import com.wcreators.storerate.model.NoRateAction;
import com.wcreators.storerate.repository.rate.NoRateActionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NoRateActionListener {

    private final NoRateActionRepository repository;
    private final NoRateActionMapper mapper;

    @KafkaListener(topics = "noAction.EUR-USD", clientIdPrefix = "noAction")
    public void storeNoActionableRate(NoRateActionDTO dto) {
        NoRateAction noRateAction = mapper.dtoToModel(dto);
        log.info("Storing no action {} for rate {}/{}", noRateAction.getStopAction(), noRateAction.getMajor(), noRateAction.getMinor());
        NoRateActionEntity entity = mapper.modelToEntity(noRateAction);
        repository.save(entity);
    }
}
