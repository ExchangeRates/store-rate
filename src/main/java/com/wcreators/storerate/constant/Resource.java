package com.wcreators.storerate.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Resource {
    OANDA("OANDA"),
    FOREX("FOREX");

    @Getter
    private final String name;
}
