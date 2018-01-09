package com.magier.tripservice.infrastructure.travel.fees;

import com.magier.tripservice.domain.PriceComputorPort;
import com.magier.tripservice.domain.Destination;
import org.springframework.stereotype.Component;

@Component
public class TravelCostCalculatorDriver {
    private final PriceComputorPort priceComputor;

    public TravelCostCalculatorDriver(final PriceComputorPort priceComputor) {
        this.priceComputor = priceComputor;
    }

    public Integer calculateTravelCosts(String destinationName){
        Destination destination = new Destination();
        destination.setName(destinationName);
        return priceComputor.computeTravelPrice(destinationName);
    }
}
