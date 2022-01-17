package com.wcreators.storerate.mapper;

import com.wcreators.storerate.dto.NoRateActionDTO;
import com.wcreators.storerate.entity.NoRateActionEntity;
import com.wcreators.storerate.model.NoRateAction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoRateActionMapper {

    NoRateActionEntity modelToEntity(NoRateAction model);

    NoRateAction dtoToModel(NoRateActionDTO dto);
}
