package com.magier.tripservice.infrastructure.travel.fees;

import com.magier.tripservice.domain.Destination;
import com.magier.tripservice.domain.TravelFeesRepositoryPort;
import org.springframework.stereotype.Repository;

@Repository
public class TravelFeesMockRepositoryAdapter implements TravelFeesRepositoryPort {

    @Override
    public Integer getTravelFeesByDestination(Destination destination) {
        switch (destination.getName()) {
            case "Paris":
                return 250;
            case "Lille":
                return 0;
            case "New-York":
            case "Tokyo":
            case "Beijing":
                return 1000;
            default:
                throw new IllegalArgumentException("Invalid destination: " + destination);
        }
    }

    @Override
    public Integer getAgencyFeesByDestination(Destination destination) {
        switch (destination.getName()) {
            case "Paris":
                return 25;
            case "Lille":
                return 0;
            case "New-York":
            case "Tokyo":
            case "Beijing":
                return 100;
            default:
                throw new IllegalArgumentException("Invalid destination: " + destination);
        }
    }
}
