package com.william.dao;

import com.william.entity.SimulatorHistory;

import java.util.List;

public interface SimulatorHistoryDao {
     boolean log(String serviceid,String request,String response,String env,String country,String type);
     List<SimulatorHistory> getHistoryByServiceId(String serviceId,Integer start,Integer size);
     List<SimulatorHistory> getHistoryByServiceId(String serviceId);
     List<SimulatorHistory> getAllHistory();
     boolean update(String historyId);
}
