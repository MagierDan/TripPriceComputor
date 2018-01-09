package com.magier.tripservice.exposition.api;

import com.magier.tripservice.domain.PriceComputorPort;
import com.magier.tripservice.domain.Destination;
import com.magier.tripservice.infrastructure.travel.fees.TravelCostCalculatorDriver;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api")
public class TripResource {

    private final TravelCostCalculatorDriver travelCostCalculatorDriver;

    public TripResource(final TravelCostCalculatorDriver travelCostCalculatorDriver) {
        this.travelCostCalculatorDriver = travelCostCalculatorDriver;
    }

    @ApiOperation(value = "Compute travel fees", notes = "Returns the price of a trip")
    @RequestMapping(value = {"/trip/{destination}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> computeFees(
            @PathVariable(value = "destination") String destinationName) {
        try {
            Integer travelPrice = travelCostCalculatorDriver.calculateTravelCosts(destinationName);
            return new ResponseEntity<>(travelPrice, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(-1, HttpStatus.NOT_FOUND);
        }
    }
}
