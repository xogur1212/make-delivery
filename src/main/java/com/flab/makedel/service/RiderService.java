package com.flab.makedel.service;

import com.flab.makedel.dao.DeliveryDAO;
import com.flab.makedel.dto.RiderDTO;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RiderService {

    private final DeliveryDAO deliveryDAO;

    public void registerStandbyRider(RiderDTO rider) {
        deliveryDAO.insertStandbyRider(rider);
    }

    public void deleteStandbyRider(String riderId) {
        deliveryDAO.deleteStandbyRider(riderId);
    }

    public RiderDTO loadStandbyRiderInfo(String riderId) {
        return deliveryDAO.selectStandbyRider(riderId);
    }

    public Set<String> loadStandbyRiderList() {
        return deliveryDAO.selectStandbyRiderList();
    }

    public void acceptStandbyOrder(long orderId, String riderId) {
        deliveryDAO.updateStandbyOrderAndRiderToDelivering(orderId, riderId);
    }

}