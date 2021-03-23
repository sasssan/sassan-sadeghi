package com.n26.petstore.steps;

import com.n26.petstore.clients.PetStoreRestClient;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
public class PetSteps {

    private PetStoreRestClient petStoreClient;

    /**
     * Please note that we are using the api's DELETE endpoint to bring the pet store to a fresh state.
     * This is only because pet store is using a hard-coded pet repository that's being loaded on runtime.
     * In production, something like a DB query should be used to delete pets from the repository and using the
     * DELETE endpoint is discouraged because we don't want the test for adding new pets to depend on the DELETE endpoint.
     */
    @Given("^Pet with the name \"([^\"]*)\" and status \"([^\"]*)\" does not exist in the store$")
    public void checkPetNotExists(String petName, String petStatus) {
        log.info("checking if pet already exists!");
        List<Map> pets = petStoreClient.findByStatus(petStatus);
        pets.forEach(pet -> {
            if (petName.equals(pet.get("name"))) petStoreClient.deletePet((int) pet.get("id"));
        });
    }

    @When("^Pet with the name \"([^\"]*)\" and status \"([^\"]*)\" is posted into the pet store API$")
    public void postPetIntoStore(String petName, String petStatus) {
        log.info("adding pet to the store");
        petStoreClient.postPet(petName, petStatus);
    }

    @SneakyThrows
    @Then("The response has the status code {int}")
    public void assertStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, petStoreClient.getStatusCode(), "Unexpected Status Code");
    }

    @SneakyThrows
    @And("^Pet with the name \"([^\"]*)\" and status \"([^\"]*)\" is returned in the findByStatus response$")
    public void assertPetExists(String petName, String petStatus) {
        log.info("checking if pet is added to the store!");
        List<Map> pets = petStoreClient.findByStatus(petStatus);
        Assert.assertTrue(pets.stream().anyMatch(pet -> petName.equals(pet.get("name"))),
                "Failed to add new pet to pet store");
    }

}
