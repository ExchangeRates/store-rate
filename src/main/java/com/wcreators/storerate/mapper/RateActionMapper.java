package com.wcreators.storerate.mapper;

import com.wcreators.storerate.dto.RateActionDTO;
import com.wcreators.storerate.entity.RateActionEntity;
import com.wcreators.storerate.model.RateAction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RateActionMapper {

    RateAction entityToModel(RateActionEntity entity);
    RateActionEntity modelToEntity(RateAction model);

    RateAction dtoToModel(RateActionDTO dto);
}
