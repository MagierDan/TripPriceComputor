package com.magier.tripservice.domain.cucumber.steps;

import com.magier.tripservice.domain.PriceComputorPort;
import com.magier.tripservice.domain.Travel;
import com.magier.tripservice.domain.TravelFeesRepositoryPort;
import com.magier.tripservice.domain.TravelPriceComputor;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class TravelFeesSteps {

    private Travel travel=new Travel();
    private TravelFeesRepositoryPort travelFeesRepository;
    private TravelPriceComputor travelPriceComputor;

    private double computedPrice;

    @Before
    public void setup() {
        travelFeesRepository = Mockito.mock(TravelFeesRepositoryPort.class);
        travelPriceComputor = Mockito.spy(TravelPriceComputor.class);

        travelPriceComputor.setPriceComputerPort(travelFeesRepository);
    }

    @Given("^the customer want to travel to \"([^\"]*)\"$")
    public void the_customer_want_to_travel_to(String destination) {
        travel.setDestination(destination);
    }

    @Given("^the travel fees are (\\d+)€$")
    public void the_travel_fees_are_€(double travelFees) {
        Mockito.when(travelFeesRepository.getTravelFeesByDestination(travel.getDestination())).thenReturn(travelFees);
    }

    @Given("^the agency fees are (\\d+)€$")
    public void the_agency_fees_are_€(double agencyFees) {
        Mockito.when(travelFeesRepository.getAgencyFeesByDestination(travel.getDestination())).thenReturn(agencyFees);
    }


    @When("^the system calculate the travel fees$")
    public void the_system_calculate_the_travel_fees() {
        computedPrice = travelPriceComputor.computeTravelPrice(travel.getDestination());
    }

    @Then("^the travel price is (\\d+)€$")
    public void the_travel_price_is_€(double expectedPrice) {
        assertThat(expectedPrice).isEqualTo(computedPrice);
    }
}
