package com.wcreators.storerate.mapper;

import com.wcreators.storerate.dto.NoRateActionDTO;
import com.wcreators.storerate.entity.NoRateActionEntity;
import com.wcreators.storerate.model.NoRateAction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface NoRateActionMapper {

    @Mappings({
            @Mapping(target = "date", source = "created")
    })
    NoRateActionEntity modelToEntity(NoRateAction model);

    NoRateAction dtoToModel(NoRateActionDTO dto);
}
