package com.magier.tripservice.domain;

import org.springframework.stereotype.Service;

@Service
public class TravelPriceComputor implements PriceComputor{

    private TravelFeesRepositoryPort travelFeesRepository;

    public TravelPriceComputor(TravelFeesRepositoryPort travelFeesRepository) {
        this.travelFeesRepository = travelFeesRepository;
    }

    public Integer computeTravelPrice(final Destination destination) {
        return travelFeesRepository.getAgencyFeesByDestination(destination) + travelFeesRepository.getTravelFeesByDestination(destination);
    }
}
