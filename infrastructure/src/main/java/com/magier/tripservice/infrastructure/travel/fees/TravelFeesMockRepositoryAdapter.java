package com.magier.tripservice.infrastructure.travel.fees;

import com.magier.tripservice.domain.Destination;
import com.magier.tripservice.domain.TravelFeesRepositoryPort;
import com.magier.tripservice.domain.error.BusinessErrors;
import com.magier.tripservice.domain.error.BusinessException;
import org.springframework.stereotype.Repository;

@Repository
public class TravelFeesMockRepositoryAdapter implements TravelFeesRepositoryPort {

    @Override
    public Integer getTravelFeesByDestination(Destination destination) {
        return getTravelFeesByDestination(destination.getName());
    }

    public Integer getTravelFeesByDestination(String destinationName) {
        switch (destinationName) {
            case "Paris":
                return 250;
            case "Lille":
                return 0;
            case "New-York":
            case "Tokyo":
            case "Beijing":
                return 1000;
            default:
                throw new BusinessException(BusinessErrors.MISSING_DESTINATION);
        }
    }

    @Override
    public Integer getAgencyFeesByDestination(Destination destination) {
        return getAgencyFeesByDestination(destination.getName());
    }

    public Integer getAgencyFeesByDestination(String destinationName) {
        switch (destinationName) {
            case "Paris":
                return 25;
            case "Lille":
                return 0;
            case "New-York":
            case "Tokyo":
            case "Beijing":
                return 100;
            default:
                throw new BusinessException(BusinessErrors.MISSING_DESTINATION);
        }
    }
}
