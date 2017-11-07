package com.magier.tripservice.domain;

public interface TravelFeesRepositoryPort {
    double getTravelFeesByDestination(String destination);

    double getAgencyFeesByDestination(String destination);
}
