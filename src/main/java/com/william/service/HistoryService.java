package com.william.service;

import com.william.entity.SimulatorHistory;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HistoryService {

    void log(String serviceid,String request,String response,String env,String country,String type);
    List<SimulatorHistory> getAll();
    List<SimulatorHistory> getAllHistoryByServiceId(String serviceId);
    boolean  accept(String serviceId,boolean isAccepted);

}
