package com.magier.tripservice.domain;

public interface TravelFeesRepositoryPort {
    Integer getTravelFeesByDestination(Destination destination);

    Integer getAgencyFeesByDestination(Destination destination);
}
