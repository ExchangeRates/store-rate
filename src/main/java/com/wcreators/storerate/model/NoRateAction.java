package com.wcreators.storerate.model;

import com.wcreators.storerate.constant.Strategy;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@Builder
public class NoRateAction {
    private String major;
    private String minor;
    private String stopAction;
    private Date created;
    private Strategy strategy;
    private double rate;
}
