package com.magier.tripservice.domain;

public interface PriceComputor {
    Integer computeTravelPrice(final Destination destination);
}
