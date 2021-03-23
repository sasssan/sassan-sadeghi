package com.n26.petstore.clients;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static io.restassured.RestAssured.given;

@Slf4j
public class PetStoreRestClient extends RestClientBase {

    public static final String petEndpoint = "/pet/";
    public static final String findStatus = "findByStatus?status=";
    public static final String nameParam = "name";
    public static final String idParam = "id";
    public static final String statusParam = "status";
    private static AtomicInteger atomicInteger = new AtomicInteger(100);


    @Override
    public String getName() {
        return this.getClass().getSimpleName().replace("RestClient", "");
    }


    /**
     * Returns the list of available pets based on the provided status
     */
    public List<Map> findByStatus(String status) {
        request = given();
        response = request.when().config(config).get(PetStoreURL + petEndpoint + findStatus + status);
        List<Map> petList = response.jsonPath().getList("");
        return petList;
    }


    public void postPet(String name, String status) {
        //TODO can actually check a combination of other attributes like category, photo url
        request = given();
        request.header("Content-Type", "application/json")
                .header("Accept", "application/json");
        JSONObject requestBody = new JSONObject();
        requestBody.put(idParam, atomicInteger.incrementAndGet());
        requestBody.put(nameParam, name);
        requestBody.put(statusParam, status);
        request.body(requestBody);
        response = request.when().config(config).post(PetStoreURL + petEndpoint);
    }

    public void deletePet(int petID) {
        request = given();
        response = request.when().config(config).delete(PetStoreURL + petEndpoint + petID);
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

}
