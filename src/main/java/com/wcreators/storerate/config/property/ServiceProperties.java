package com.wcreators.storerate.config.property;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("service")
@Data
@Configuration
public class ServiceProperties {

    @NotNull
    private int pageSize;
}
