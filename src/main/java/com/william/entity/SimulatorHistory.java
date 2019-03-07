package com.william.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="simulator_history")
@Data
public class SimulatorHistory {
    @Id
    @GenericGenerator(name="idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String uuid;

    private String serviceId;
    private String request;
    private String response;
    private String country;
    private String env;
    private String type;
    private LocalDateTime  triggerTime;
    private String status;



}
