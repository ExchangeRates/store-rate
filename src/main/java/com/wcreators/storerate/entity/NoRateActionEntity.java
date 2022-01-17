package com.wcreators.storerate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "no_rate_action")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoRateActionEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "major")
    private String major;

    @Column(name = "minor")
    private String minor;

    @Column(name = "date")
    private Date date;

    @Column(name = "stop_action")
    private String stopAction;

    @Column(name = "strategy")
    private String strategy;

    @Column(name = "rate")
    private Double rate;

}
