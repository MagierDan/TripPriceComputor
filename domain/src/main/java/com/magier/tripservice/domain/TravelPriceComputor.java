package com.magier.tripservice.domain;

import org.springframework.stereotype.Service;

@Service
public class TravelPriceComputor implements PriceComputorPort {

    private TravelFeesRepositoryPort travelFeesRepository;

    public TravelPriceComputor() {}

    public TravelPriceComputor(TravelFeesRepositoryPort travelFeesRepository) {
        this.travelFeesRepository = travelFeesRepository;
    }

    public double computeTravelPrice(final String destination) {
        return travelFeesRepository.getAgencyFeesByDestination(destination) + travelFeesRepository.getTravelFeesByDestination(destination);
    }

    public void setPriceComputerPort(TravelFeesRepositoryPort travelFeesRepository) {
        this.travelFeesRepository = travelFeesRepository;
    }
}
