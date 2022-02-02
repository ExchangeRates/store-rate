package com.wcreators.storerate.mapper;

import com.wcreators.storerate.dto.RateActionDTO;
import com.wcreators.storerate.entity.RateActionEntity;
import com.wcreators.storerate.model.RateAction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RateActionMapper {

    @Mappings({
            @Mapping(target = "date", source = "created")
    })
    RateActionEntity modelToEntity(RateAction model);

    RateAction dtoToModel(RateActionDTO dto);

    @Mappings({
            @Mapping(target = "created", source = "date")
    })
    RateActionDTO entityToDto(RateActionEntity entity);
}
