package com.william.service.imp;

import com.william.entity.SimulatorHistory;
import com.william.service.HistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImp  implements HistoryService {
    @Override
    public void log(String serviceid, String request, String response, String env, String country, String type) {

    }

    @Override
    public List<SimulatorHistory> getAll() {
        return null;
    }

    @Override
    public List<SimulatorHistory> getAllHistoryByServiceId(String serviceId) {
        return null;
    }

    @Override
    public boolean accept(String serviceId, boolean isAccepted) {
        return false;
    }
}
