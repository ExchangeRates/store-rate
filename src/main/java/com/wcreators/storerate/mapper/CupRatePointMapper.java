package com.wcreators.storerate.mapper;

import com.wcreators.storerate.dto.CupRateDTO;
import com.wcreators.storerate.entity.CupRatePointEntity;
import com.wcreators.storerate.model.CupRatePoint;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CupRatePointMapper {

    CupRatePointEntity modelToEntity(CupRatePoint point);
    CupRatePoint entityToModel(CupRatePointEntity entity);

    CupRatePoint dtoToModel(CupRateDTO dto);
}
