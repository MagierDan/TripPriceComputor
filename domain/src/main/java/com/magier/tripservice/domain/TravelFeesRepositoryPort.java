package com.magier.tripservice.domain;

public interface TravelFeesRepositoryPort {
    Integer getTravelFeesByDestination(String destination);

    Integer getAgencyFeesByDestination(String destination);
}
