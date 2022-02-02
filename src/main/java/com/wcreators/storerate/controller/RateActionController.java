package com.wcreators.storerate.controller;

import com.wcreators.storerate.config.property.ServiceProperties;
import com.wcreators.storerate.constant.Strategy;
import com.wcreators.storerate.dto.RateActionDTO;
import com.wcreators.storerate.entity.RateActionEntity;
import com.wcreators.storerate.mapper.RateActionMapper;
import com.wcreators.storerate.repository.rate.RateActionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RateActionController {

    private final RateActionRepository rateActionRepository;
    private final RateActionMapper mapper;
    private final ServiceProperties serviceProperties;

    @GetMapping("/rate-actions/{strategy}")
    public List<RateActionDTO> getRateActions(
            @PathVariable final String strategy,
            @RequestParam final int page,
            @RequestParam @DateTimeFormat(pattern = "MM.dd.yyyy") final Date from,
            @RequestParam @DateTimeFormat(pattern = "MM.dd.yyyy") final Date to
    ) {
        Optional<Strategy> concreteStrategy = Strategy.strategyByType(strategy);
        if (concreteStrategy.isEmpty()) {
            throw new IllegalArgumentException("Strategy name " + strategy + " is not defined");
        }
        Pageable pageable = PageRequest.of(page, serviceProperties.getPageSize());
        Page<RateActionEntity> pageActions = rateActionRepository.findAllByStrategyAndDateAfterAndDateBefore(
                strategy,
                from,
                to,
                pageable
        );
        return pageActions.get()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/rate-actions/{strategy}/count")
    public int getRateActionsCount(
            @PathVariable final String strategy,
            @RequestParam @DateTimeFormat(pattern = "MM.dd.yyyy") final Date from,
            @RequestParam @DateTimeFormat(pattern = "MM.dd.yyyy") final Date to
    ) {
        Optional<Strategy> concreteStrategy = Strategy.strategyByType(strategy);
        if (concreteStrategy.isEmpty()) {
            throw new IllegalArgumentException("Strategy name " + strategy + " is not defined");
        }
        return rateActionRepository.countAllByStrategyAndDateAfterAndDateBefore(
                strategy,
                from,
                to
        );
    }

}
