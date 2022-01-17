package com.wcreators.storerate.kafka.listener;

import com.wcreators.storerate.dto.RateActionDTO;
import com.wcreators.storerate.entity.RateActionEntity;
import com.wcreators.storerate.mapper.RateActionMapper;
import com.wcreators.storerate.model.RateAction;
import com.wcreators.storerate.repository.rate.RateActionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RateActionListener {

    private final RateActionRepository repository;
    private final RateActionMapper mapper;

    @KafkaListener(topics = "action.EUR-USD", clientIdPrefix = "action")
    public void storeActionableRate(RateActionDTO dto) {
        RateAction rateAction = mapper.dtoToModel(dto);
        log.info("Storing action {} for rate {}/{}", rateAction.getAction(), rateAction.getMajor(), rateAction.getMinor());
        RateActionEntity entity = mapper.modelToEntity(rateAction);
        repository.save(entity);
    }
}
