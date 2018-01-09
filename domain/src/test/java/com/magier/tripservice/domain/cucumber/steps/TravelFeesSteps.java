package com.magier.tripservice.domain.cucumber.steps;

import com.magier.tripservice.domain.Destination;
import com.magier.tripservice.domain.TravelFeesRepositoryPort;
import com.magier.tripservice.domain.TravelPriceComputor;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class TravelFeesSteps {

    private Destination destination = new Destination();
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
    public void the_customer_want_to_travel_to(String dest) {
        destination.setName(dest);
    }

    @Given("^the travel fees are (\\d+)€$")
    public void the_travel_fees_are_€(double travelFees) {
        Mockito.when(travelFeesRepository.getTravelFeesByDestination(destination.getName())).thenReturn(travelFees);
    }

    @Given("^the agency fees are (\\d+)€$")
    public void the_agency_fees_are_€(double agencyFees) {
        Mockito.when(travelFeesRepository.getAgencyFeesByDestination(destination.getName())).thenReturn(agencyFees);
    }


    @When("^the system calculate the travel fees$")
    public void the_system_calculate_the_travel_fees() {
        computedPrice = travelPriceComputor.computeTravelPrice(destination.getName());
    }

    @Then("^the travel price is (\\d+)€$")
    public void the_travel_price_is_€(double expectedPrice) {
        assertThat(expectedPrice).isEqualTo(computedPrice);
    }
}
